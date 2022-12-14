package email.java_maven.emailjavaMaven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

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
		
		// Parte 1 do email
		MimeBodyPart corpoEmail = new MimeBodyPart();		
		
		if( envioHTML ) {//Verifica se tem tags html, se tiver ele manda mensagem formatada em html
			corpoEmail.setContent(textoEmail, "text/html; charset=utf-8"); 
		}
		else {//Se não tiver html no corpo da mensagem ele não envia mensagem formatada em html
			corpoEmail.setText(textoEmail);
		}
		
		// Lista de arquivos para enviar por email - que podem vir do banco de dados
		List<FileInputStream> arquivos = new ArrayList<FileInputStream>();
		arquivos.add(simuladorDePDF());
		arquivos.add(simuladorDePDF());
		arquivos.add(simuladorDePDF());
		arquivos.add(simuladorDePDF());
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(corpoEmail);
	
		int index =0;
		for ( FileInputStream fileInputStream : arquivos) {
			// Parte 2 do email
			MimeBodyPart anexoEmail = new MimeBodyPart();					
			//anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(fileInputStream, "application/pdf")));
			anexoEmail.setFileName("anexoemail"+index+".pdf");
			multipart.addBodyPart(anexoEmail);
			index++;
		}
		
		
		message.setContent(multipart);
		
		javax.mail.Transport.send(message);

	}
	
	/* Esse método simula o PDF ou qualquer arquivo que possa ser enviado por anexo no email.
	  Voce pode pegar o arquino no seu banco de dados base64, byte[], Stream de Arquivos.
	  Pode estar e um banco de dados, ou SAMPLE em uma pasta,*/	    
	private FileInputStream simuladorDePDF () throws Exception{
		
		Document document = new Document();
	    File file = new File("fileanexo.pdf");
	    file.createNewFile();
	    PdfWriter.getInstance(document, new FileOutputStream(file));
	    document.open();
	    document.add(new Paragraph("Conteudo do PDF anexo com Java Mail, esse texto é do PDF"));
	    document.close();
	    
	    return new FileInputStream(file);
	}

	

}
