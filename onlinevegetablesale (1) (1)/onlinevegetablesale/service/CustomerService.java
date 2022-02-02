package com.siri.proj.java.onlinevegetablesale.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.proj.java.onlinevegetablesale.entity.Address;
import com.siri.proj.java.onlinevegetablesale.entity.Customer;
import com.siri.proj.java.onlinevegetablesale.exception.AddressNotFoundException;
import com.siri.proj.java.onlinevegetablesale.repository.AddressRepository;
import com.siri.proj.java.onlinevegetablesale.repository.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository   customerRepository;
	@Autowired
	AddressRepository  addressRepository;
	
	public Customer createCustomer(Customer customer) {
		Address address=customer.getAddress();
		int addressId=address.getAddressId();
		if(addressId>0)
		{
			Optional<Address> addressContainer = addressRepository.findById(addressId);
			if(addressContainer.isPresent())
			{
				customer.setAddress(addressContainer.get());
			}
			else {
				throw new AddressNotFoundException("Address is not found");
			}
		}
		
		return  customerRepository.save(customer);
	}

	public List<Customer> getCustomer() {
		return customerRepository.findAll();
	}

	public boolean deleteAllCustomers() {
		try {
			customerRepository.deleteAll();
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}

	public Customer updateCustomer(int customerId, Customer obj) {
		Optional<Customer>  custContainer=customerRepository.findById(customerId);
		if(custContainer.isPresent())
		{
			Customer oldObj=custContainer.get();
			oldObj.setEmailId(obj.getEmailId());
			System.out.println("Succesfully updated!!!!");
			return customerRepository.saveAndFlush(oldObj);
		}
		else {
			System.out.println("Succesfully Inserted");
			return customerRepository.save(obj);
		}
	}

}
