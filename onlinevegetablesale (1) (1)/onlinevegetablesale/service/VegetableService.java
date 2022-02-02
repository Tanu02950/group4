package com.siri.proj.java.onlinevegetablesale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.siri.proj.java.onlinevegetablesale.entity.Vegetable;
import com.siri.proj.java.onlinevegetablesale.repository.VegetableRepository;

@Service
public class VegetableService {
	@Autowired
	VegetableRepository  vegetableRepository;
	public Vegetable addVegetable(Vegetable vegetable) {
		return vegetableRepository.save(vegetable) ;
	}

	public List<Vegetable> getVegetable() {
		return vegetableRepository.findAll();
	}

	public boolean deleteAllVegetable() {
		try {
			vegetableRepository.deleteAll();
		}
		catch(Exception e) {
		return false;
	}
		return true;
	}

	public Vegetable updateVegetable(int vegId, Vegetable obj) {
		Optional<Vegetable>  vegContainer=vegetableRepository.findById(vegId);
		if(vegContainer.isPresent())
		{
			Vegetable oldObj=vegContainer.get();
			oldObj.setPrice(obj.getPrice());
			System.out.println("Succesfully updated!!!!");
			return vegetableRepository.saveAndFlush(oldObj);
		}
		else {
			System.out.println("Succesfully Inserted");
			return vegetableRepository.save(obj);
		}
	}

	public Vegetable getVegetableById(int vegId) {
		Optional<Vegetable>  vegetableContainer= vegetableRepository.findById(vegId);
		if(vegetableContainer.isPresent())
		{
			return vegetableContainer.get();
		}
		else {
			return null;
		}
	}

}

