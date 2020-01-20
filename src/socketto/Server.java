package socketto;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server 
{
	public static void main(String[] args)
	{
		ServerSocket serverSocket=null;
		Socket connection;
		Countdown count = new Countdown();
		
		try {
			serverSocket = new ServerSocket(2000);
			System.out.println("In attesa di connessione...");
			serverSocket.setSoTimeout(5000);
			count.start();
			Socket socket = serverSocket.accept();
			System.out.println("Connessione stabilita");
			System.out.println("Socket Server: " + socket.getLocalSocketAddress());
			System.out.println("Socket Client: " + socket.getRemoteSocketAddress());
		} catch (IOException ex) {
			try {
				System.out.println("Errore nella chiusura della connessione");
				serverSocket.close();
			} catch (IOException ex1) {
				Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex1);
			}
		}
		
		try {
			if(serverSocket!=null)
				serverSocket.close();
		} catch (IOException ex) {
			System.out.println("Erriore nella chiusura della connessione");
		}
		System.out.println("Connessione chiusa");
		count.interrupt();
	}
}
