package com.siri.proj.java.onlinevegetablesale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.proj.java.onlinevegetablesale.entity.Admin;
import com.siri.proj.java.onlinevegetablesale.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository   adminRepository;
	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public List<Admin> getAdmin() {
		return adminRepository.findAll();
	}

	public boolean deleteAllAdmins() {
		try {
			adminRepository.deleteAll();
		}
		catch(Exception e) {
		return false;
		}
		return true;
	}

	public Admin updateAdmin(int adminId, Admin obj) {
		
		Optional<Admin>  adminContainer=adminRepository.findById(adminId);
		if(adminContainer.isPresent())
		{
			Admin oldObj=adminContainer.get();
			oldObj.setName(obj.getName());
			System.out.println("Succesfully updated!!!!");
			return adminRepository.saveAndFlush(oldObj);
		}
		else {
			System.out.println("Succesfully Inserted");
			return adminRepository.save(obj);
		}
	}

}
