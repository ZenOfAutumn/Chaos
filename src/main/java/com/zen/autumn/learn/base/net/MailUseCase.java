package com.zen.autumn.learn.base.net;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.common.base.Charsets;

public class MailUseCase {
	
	public static void main(String[] args) throws IOException, AddressException, MessagingException {
		Properties props = new Properties();
		
		try(InputStream in = Files.newInputStream(Paths.get(".","mail.properties"))){
			
			props.load(in);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> lines = Files.readAllLines(Paths.get("mailcontent.properties"),Charsets.UTF_8);
		
		String from = lines.get(0);
		String to = lines.get(1);
		String subject = lines.get(2);
		StringBuilder builder = new StringBuilder();
		for(int i =3;i<lines.size();i++){
			builder.append(lines.get(i)).append('\n');
		}
				
		String password = "wuliang19901112";		
		Session mailSession = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(mailSession);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setText(builder.toString());
		
		Transport tr = mailSession.getTransport();
		
		try{
			tr.connect(null,password);
			tr.sendMessage(message,message.getAllRecipients());
		}finally{
			tr.close();
		}	
		
	}

}
