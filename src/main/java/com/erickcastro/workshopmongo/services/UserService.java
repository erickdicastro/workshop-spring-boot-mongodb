package com.erickcastro.workshopmongo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickcastro.workshopmongo.domain.User;
import com.erickcastro.workshopmongo.dto.UserDTO;
import com.erickcastro.workshopmongo.repository.UserRepository;
import com.erickcastro.workshopmongo.services.exception.ObjectNoFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();	
	}
	
	public User findById(String id) {
	    return repo.findById(id)
	    .orElseThrow(() -> new ObjectNoFoundException("Objeto não encontrado para o ID: " + id));
	}
	
	public User insert (User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
}
