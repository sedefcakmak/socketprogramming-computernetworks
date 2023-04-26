import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main ( String... args ) throws IOException {
		//port and timeout varibles declared
		int port;
		int timeout;
		//both port and timout taken as argument
		port=Integer.parseInt(args[0]);
		timeout=Integer.parseInt(args[1]);
		
		ServerSocket serverSocket =  new ServerSocket(port); //welcoming socket is created
		serverSocket.setSoTimeout(timeout); //timeout for server is set
		System.out.println("Connected " +serverSocket);
		Socket socket = serverSocket.accept();
		System.out.println("Server Connected to client socket "+ socket); //server prints the adress of the client socket
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //to write into client socket
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //to read the data from client
		BufferedReader outstr =new BufferedReader (new InputStreamReader ( System.in )); //to take input from server keyboard


	
		String clientinput="";
		String serverinput="";
		
		while (serverinput!="Exit") { // action should terminate if server enters exit
			clientinput=in.readLine();
			if (clientinput=="Exit") { //program should terminate and socket will be closed if client says exit
				System.out.println("Client wanted to leave");
				socket.close();
				break;
			}
			//client input is taken and printed, server will reply
			System.out.println("client says "+clientinput);
			System.out.println("Server enters response ");
			serverinput= outstr.readLine();
			out.println(serverinput);
	
		}
		
		System.out.println("Server wanted to leave");
		socket.close();
		
	
	}


}
