package com.br.mongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.br.mongo.domain.User;
import com.br.mongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.deleteAll();

		User joao = new User(null, "Joao Silva", "jpcallerani@gmail.com");
		User bia = new User(null, "Bia Messias", "biahmessias@gmail.com");
		User mari = new User(null, "Marilene Silva", "maricallerani@gmail.com");
		
		repo.saveAll(Arrays.asList(joao,bia,mari));

	}
}
