package com.siri.proj.java.onlinevegetablesale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.siri.proj.java.onlinevegetablesale.entity.Cart;
import com.siri.proj.java.onlinevegetablesale.entity.Customer;
import com.siri.proj.java.onlinevegetablesale.entity.Vegetable;

import com.siri.proj.java.onlinevegetablesale.exception.CustomerNotFoundException;
import com.siri.proj.java.onlinevegetablesale.exception.VegetableIdNotFoundException;
import com.siri.proj.java.onlinevegetablesale.exception.VegetableListEmptyException;
import com.siri.proj.java.onlinevegetablesale.repository.CartRepository;
import com.siri.proj.java.onlinevegetablesale.repository.CustomerRepository;
import com.siri.proj.java.onlinevegetablesale.repository.VegetableRepository;


@Service
public class CartService {
	@Autowired
	CartRepository  cartRepository;
	@Autowired
	VegetableRepository  vegetableRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	
	public Cart createCart(Cart cart) {
		
		
		List<Vegetable>  vegetableList =cart.getVegetable();
		if(vegetableList.size()>0)
		{
			List<Vegetable> newVegetableList= new ArrayList<>();
			for(int i=0;i<vegetableList.size();i++)
			{
				Optional<Vegetable> vegetableContainer = vegetableRepository.findById(vegetableList.get(i).getVegId());
				if(!(vegetableContainer.isPresent()))
				{
					throw new VegetableIdNotFoundException("vegetableId is not found");
				}
				else {
					newVegetableList.add(vegetableContainer.get());
					//cart.getVegetable().add(vegetableContainer.get());
				}
			}
			cart.setVegetable(newVegetableList);
		}
		else {
			throw new VegetableListEmptyException("Vegetable List is Empty");
		}
		
		
	
		Customer  customer =cart.getCustomer();
		int customerId=customer.getCustomerId();
		if(customerId>0)
		{
			Optional<Customer> customerContainer = customerRepository.findById(customerId);
			if(customerContainer.isPresent())
			{
				cart.setCustomer(customerContainer.get());
			}
			else {
				throw new CustomerNotFoundException("customer is not found");
			}
		}
		
		
		return cartRepository.save(cart);
	}

	public List<Cart> getCart() {
		return cartRepository.findAll();
	}

	public boolean deleteAllCarts() {
		try {
			cartRepository.deleteAll();
		}
		catch(Exception e) {
		return false;
	}
		return true;
	}

	public Cart updateCart(int cartId, Cart obj) {
		Optional<Cart>  cartContainer=cartRepository.findById(cartId);
		if(cartContainer.isPresent())
		{
			Cart oldObj=cartContainer.get();
			oldObj.setVegetable(obj.getVegetable());
			System.out.println("Succesfully updated!!!!");
			return cartRepository.saveAndFlush(oldObj);
		}
		else {
			System.out.println("Succesfully Inserted");
			return cartRepository.save(obj);
		}
	}
	}

