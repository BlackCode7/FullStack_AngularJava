package threadsTesteDoJaba;

import java.security.SecureRandom;

public class ThreadsTesteDoJaba_1 implements Runnable{

	private static final SecureRandom generator = new SecureRandom();
	private final int sleepTime;
	private final String taskName; 
	
	public ThreadsTesteDoJaba_1(String taskName) {
		this.taskName = taskName;		
		sleepTime = generator.nextInt(5000); // milissegundos
	}
	
	public void run() {		
		try {
			System.out.printf("%s going to sleep for %d milliseconds.%n", taskName, sleepTime);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt(); // reinterrompe a thread
		}		
		// imprime o nome da tarefa
		System.out.printf("%s done sleeping%n", taskName); 
	}

}
