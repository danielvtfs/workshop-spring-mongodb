package com.dunamis.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dunamis.workshopmongo.domain.User;
import com.dunamis.workshopmongo.dto.UserDTO;
import com.dunamis.workshopmongo.repositories.UserRepository;
import com.dunamis.workshopmongo.services.exception.ObjectNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(),userDto.getEmail());
	}
	
	
}
