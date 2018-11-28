package com.br.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	User findByNameContainingIgnoreCase(String text);
}
