import java.io.*;
import java.net.*;

class UDPClient {
	 public static void main(String argv[]) throws Exception {
		System.out.println();
		System.out.println("\t\tClient");
		System.out.println("-----------------------------------------------");
		byte[] data = new byte[1024];
		String Text;
		int port = 9999;
		DatagramPacket packet;
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter IP or nothing for localhost: ");
		String ipAddress = inFromUser.readLine();
		if(ipAddress == "") {
			ipAddress = "localhost";
		}
		DatagramSocket socket = new DatagramSocket();
		  
		while(true){
			System.out.println();
			System.out.println("Enter message: ");
			Text = inFromUser.readLine();
			if(Text.compareTo("Q")== 0) break;
			data = Text.getBytes();
			
			packet = new DatagramPacket(data, data.length, InetAddress.getByName(ipAddress), port);
			socket.send(packet);
			System.out.println("Package sent.");
		  
		}
		  System.out.println("-----------------------------------------------");
	}
}