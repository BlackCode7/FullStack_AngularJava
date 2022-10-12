package threadsTesteDoJaba;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsTesteDoJaba {
	
	//08007224433   40044433

	public static void main(String[] args) {
		
		ThreadsTesteDoJaba_1 task_1 = new ThreadsTesteDoJaba_1("Task_1");
		ThreadsTesteDoJaba_1 task_2 = new ThreadsTesteDoJaba_1("Task_2");
		ThreadsTesteDoJaba_1 task_3 = new ThreadsTesteDoJaba_1("Task_3");

		System.out.println("Starting Executor");
		
		// cria ExecutorService para gerenciar threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// inicia as três PrintTasks
		executorService.execute(task_1); // inicia task1ÿ
		executorService.execute(task_2); // inicia task2ÿ
		executorService.execute(task_3); // inicia task3ÿ

		// fecha ExecutorService -- ele decide quando fechar threads
		executorService.shutdown();

		System.out.printf("Tasks started, main ends.%n%n");
		
	}

}
