package com.br.mongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.mongo.domain.Post;
import com.br.mongo.domain.User;
import com.br.mongo.dto.AuthorDTO;
import com.br.mongo.resources.util.URL;
import com.br.mongo.services.PostService;
import com.br.mongo.services.UserService;

@RestController
@RequestMapping(value = "/posts")
public class PostResouce {

	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findAll() {
		List<Post> list = postService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/usersearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByUser(@RequestParam(value = "user", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		User user = userService.findByName(text);
		AuthorDTO author = new AuthorDTO(user);
		List<Post> list = postService.findByUser(author);
		return ResponseEntity.ok().body(list);
	}
}
