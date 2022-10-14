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

		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("criacaoemaildetestecomjava@gmail.com", "Anderson Martins",
																"Título do envio de email", "Texto para envio de e-mail com java");
		
		enviaEmail.enviarEmail();
		
		
		Thread.sleep(5000);

	}

}
