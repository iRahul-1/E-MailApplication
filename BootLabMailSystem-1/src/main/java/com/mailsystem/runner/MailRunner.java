package com.mailsystem.runner;

import java.io.Closeable;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.mailsystem.BootLabMailSystem1Application;
import com.mailsystem.model.User;
import com.mailsystem.service.MailServiceImple;

public class MailRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(BootLabMailSystem1Application.class, args);
		MailServiceImple ms = ctx.getBean(MailServiceImple.class);
		Scanner sc = new Scanner(System.in);
		User u = new User();
		while(true) {
		System.out.println("Enter choice:"+"\n"+"1.login"+"\n"+"2.Register"+"\n"+"3.exit");
		int c = sc.nextInt();
		switch(c) {
		case 1: System.out.println("Enter username:");
		        String userName = sc.next();
		        System.out.println("Enter password: ");
		        String password = sc.next();
			int findUser = ms.findUser(userName, password);
		        if(findUser==1) {
		        	System.out.println("user logged in successfully.");
		        	try {
		        		System.out.println("how many emails you want to send:");
		        		int es = sc.nextInt();
//		        		System.out.println("enter mails to send your message:");
//		        		String [] mails = new String[es];
//		        		for(int i = 0 ; i< mails.length ; i++) {
//		        			System.out.println("enter "+i+1+" email:");
//		        			mails[i]=sc.next();
//		        		}
		        		System.out.println("wait for 5 seconds: ");
		    			String msg = ms.mailUser("hello this is rahul", u.getEMail());
		    			System.out.println(msg);
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
		        }else {
		        	System.out.println("user not found.");
		        } break;
		case 2: 
			System.out.println("enter user name: ");
		       String username = sc.next();
		       System.out.println("Enter first name:");
		       String first = sc.next();
		       System.out.println("Enter last name:");
		       String last = sc.next();
		       System.out.println("Enter Email:");
		       String email = sc.next();
		       System.out.println("Enter phone number:");
		       long phone = sc.nextLong();
		       System.out.println("Enter password:");
		       String pass = sc.next();
		       System.out.println("Enter confirm password:");
		       String cpass = sc.next();
		       User u1 = new User(phone, username, first, last, email, pass);
		       ms.saveUser(u1); 
		       break;
		case 3: System.out.println("exited!!");
			sc.close();
	       ((Closeable) ctx).close();
	       System.exit(0);       
		default : System.out.println("Enter valid input");
		}	
	}
		
	}

}
