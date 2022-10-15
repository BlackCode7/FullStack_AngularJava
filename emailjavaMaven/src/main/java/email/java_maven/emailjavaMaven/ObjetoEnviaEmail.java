package email.java_maven.emailjavaMaven;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {

	private String userName = "CriacaoEmailDeTesteComJava@gmail.com";
	private String senha = "CriacaoEmailDeTesteComJava_";
	
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	
	Session session;
	
	public ObjetoEnviaEmail( String listaDestinatarios, String nomeRemetente,
			String assuntoEmail, String textoEmail) {
		
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}
	
	public void enviarEmail( boolean envioHTML ) throws Exception {

		/* Configuração das propriedades */
		Properties properties = new Properties();

		properties.put("mail.smtp.ssl.trust", "*");
		properties.put("mail.smtp.auth", "true");// Autorização
		properties.put("mail.smtp.starttls", "true");// Autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com");// servidor de email do google
		properties.put("mail.smtp.port", "465");// Porta do servidor google
		properties.put("mail.smtp.socketFactory.port", "465");// Identifica a porta que se conecta pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// Classe socket de conexão ao
																							// smtp

		// Configura as credenciais do meu email
		session = Session.getInstance(properties, new javax.mail.Authenticator() {
			//@Override
			//protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				//return PasswordAuthentication(userName, senha);
			//}

		});

		// Configura as credencias do email que vai receber a mensagem
		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente));// quem esta enviando
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject(assuntoEmail);
		
		if( envioHTML ) {//Verifica se tem tags html, se tiver ele manda mensagem formatada em html
			message.setContent(textoEmail, "text/html; charset=utf-8"); 
		}
		else {//Se não tiver html no corpo da mensagem ele não envia mensagem formatada em html
			message.setText(textoEmail);
		}
		

		javax.mail.Transport.send(message);

	}

	

}
