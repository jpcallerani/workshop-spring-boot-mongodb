package com.br.mongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User joao = new User("1", "Joao Silva", "jpcallerani@gmail.com");
		User bia = new User("2", "Bia Messias", "biahmessias@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(joao, bia));
		return ResponseEntity.ok().body(list);
	}
}
