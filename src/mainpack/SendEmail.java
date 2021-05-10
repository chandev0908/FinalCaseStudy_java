package mainpack;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;


import javax.activation.*;

public class SendEmail {
	public static void sendMail(String emailFrom, String passFrom, ArrayList<String> fName, ArrayList<String> studentID,
			ArrayList<String> email, ArrayList<String> permitCode, ArrayList<String> permitAvailability,
			ArrayList<String> course, ArrayList<String> phoneNum, ArrayList<String> filepath) {
		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myEmail = emailFrom;
		String myPass = passFrom;

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmail, myPass);
			}
		});
		String subject = "TSU Student ID";
		for (int i = 0; i < fName.size(); i++) {
			try {
				String htmlmail = "<table style =\"background-color:#f5f5f5;width:100%;border-collapse:collapse;border-spacing:0\">"
						+ "        <tbody>" + "            <tr>" + "                <td align=\"center\">"
						+ "                    <table style=\"max-width:100%;width:600px;background-color:transparent;border-collapse:collapse;border-spacing:0\">"
						+ "                        <tbody>" + "                            <tr>"
						+ "                                <td style=\"background-color:#D7D7D7;width:100%;min-width:580px;padding:0px\">"
						+ "                                    <table style=\"width: 100%; padding: 5px 0 5px 0;\">"
						+ "                                        <tbody>"
						+ "                                            <tr align=\"middle\">"
						+ "                                                <td>"
						+ "                                                    <img src=\"cid:tsulogo\" alt=\"\">"
						+ "                                                </td>"
						+ "                                                <td style=\"width: 220;\" align=\"left\">"
						+ "                                                    <img src=\"cid:tsutext\" alt=\"\">"
						+ "                                                </td>"
						+ "                                            </tr>"
						+ "                                        </tbody>"
						+ "                                    </table>"
						+ "                                    <p style=\"width: 100%; height: 4px; background-color: #FFC632; margin: 0;\"></p>"
						+ "                                    <p style=\"width: 100%; height: 4px; background-color: #800000; margin: 0;\"></p>"
						+ "                                    <p style=\"width: 100%; height: 4px; background-color: #FFC632; margin: 0;\"></p>"
						+ "                                    <table style=\"width: 100%; background-color: #800000; padding: 30px 0 30px 0;\">"
						+ "                                        <tbody>"
						+ "                                            <tr>"
						+ "                                                <td align=\"middle\" style=\"width: 220px;\">"
						+ "                                                    <img src=\"cid:image\" alt=\"\" style=\"width: 130px; height: 130px;\">"
						+ "                                                </td>"
						+ "                                                <td align=\"left\">"
						+ "                                                    <table>"
						+ "                                                        <tbody>"
						+ "                                                            <tr>"
						+ "                                                                <td>"
						+ "                                                                    <h5 style=\"color: rgb(240, 240, 240); margin: 10px; font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; font-size: 13.8px;\">Name: "
						+ fName.get(i) + "</h5>"
						+ "                                                                    <h5 style=\"color: rgb(240, 240, 240); margin: 10px; font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; font-size: 13.8px;\">Course: "
						+ course.get(i) + " </h5>"
						+ "                                                                    <h5 style=\"color: rgb(240, 240, 240); margin: 10px; font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; font-size: 13.8px;\">Phone: "
						+ phoneNum.get(i) + "</h5>"
						+ "                                                                    <h5 style=\"color: rgb(240, 240, 240); margin: 10px; font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; font-size: 13.8px;\">Permit Code: "
						+ permitCode.get(i) + "</h5>"
						+ "                                                                    <h5 style=\"color: rgb(240, 240, 240); margin: 10px; font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; font-size: 13.8px;\">Permit Availability: "
						+ permitAvailability.get(i) + "</h5>"
						+ "                                                                </td>"
						+ "                                                            </tr>"
						+ "                                                        </tbody>"
						+ "                                                    </table>"
						+ "                                                </td>"
						+ "                                            </tr>"
						+ "                                        </tbody>"
						+ "                                    </table>"
						+ "                                    <div style=\"background-color: #FFC632; margin: 0;\">"
						+ "                                        <h4 style=\"padding: 12px; margin: 0;\">Student ID: "
						+ studentID.get(i) + "</h4>" + "                                    </div>"
						+ "                                </td>" + "                            </tr>"
						+ "                        </tbody>" + "                    </table>" + "                </td>"
						+ "            </tr>" + "        </tbody>" + "    </table>";
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(myEmail));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.get(i)));
				message.setSubject(subject);
				MimeMultipart multipart = new MimeMultipart();
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setContent(htmlmail, "text/html; charset=utf-8");
				multipart.addBodyPart(messageBodyPart);
				messageBodyPart = new MimeBodyPart();
				DataSource fimg = new FileDataSource(filepath.get(i));
				messageBodyPart.setDataHandler(new DataHandler(fimg));
				messageBodyPart.setHeader("Content-ID", "<image>");
				multipart.addBodyPart(messageBodyPart);
				messageBodyPart = new MimeBodyPart();
				DataSource ftsulogo = new FileDataSource(
						"C:\\Users\\Christian Dev\\Desktop\\Java\\tFCStudy\\FinalCaseStudy\\src\\mainpack\\img\\tsu-logo.png");
				messageBodyPart.setDataHandler(new DataHandler(ftsulogo));
				messageBodyPart.setHeader("Content-ID", "<tsulogo>");
				multipart.addBodyPart(messageBodyPart);
				messageBodyPart = new MimeBodyPart();
				DataSource ftsutext = new FileDataSource(
						"C:\\Users\\Christian Dev\\Desktop\\Java\\tFCStudy\\FinalCaseStudy\\src\\mainpack\\img\\H2-2-.png");
				messageBodyPart.setDataHandler(new DataHandler(ftsutext));
				messageBodyPart.setHeader("Content-ID", "<tsutext>");
				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);
				Transport.send(message);
				JOptionPane.showMessageDialog(null, "Emails is successfully send");
			} catch (MessagingException e) {
				JOptionPane.showMessageDialog(null, "Error " + e);
			}
		}
	}
}
