package email.java_maven.emailjavaMaven;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.event.TransportEvent;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sun.jdi.connect.Transport;

import net.bytebuddy.implementation.bytecode.Throw;

@SpringBootTest
class EmailjavaMavenApplicationTests {
	
	private String userName = "CriacaoEmailDeTesteComJava@gmail.com";
	private String senha = "CriacaoEmailDeTesteComJava_";

	@Test
	public void testeEmail() {
	
		/* olhar as configurações do SMTP do meu email */
		
		/* Testando commit com sourcetree */		
		
		try {
			/* Configuração das propriedades */
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");//Autorização
			properties.put("mail.smtp.starttls", "true");//Autenticação
			properties.put("mail.smtp.host", "smtp.gmail.com");//servidor de email do google
			properties.put("mail.smtp.port", "465");//Porta do servidor google
			properties.put("mail.smtp.socketFactory.port", "465");// Identifica a porta que se conecta pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//Classe socket de conexão ao smtp
			
			// Configura as credenciais do meu email
			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {				
				//@Override
				//protected PasswordAuthentication getPasswordAuthentication() {
				//	return new PasswordAuthentication(userName, senha);
				//}
				
			});
			
			// Configura as credencias do email que vai receber a mensagem
			Address[] toUser = InternetAddress.parse("CriacaoEmailDeTesteComJava@gmail.com, b166er1980@gmail.com");
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));// quem esta enviando
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Chegou email enviado automaticamento pelo JAVA !");
			message.setText("Ola tudo bem, estou te enviando um email com java!");
			
			javax.mail.Transport.send(message);
			
			/* Teste do SOURCETREE */
			
		} catch (Exception e) {
			e.printStackTrace();			
		} 
		
		
	}
	
	
	
	
}
