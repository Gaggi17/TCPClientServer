package socketto;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client 
{
	public static void main(String[] args)
	{
		Socket socket = null;
		
		try {
			socket = new Socket("127.0.0.1",2000);
		} catch (ConnectException e) {
			System.err.println("Il server non è disponibile");
		} catch (UnknownHostException e1) {
			System.err.println("Errore DNS");
		} catch (IOException e2) {
			System.err.println("Errore Input");
		}
		
		try {
			if(socket!=null)
			socket.close();
		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
}
