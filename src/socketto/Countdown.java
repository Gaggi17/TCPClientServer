package socketto;

public class Countdown extends Thread
{
	public void run(){
		for(int c=5000;c>0;c-=1000){
			boolean stop = Thread.currentThread().isInterrupted();
			try {
				sleep(1000);
				System.out.println(c);
				if(stop){
					break;
				}
			} catch (InterruptedException ex) {
				System.out.println("ERRORE!!");
			}
		}
	}
}
