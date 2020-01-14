import java.io.*;
import java.net.*;

class UDPServer {
 public static void main(String argv[]) throws Exception {
	System.out.println();
	System.out.println("\t\tUDPServer");
	System.out.println("-----------------------------------------------");
	
	int port = 9999;
	String input;
	byte[] buff = new byte[1024];
	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter nothing for localhost or something for Host.");
	input = inFromUser.readLine();
	DatagramSocket socket;

	if(input.compareTo("")==0) {
		socket = new DatagramSocket(port, InetAddress.getLoopbackAddress());
	} 
	else {
	socket = new DatagramSocket(port, InetAddress.getLocalHost());
	}
	

	System.out.println("Server running and listening on "+ socket.getLocalAddress() + ":"+socket.getLocalPort());
	System.out.println("");
	 
	 
	while(true) {
		DatagramPacket packet = new DatagramPacket(buff, buff.length);
		socket.receive(packet);

		System.out.println("Daten vom Cient mit der IP: "+packet.getAddress()+" vom Port: "+packet.getPort()+ " mit der Länge: "+packet.getLength()+" empfangen.");
		System.out.println("Daten: "+ new String(packet.getData(),0, packet.getLength()));
		System.out.println("");
	 }
	 
 }
}