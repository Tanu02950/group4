package com.siri.proj.java.onlinevegetablesale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.siri.proj.java.onlinevegetablesale.entity.User;
import com.siri.proj.java.onlinevegetablesale.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository  userRepository;
	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUser() {
		return userRepository.findAll();
	}

	public boolean deleteAllUsers() {
		try {
			userRepository.deleteAll();
		}
		catch(Exception e) {
		return false;
	}
		return true;
	}

	public User updateUsers(String userId, User obj) {
		Optional<User>  userContainer=userRepository.findById(userId);
		if(userContainer.isPresent())
		{
			User oldObj=userContainer.get();
			oldObj.setPassword(obj.getPassword());
			System.out.println("Succesfully updated!!!!");
			return userRepository.saveAndFlush(oldObj);
		}
		else {
			System.out.println("Succesfully Inserted");
			return userRepository.save(obj);
		}
	}
	}


