package ThreadsJava;

import javax.swing.JOptionPane;

public class ExemploDeThreadsJAVA {

	public static void main(String[] args) throws InterruptedException {
		
		// TRHEAD CONCORRENTE - 1
		Thread threadEmail = new Thread(thread1);
		threadEmail.start();
		
		Thread threadNotaFiscal = new Thread(thread2);
		threadNotaFiscal.start();
				
		/* c�digo que continua rodando por tr�s */
		System.out.println(" Fim da execu��o do c�digo! ");
		/* Aqui pode ser o programa rodando para o usuario */
		JOptionPane.showMessageDialog(null, "Sistema em execu��o para o usu�rio");
	}
	
	private static Runnable thread2 = new Runnable() {
		@Override
		public void run() {
			for( int pos =0; pos < 10; pos++ ) {	
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
				System.out.println("Executando rotina, envio de Nota fiscal!");						
			}			
		}		
	};
	
	private static Runnable thread1 = new Runnable() {
		@Override
		public void run() {			
			/* C�digo da rotina para executar em paralelo */
			for( int pos =0; pos < 10; pos++ ) {						
				//Isso aqui � a thread do java
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				/* executar o envio com tempo de parada */
				System.out.println("Executando rotina, envio de email!");						
			}			
		}		
	};
	
}


















