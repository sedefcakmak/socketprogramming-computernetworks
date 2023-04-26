import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main ( String... args ) throws IOException {
		//creating host and port variables
		String host;
		int port;
		host="localhost";
		port=Integer.parseInt(args[0]); //port is taken as argument
		
		Socket ClientSocket = new Socket ( host, port ); //client socket is created 
		System.out.println(" Client Connected " + ClientSocket);
		
		PrintWriter out = new PrintWriter (ClientSocket.getOutputStream(),true); // to write data into socket
        
        BufferedReader inpstr= new BufferedReader (new InputStreamReader (ClientSocket.getInputStream())); //to read data from socket
        
        BufferedReader stdin =new BufferedReader (new InputStreamReader ( System.in )); //to read the data from keyboard
       
        
        
        String userInput="";
        String serverinput="";
        System.out.println("Client enters message ");
    	userInput = stdin.readLine();
    	out.println(userInput);
    	
        while (userInput!="Exit") { //program should terminate if client types Exit
        	
        	if (serverinput=="Exit") {
        		System.out.println("Server wanted to leave "); //also if server enters the same command program should break and the socket will be closed
        		ClientSocket.close(); 
        		break;
        	}
        	//the input of server is taken and response turn comes to client
        	serverinput = inpstr.readLine(); 
        	System.out.println("Server says " + serverinput);
        	System.out.println("Client enters message ");
        	userInput = stdin.readLine();
        	out.println(userInput);
        	
        
        	
		
        }
        System.out.println("Conncetion closed ");
        ClientSocket.close(); 
		
		
	}




}
