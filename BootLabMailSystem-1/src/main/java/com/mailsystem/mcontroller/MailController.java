package com.mailsystem.mcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mailsystem.service.MailServiceImple;

@Controller
public class MailController {
	@Autowired
	private MailServiceImple mails;
	public String controller( String msg,String Email) throws Exception {
		String status = mails.mailUser(msg, Email);
		return msg + "-->"+status;
		
	}
}
