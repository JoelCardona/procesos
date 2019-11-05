package tema1;

public class SeccionCritica {

	
	package tema1;

	import java.util.concurrent.Semaphore;

	class Cuenta{
		
		
		private long cuantia = 0;
		
		public void incrementar() {
		
			cuantia = cuantia + 1;
			
		}

		public long getCuantia() {
			return cuantia;
		}

		public void setCuantia(long cuantia) {
			this.cuantia = cuantia;
		}
		
	}

	class Runnable_cuantia implements Runnable{
		
	Cuenta cuantia;
	Semaphore sem;


	public Runnable_cuantia(Cuenta cuantia, Semaphore semaphore) {
		this.cuantia = cuantia;
		this.sem = semaphore;
	}


	public void run() {
		
		
	}


	public class SeccionCritica{
		
		
	}
		

	private static int number_of_threads = 1000;
	sumadores[] = new Thread [number_of_threads];
	private static Thread  threads_sumadores[] = new Thread [number_of_threads];
	private static Semaphore semaphore = new Semaphore (1);
	private static Cuenta cuantia = new Cuenta ();


	public static void main(String[]args) {
		
		for (int i = 0; i<number_of_threads; i++) {
			threads_sumadores[i] = new Thread (new Runnable_cuantia (cuantia, semaphore));
			threads_sumadores[i].start();
		}
		
		for (int i = 0; i < number_of_threads; i++) {
			
			threads_sumadores[i].join();
			
		}    
		
	}

	
	
}
