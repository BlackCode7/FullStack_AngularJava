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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {
	
	//Painel de componentes 1
	private JPanel jPanel = new JPanel( new GridBagLayout()); 
	// Criando a label 2
	private JLabel descricaoHora = new JLabel( "Nome" );
	// CRiando campo de texto - 7
	private JTextField mostraTempo = new JTextField();
	
	private JLabel descricaoHora2 = new JLabel( "E-mail" );
	// CRiando campo de texto - 7
	private JTextField mostraTempo2 = new JTextField();
	
	private JButton jButtonStart = new JButton("Add Lista");
	private JButton jButtonFinal = new JButton("Stop");
	
	private ImplemntacaoFilaThread fila = new ImplemntacaoFilaThread();
	
	
	TelaTimeThread(){
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
		jPanel.add(descricaoHora, gridBagConstraints);
		add(jPanel, BorderLayout.WEST);
		
		//Repetindo processo 4,5,6
		mostraTempo.setPreferredSize( new Dimension(200, 24) );
		gridBagConstraints.gridy ++;
		jPanel.add(mostraTempo, gridBagConstraints);
		
		//***************************************************

		descricaoHora2.setPreferredSize( new Dimension(200, 24) );
		gridBagConstraints.gridy ++;
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		add(jPanel, BorderLayout.WEST);	
		
		mostraTempo2.setPreferredSize( new Dimension(200, 24) );	
		gridBagConstraints.gridy ++;
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
				
				if ( fila == null ) {
					
					fila = new ImplemntacaoFilaThread();
					fila.start();
				}
				
				for ( int qtd = 0; qtd < 100; qtd++ ) {

					// Pegando o nome do objeto
					ObjetoFilaThread filaThread = new ObjetoFilaThread();
					filaThread.setNome(mostraTempo.getText());
					filaThread.setEmail(mostraTempo2.getText() + " - " + qtd);
					
					fila.add(filaThread);
					
				}
				
			}
		}); 
		
		
		//16 - executar o clique do bot?o start
		jButtonFinal.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {	
			    	
				fila.stop();
				fila = null;
			}
		}); 
		
		fila.start();
		add(jPanel, BorderLayout.WEST);
		setVisible(true);
	};

}
