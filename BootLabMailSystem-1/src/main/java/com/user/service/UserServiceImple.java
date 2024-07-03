package com.user.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.mail.SendEmailToUserImple;
import com.user.model.User;
import com.user.repo.IUserRepo;
@Service
public class UserServiceImple implements IUserService{
	@Autowired
	private IUserRepo userRepo;
	@Autowired
	private SendEmailToUserImple sendMail;
	
	public void saveUser(User user,String cEmail,String cPass) throws Exception {
		if(user.getEMail().equals(cEmail)&&user.getPassword().equals(cPass)) {
		User save = userRepo.save(user);
		if(save!=null) {
			   System.out.println("wait for 5 seconds");
			   sendMail.mailUser("User Registered successfully: ", user.getEMail());
		}
		else {System.out.println("Registration Failed!");}
		}
		else {System.out.println("user not found.");}

	}
	public void findUser(String username,String Password) {
		Iterable<User> findAll = userRepo.findAll();
		for(User user : findAll) {
			if(user.getUsername().equals(username)&&user.getPassword().equals(Password)) {
				System.out.println("user logged in: "+user.getFirstName());
			}
		}
		
	}
	
	
	

}
