package com.user.runner;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.user.model.User;
import com.user.service.UserServiceImple;
@Component
public class UserRunner implements CommandLineRunner{
	@Autowired
	UserServiceImple userService ;
	@Override
	public void run(String... args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("Enter choice:"+"\n"+"1.login"+"\n"+"2.Register"+"\n"+"3.exit");
		int c = sc.nextInt();
		switch(c) {
		case 1: System.out.println("Enter username:");
		        String userName = sc.next();
		        System.out.println("Enter password: ");
		        String password = sc.next();
		        userService.findUser(userName, password);
		        break;
		case 2: 
			   System.out.println("enter user name: ");
		       String username = sc.next();
		       System.out.println("Enter first name:");
		       String first = sc.next();
		       System.out.println("Enter last name:");
		       String last = sc.next();
		       System.out.println("Enter Email:");
		       String email = sc.next();
		       System.out.println("Enter confirm Email:");
		       String cemail = sc.next();
		       System.out.println("Enter phone number:");
		       long phone = sc.nextLong();
		       System.out.println("Enter password:");
		       String pass = sc.next();
		       System.out.println("Enter confirm password:");
		       String cpass = sc.next();
		       User user = new User(phone, username, first, last, email, pass);
		       userService.saveUser(user, cemail, cpass);
		       break;
		case 3: System.out.println("exited!!");sc.close();System.exit(0);       
		default : System.out.println("Enter valid input");
		}	
	}
		
	}

}
