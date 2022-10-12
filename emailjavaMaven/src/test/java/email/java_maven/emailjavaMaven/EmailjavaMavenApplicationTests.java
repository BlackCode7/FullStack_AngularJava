package email.java_maven.emailjavaMaven;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailjavaMavenApplicationTests {

	@Test
	public void testeEmail() {
	
		/* olhar as configurações do SMTP do meu email */
		
		/* Configuração das propriedades */
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");//Autorização
		properties.put("mail.smtp.starttls", "true");//Autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com");//servidor de email do google
		properties.put("mail.smtp.port", "465");//Porta do servidor google
		properties.put("mail.smtp.socketFactory.port", "465");// Identifica a porta que se conecta pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//Classe socket de conexão ao smtp
		
	}
	
	
	
	
}
