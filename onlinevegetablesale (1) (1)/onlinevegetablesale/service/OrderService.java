package com.siri.proj.java.onlinevegetablesale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.proj.java.onlinevegetablesale.entity.Order;
import com.siri.proj.java.onlinevegetablesale.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository  orderRepository;
	public Order addOrder(Order order) {
		return orderRepository.save(order) ;
	}

	public List<Order> getOrder() {
		return orderRepository.findAll();
	}

	public boolean deleteAllOrders() {
		try {
			orderRepository.deleteAll();
			
		}
		catch(Exception e) {
		return false;
	}
		return true;
	}

	public Order updateOrders(int orderNo, Order obj) {
		Optional<Order>  orderContainer=orderRepository.findById(orderNo);
		if(orderContainer.isPresent())
		{
			Order oldObj=orderContainer.get();
			oldObj.setStatus(obj.getStatus());
			System.out.println("Succesfully updated!!!!");
			return orderRepository.saveAndFlush(oldObj);
		}
		else {
			System.out.println("Succesfully Inserted");
			return orderRepository.save(obj);
		}
	}
	}


