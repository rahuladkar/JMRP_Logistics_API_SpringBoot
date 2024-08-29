package com.rahul.jmrp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.jmrp.dao.OrderDao;
import com.rahul.jmrp.entity.Orders;
import com.rahul.jmrp.response.structure.ResponseStructure;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public ResponseEntity<ResponseStructure<Orders>> saveOrder(Orders order) {

		order.setDateOfOrder(LocalDate.now());
		order.getLoading().setLoadingDate(LocalDate.now());
		order.getLoading().setLoadingTime(LocalTime.now());
		order.getUnloading().setUnloadingDate(LocalDate.now());
		order.getUnloading().setUnloadingTime(LocalTime.now());

		// to save the all information of the order
		Orders recieveOrder = orderDao.saveOrder(order);

		ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Success...!");
		responseStructure.setData(recieveOrder);

		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrder() {

		List<Orders> orders = orderDao.getAllOrders();

		ResponseStructure<List<Orders>> responseStructure = new ResponseStructure<List<Orders>>();

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMeassage("Order Found...!");
		responseStructure.setData(orders);

		return new ResponseEntity<ResponseStructure<List<Orders>>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Orders>> updateOrder(Orders order) {

		Orders recieveOrder = orderDao.updateOrder(order);

		ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();

		responseStructure.setStatusCode(HttpStatus.RESET_CONTENT.value());
		responseStructure.setMeassage("Updated...!");
		responseStructure.setData(recieveOrder);

		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.RESET_CONTENT);

	}

	public String deleteOrderById(int id) {

		orderDao.deleteOrderById(id);

		return "Order with id " + id + " is deleted successfully...!";

	}

}
