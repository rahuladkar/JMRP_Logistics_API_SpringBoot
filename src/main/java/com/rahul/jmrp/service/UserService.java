package com.rahul.jmrp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.jmrp.dao.UserDao;
import com.rahul.jmrp.entity.Users;
import com.rahul.jmrp.response.structure.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<Users>> saveUser(Users user) {

		Users recieveUser = userDao.saveUser(user);

		ResponseStructure<Users> responseStructure = new ResponseStructure<Users>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Success...!");
		responseStructure.setData(recieveUser);

		return new ResponseEntity<ResponseStructure<Users>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<List<Users>>> getAllUser() {

		List<Users> users = userDao.getAllUser();

		ResponseStructure<List<Users>> responseStructure = new ResponseStructure<List<Users>>();

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMeassage("User Found...!");
		responseStructure.setData(users);

		return new ResponseEntity<ResponseStructure<List<Users>>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Users>> updateUser(Users user) {

		Users recieveUser = userDao.updateUser(user);

		ResponseStructure<Users> responseStructure = new ResponseStructure<Users>();

		responseStructure.setStatusCode(HttpStatus.RESET_CONTENT.value());
		responseStructure.setMeassage("Updated...!");
		responseStructure.setData(recieveUser);

		return new ResponseEntity<ResponseStructure<Users>>(responseStructure, HttpStatus.RESET_CONTENT);

	}

	public String deleteUserById(int id) {

		userDao.deleteUserById(id);

		return "User with id " + id + " is deleted successfully...!";

	}

}
