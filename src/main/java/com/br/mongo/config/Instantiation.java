package com.br.mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.br.mongo.domain.Post;
import com.br.mongo.domain.User;
import com.br.mongo.dto.AuthorDTO;
import com.br.mongo.repository.PostRepository;
import com.br.mongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PostRepository postRepo;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

		userRepo.deleteAll();
		postRepo.deleteAll();

		User joao = new User(null, "Joao Silva", "jpcallerani@gmail.com");
		User bia = new User(null, "Bia Messias", "biahmessias@gmail.com");
		User mari = new User(null, "Marilene Silva", "maricallerani@gmail.com");

		userRepo.saveAll(Arrays.asList(joao, bia, mari));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(bia));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(bia));

		postRepo.saveAll(Arrays.asList(post1, post2));

	}
}
