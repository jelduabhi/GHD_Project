package org.govstack.framework;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendEmailWithAttachment {
    public static void main(String[] args) {
        // Sender's email address
        String from = "qavaluser@ghd.com";
        // Receiver's email address
        String to = "gurvinder.singh@ghd.com";
        // Outlook SMTP server settings
        String host = "smtp.office365.com";
        String port = "587";
        // Email credentials
        String username = "qavaluser@ghd.com";
        String password = "2<6R-e%PFul7>8!ki6956366";

        // Create properties for the session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Create a session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create MimeMessage object
            Message message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            // Set Subject: header field
            message.setSubject("Email with Attachment from JavaMail");

            // Create MimeBodyPart for text content
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("This is a message with attachment.");

            // Create MimeBodyPart for attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filename = "D:\\Gov_Gurvinder\\Main Branch\\target\\allure-report\\index.html"; // Replace with actual file path
            DataSource source = new FileDataSource(filename);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(filename);

            // Create Multipart object and add MimeBodyParts to it
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            // Set the content for the message
            message.setContent(multipart);

            // Send message
            Transport.send(message);

            System.out.println("Email with attachment sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}