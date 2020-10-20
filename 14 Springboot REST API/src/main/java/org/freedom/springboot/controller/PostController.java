package org.freedom.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.freedom.springboot.model.Post;
import org.freedom.springboot.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	PostService postService = new PostService();
	
	@RequestMapping("/posts")
	public List<Post> getPosts(){
		return postService.getPosts();
	}
	
}
