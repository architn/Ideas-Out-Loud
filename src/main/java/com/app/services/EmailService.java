package com.app.services;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.stereotype.Component;

import javax.activation.*;

@Component
public class EmailService {
	
	 public void SendEmailOfAccountVerification(String recepient, String username)
	    {

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	     properties.put("mail.smtp.auth", "true");
	     properties.put("mail.smtp.starttls.enable", "true");
	     properties.put("mail.smtp.host", "smtp.gmail.com");
	     properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	     properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
	     properties.put("mail.smtp.port", "587");
	       
	     
	        final String senderEmailID = "aedprojectgroup@gmail.com";
	        final String password = "aedproject100";
	      // Get the default Session object.
	        Session session = Session.getDefaultInstance(properties, new Authenticator()
	        {
	             @Override
	             protected PasswordAuthentication getPasswordAuthentication()
	             {
	                 return new PasswordAuthentication(senderEmailID, password);
	             }
	        });
	      
	       try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(senderEmailID));

	         // Set To: header field of the header.
	         message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));

	         // Set Subject: header field
	         message.setSubject("Twitter Account Verified for :  @"+username);

	         // Now set the actual message
	  
	        // Get the date using calendar object;
	  
	        // Convert the date into a
	        // string using format() method
	         message.setText("Congratulations, \nThis is a message on behalf of Twitter Admin Team. Your Twitter account has been verified"
	                         + "\n\n Thanks, \n Twitter Admin Team");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	    }
}
