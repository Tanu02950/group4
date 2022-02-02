package com.siri.proj.java.onlinevegetablesale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.proj.java.onlinevegetablesale.entity.Address;
import com.siri.proj.java.onlinevegetablesale.entity.BillingDetails;
import com.siri.proj.java.onlinevegetablesale.exception.AddressNotFoundException;
import com.siri.proj.java.onlinevegetablesale.repository.AddressRepository;
import com.siri.proj.java.onlinevegetablesale.repository.BillingDetailsRepository;


@Service
public class BillingDetailsService {
	
	@Autowired
	BillingDetailsRepository  billingDetailsRepository;
	@Autowired
	AddressRepository addressRepository;

	public BillingDetails createBillingDetails(BillingDetails  billingDetails) {
		
		Address address=billingDetails.getBuildingAddress();
		int addressId=address.getAddressId();
		if(addressId>0)
		{
			Optional<Address> addressContainer= addressRepository.findById(addressId);
			if(addressContainer.isPresent())
			{
				billingDetails.setBuildingAddress(addressContainer.get());
			}
			else {
				throw new AddressNotFoundException("Address is not found");
			}
		}
		
		return  billingDetailsRepository.save(billingDetails);
	}

	public List<BillingDetails> getBillingDetails() {
		return billingDetailsRepository.findAll();
	}

	public boolean deleteAllBillingDetails() {
		try {
			billingDetailsRepository.deleteAll();
		}
		catch(Exception e) {
		return false;
	}
		return true;
	}

	public BillingDetails updateBillingDetails(int buildingId, BillingDetails obj) {
		Optional<BillingDetails>  bdContainer=billingDetailsRepository.findById(buildingId);
		if(bdContainer.isPresent())
		{
			BillingDetails oldObj=bdContainer.get();
			oldObj.setTransactionStatus(obj.getTransactionStatus());
			System.out.println("Succesfully updated!!!!");
			return billingDetailsRepository.saveAndFlush(oldObj);
		}
		else {
			System.out.println("Succesfully Inserted");
			return billingDetailsRepository.save(obj);
		}
	}
	}


