package com.dunamis.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dunamis.workshopmongo.domain.User;
import com.dunamis.workshopmongo.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {

		
		return userRepository.findAll();
	}
}
