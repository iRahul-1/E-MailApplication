package com.mailsystem.service;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mailsystem.model.User;
import com.mailsystem.repo.ISendMailRepo;

import jakarta.mail.internet.MimeMessage;
@Service
public class MailServiceImple implements IMailService{
	@Autowired
	private ISendMailRepo smr;
	@Autowired
	private JavaMailSender sender ;
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Override
	public String mailUser(String msg,String Email) throws Exception{
	String status = sendMail(msg,Email);
		return msg +"--->"+status;
	}
	public void saveUser(User user) {
		
		smr.save(user);
		System.out.println("user created successfully.");
	}
	public int findUser(String username,String Password) {
		Iterable<User> findAll = smr.findAll();
		for(User user : findAll) {
			if(user.getUsername().equals(username)&&user.getPassword().equals(Password)) {
				return 1;
			}
		}
		return 0;
	}
	
	private String sendMail(String msg,String Emails) throws Exception{
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(fromEmail);
		helper.setCc(Emails);
		helper.setSubject("Open it");
		helper.setSentDate(new Date());
		helper.setText(msg);
		helper.addAttachment("user.jpg", new ClassPathResource("user.jpg"));
		sender.send(message);
		return "mail sent";
		
	}
	

}
