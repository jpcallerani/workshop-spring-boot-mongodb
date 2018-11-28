package com.br.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.mongo.domain.User;
import com.br.mongo.repository.UserRepository;
import com.br.mongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	/**
	 * 
	 * @return
	 */
	public List<User> findAll() {
		return repo.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public User findById(String id ) {
		 Optional<User> obj = repo.findById(id);  
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
