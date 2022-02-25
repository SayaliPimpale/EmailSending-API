package com.email.service;

//
//import javax.mail.Authenticator;
//import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage;

//import javax.mail.Session;



import org.apache.logging.log4j.message.Message;
import org.springframework.boot.rsocket.server.RSocketServer.Transport;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject,String message,String to) {
		 boolean f=false;
		String senderEmail="pimpalesayali@gmail.com";
		String host="smtp.gmail.com";
		Properties properties= System.getProperties();
		
		properties.put("mail.smpt.host",host);

		properties.put("mail.smpt.host","465");

		properties.put("mail.smpt.ssl.enable","true");
		

		properties.put("mail.smpt.auth","true");
		
		
//		Session session=Session.getInstance(properties, new Authenticator() 
		Session session=Session.getInstance(properties,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("pimpalesayali@gmail.com","Missyoupapa@143");
			}
			
		});
		
		session.setDebug(true);
		
		MimeMessage m = new MimeMessage(session);
		
		
		try {
		
		
		//from email
		m.setFrom(senderEmail);
		
		//adding recipient to message
		//m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	//    m.addRecipient();
		//adding subject to message
		m.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
		m.setSubject(subject);
		m.setText(message); 
		//Transport.send(m);
	
		
		
		
	
	
		System.out.println("Sent success...................");

		f=true;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
			
	
}
