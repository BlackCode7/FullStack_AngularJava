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

	@Test
	public void testeEmail() throws Exception {
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		
		// Construindo o html do corpo da mensagem
		stringBuilderTextoEmail.append("Olá, este é o teste de envio de e-mail <br/>");
		stringBuilderTextoEmail.append("<h5> Segue em anexo os arquivos da análise do Balcão Único </h5> <br/>");
		stringBuilderTextoEmail.append("<h5> Estes arquivos são enviados para Maria Célia e Regina Travassos </h5> <br/>");
		// Se quiser acrescentar mais mensagens ao corpo -  FAZER AQUI
		
		
		stringBuilderTextoEmail.append("<a target=\"blank\" href=\"https://github.com/BlackCode7/FullStack_AngularJava/blob/main/README.md\"> Acesse o meu repositório ! </a>");
		
		ObjetoEnviaEmail enviaEmail = 
				new ObjetoEnviaEmail("criacaoemaildetestecomjava@gmail.com", 
									"Anderson Martins",
									"Título do envio de email", 									
									stringBuilderTextoEmail.toString());
	
		enviaEmail.enviarEmail(true);
		
		
		Thread.sleep(5000);

	}

}
