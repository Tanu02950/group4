package com.siri.proj.java.onlinevegetablesale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.proj.java.onlinevegetablesale.entity.Address;
import com.siri.proj.java.onlinevegetablesale.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository   addressRepository;

	public Address createAddress(Address address) {
		
		return addressRepository.save(address);
	}

	public List<Address> getAddress() {
		
		return addressRepository.findAll();
	}

	public boolean deleteAllAddress() {
		try {
			addressRepository.deleteAll();
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

	public Address updateAddress(int addressId, Address obj) {
		
		Optional<Address> addContainer=addressRepository.findById(addressId);
		if(addContainer.isPresent())
		{
			Address oldObj=addContainer.get();
			oldObj.setCity(obj.getCity());
			oldObj.setState(obj.getState());
			System.out.println("Succsefully updated");
			return addressRepository.saveAndFlush(oldObj);
			
		}
		else {
		System.out.println("Succesfully Inserted");
		return addressRepository.save(obj);
	}
	}
}


