package com.br.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.mongo.domain.Post;
import com.br.mongo.dto.AuthorDTO;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContainingIgnoreCase(String text);

	List<Post> findByUser(AuthorDTO user);

}
