package com.vitorlucas.hruser.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorlucas.hruser.dto.UserDTO;
import com.vitorlucas.hruser.entities.User;
import com.vitorlucas.hruser.repositories.UserRepository;
import com.vitorlucas.hruser.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> entity = repository.findById(id);
		User user = entity.orElseThrow(() -> new ResourceNotFoundException("id not found"));
		return new UserDTO(user, user.getRoles());
	}
	
	@Transactional(readOnly = true)
	public UserDTO findByEmail(String email) {
		Optional<User> entity = repository.findByEmail(email);
		User user = entity.orElseThrow(() -> new ResourceNotFoundException("email not found"));
		return new UserDTO(user, user.getRoles());
	}
}
