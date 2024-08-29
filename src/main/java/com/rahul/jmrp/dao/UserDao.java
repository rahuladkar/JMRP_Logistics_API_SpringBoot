package com.rahul.jmrp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Users;
import com.rahul.jmrp.repository.AddressRepository;
import com.rahul.jmrp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressRepository addressRepository;

	// to add the User
	public Users saveUser(Users user) {
		addressRepository.save(user.getAddress());
		return userRepository.save(user);
	}

	// to get the all User
	public List<Users> getAllUser() {

		return userRepository.findAll();

	}

	// to update the User
	public Users updateUser(Users user) {

		return userRepository.save(user);

	}

	// to delete the User
	public void deleteUserById(int id) {

		Optional<Users> optional = userRepository.findById(id);
		if (optional != null) {

			userRepository.deleteById(id);
			addressRepository.deleteById(optional.get().getAddress().getId());

		}

	}

}
