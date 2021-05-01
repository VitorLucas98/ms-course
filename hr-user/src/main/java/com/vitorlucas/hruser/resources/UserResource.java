package com.vitorlucas.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitorlucas.hruser.dto.UserDTO;
import com.vitorlucas.hruser.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		UserDTO userDto = service.findById(id);
		return ResponseEntity.ok(userDto);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<UserDTO> findByEmail(@RequestParam(value = "email", defaultValue = "") String email){
		UserDTO userDTO = service.findByEmail(email);
		return ResponseEntity.ok(userDTO);
	}
}
