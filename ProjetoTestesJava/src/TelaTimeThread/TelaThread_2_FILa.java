package TelaTimeThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaThread_2_FILa  extends JDialog{


	//Painel de componentes 1
		private JPanel jPanel = new JPanel( new GridBagLayout()); 
		// Criando a label 2
		private JLabel descricaoHora = new JLabel( "Time Thread 1" );
		// CRiando campo de texto - 7
		private JTextField mostraTempo = new JTextField();
		
		private JLabel descricaoHora2 = new JLabel( "Time Thread 2" );
		// CRiando campo de texto - 7
		private JTextField mostraTempo2 = new JTextField();
		
		private JButton jButtonStart = new JButton("Start");
		private JButton jButtonFinal = new JButton("Final");
		
		
		// 12
		private Runnable thread1 =  new Runnable() {		
			@Override
			public void run() {
				while (true) {
					mostraTempo.setText( new SimpleDateFormat("dd/MM/yyyy hh:mm.ss")
							.format(Calendar.getInstance().getTime()));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		// 17 - criando a segunda thread2
		private Runnable thread2 =  new Runnable() {		
			@Override
			public void run() {
				while (true) {
					mostraTempo2.setText( new SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
							.format(Calendar.getInstance().getTime()));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		//13
		private Thread thread1Time;
		//18
		private Thread thread2Time;
		
		
		TelaThread_2_FILa(){
			setTitle("Titulo da tela de contagem de tempo");
			setSize(240, 300);
			setLocationRelativeTo(null);
			setResizable(false);
			
			// formador de telas - controlando o poisicioanmento - 3
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.insets = new Insets(5,10,5,5);
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			
			// adicionando paineis no swing - 4
			descricaoHora.setPreferredSize( new Dimension(200, 24) );
			// Posicioanado o  campo   na  grade - 5
			jPanel.add(descricaoHora, gridBagConstraints);
			//Posicionando o layout a esquerda da tela - 6
			add(jPanel, BorderLayout.WEST);		
			//Repetindo processo 4,5,6
			mostraTempo.setPreferredSize( new Dimension(200, 24) );
			// Andando para a segunda posi??o na coluna y comgridBagConstraints ++ - 8
			gridBagConstraints.gridy ++;
			//Travando a edi??o do campo - 11
			mostraTempo.setEditable(false);
			jPanel.add(mostraTempo, gridBagConstraints);
			
			//***************************************************
			
			// adicionando paineis no swing - 4
			descricaoHora2.setPreferredSize( new Dimension(200, 24) );
			// Andando para a segunda posi??o na coluna y comgridBagConstraints ++ - 8
			gridBagConstraints.gridy ++;
			// Posicioanado o  campo   na  grade - 5
			jPanel.add(descricaoHora2, gridBagConstraints);
			//Posicionando o layout a esquerda da tela - 6
			add(jPanel, BorderLayout.WEST);		
			//Repetindo processo 4,5,6
			mostraTempo2.setPreferredSize( new Dimension(200, 24) );
			// Andando para a segunda posi??o na coluna y comgridBagConstraints ++ - 8
			gridBagConstraints.gridy ++;
			//Travando a edi??o do campo - 11
			mostraTempo.setEditable(false);
			jPanel.add(mostraTempo2, gridBagConstraints);

			//****************************************************
			
			gridBagConstraints.gridwidth = 1;		
			//jButtonStart //jButtonFinal - 9
			jButtonStart.setPreferredSize( new Dimension( 92, 25 ));
			gridBagConstraints.gridy ++;
			jPanel.add(jButtonStart, gridBagConstraints);		
			//jButtonStart //jButtonFinal - 10
			jButtonFinal.setPreferredSize( new Dimension( 92, 25));
			gridBagConstraints.gridx ++;
			jPanel.add(jButtonFinal, gridBagConstraints);
			
			
			//14 executar o clique do bot?o start
			jButtonStart.addActionListener( new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {				
					// 15 - chamando a thread
					thread1Time = new Thread(thread1);
					thread1Time.start();				
					// 16 - executar o click do bot?o final
					thread2Time = new Thread(thread2);
					thread2Time.start();
					// 19 - desabilitando botao stop ao apertar start
					jButtonStart.setEnabled(false);
					jButtonFinal.setEnabled(true);			
				}
			}); 
			
			
			//16 - executar o clique do bot?o start
			jButtonFinal.addActionListener( new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {	
				    //17 - executar o click do bot?o final
					thread1Time.stop();
					thread2Time.stop();
					// 20 - desabilitando botao start ao aperta stop
					jButtonStart.setEnabled(true);
					jButtonFinal.setEnabled(false);		
				}
			}); 
			
			// 18 - desabilitando botao stop ao iniciar a tela
			jButtonFinal.setEnabled(false);		
			
			setVisible(true);
		};
	
}


