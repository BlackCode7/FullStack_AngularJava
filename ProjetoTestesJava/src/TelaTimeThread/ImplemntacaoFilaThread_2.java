package TelaTimeThread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplemntacaoFilaThread_2 extends Thread{

	// 21 - para manipula??o de objetos na fila de threads
		private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();
		
		// 22 - criando um metodo para adicionar objetos na fila
		public static void add( ObjetoFilaThread objetoFilaThread ) {
			pilha_fila.add(objetoFilaThread);
		}
		
		// 23 - chama o run() para processar as threads
		@Override
		public void run() {
			
			// 24 - chama o iterador
			Iterator iteracao = pilha_fila.iterator();
			
			// 31 - bloqueia o acesso a lista por outros processos
			// OBS : ? como isolar este processo para que outra thread n?o invada esta thread
			synchronized (iteracao) {
				
				// 25 - enquanto tiver dados na thread de listas ele vai executar 
				while( iteracao.hasNext() ) {
					
					// 26 - chamando sempre o proximo dado da itera??o
					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();
					
					// 27 - Aqui podemos fazer uma lista enorme de processos PDF/email - 
					// aqui podemos chamar o processo mais pesado da aplica??o
					
					System.out.println("**************************************************");
					System.out.println(processar.getEmail());
					System.out.println(processar.getNome());
					
					
					// 28 - remover
					iteracao.remove();
					
					// 29 - dando uma pausa para que a thread complete a tarefa e fa?a a descarga de mem?ria
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					// 30 - limpeza de mem?ria
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
				}
				
			}
			

		
		}
	
}
