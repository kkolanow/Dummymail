import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Mailer {

	static String mailerPort = "12345";
	static String numberOfEmails = "40";

	
	public void gwtSetup() throws Exception {


		String dummyMailProd ="156.24.67.220";
		String localhost = "localhost";

		String content = getContentBuffered();
		for (int i = 0; i < Integer.parseInt(numberOfEmails); i++) {

			send(localhost, "test@gmail.com",
					"test@gtk.gtech.com", "Junit message "+i,content );

		}




	}

	private String getContent() throws FileNotFoundException {
		return new Scanner(new File("email.content2.txt")).useDelimiter("\\Z").next();
	}

	private String getContentBuffered() throws IOException {
		File file = new File("email.content2.txt");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));

		StringBuffer stringBuffer = new StringBuffer();
		String line = null;

		while((line =bufferedReader.readLine())!=null){

			stringBuffer.append(line).append("\n");
		}

		bufferedReader.close();

		return stringBuffer.toString();
	}




	private void send(String smtpServer, String to, String from,
			String subject, String body) throws Exception {

			java.util.Properties props = System.getProperties();
			props.put("mail.smtp.host", smtpServer);
			props.put("mail.smtp.port", mailerPort);
			Session session = Session.getDefaultInstance(props);

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.setSubject(subject);
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setText(body,"UTF-8");
			msg.setSentDate(new Date());




			session.getTransport("smtp");
			Transport.send(msg);
			System.out.println("Message sent OK. "+body);
		
	}

	public static void main(String[] args) {

		if (args.length>0) {
			mailerPort = args[0];
		}
		if (args.length>1) {
			numberOfEmails = args[1];
		}
		Mailer m = new Mailer();
		try {
			m.gwtSetup();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
