package com.ShippingApplication.Application.Service;

import com.ShippingApplication.Application.Model.Provider;
import com.ShippingApplication.Application.Model.User;
import com.ShippingApplication.Application.shippingRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public void processOAuthPostLogin(String username) {
		User existUser = repo.getUserByUsername(username);
		
		if (existUser == null) {
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setProvider(Provider.GOOGLE);
			newUser.setEnabled(true);			
			
			repo.save(newUser);
			
			System.out.println("Created new user: " + username);
		}
		
	}
	
}
