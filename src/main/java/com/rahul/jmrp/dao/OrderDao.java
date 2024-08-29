package com.rahul.jmrp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Orders;
import com.rahul.jmrp.repository.OrderRepository;

@Repository
public class OrderDao {

	@Autowired
	private OrderRepository orderRepository;
	
	// to add the Order
	public Orders saveOrder(Orders order) {
				
		return orderRepository.save(order);
	}

	// to get the all Order
	public List<Orders> getAllOrders() {
		
		return orderRepository.findAll();

	}

	// to update the Order
	public Orders updateOrder(Orders order) {

		return orderRepository.save(order);
	}

	// to delete the Order
	public void deleteOrderById(int id) {

		orderRepository.deleteById(id);

	}

}
