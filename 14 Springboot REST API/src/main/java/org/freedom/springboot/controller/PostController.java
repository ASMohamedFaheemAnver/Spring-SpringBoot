package org.freedom.springboot.controller;

import java.util.List;

import org.freedom.springboot.model.Post;
import org.freedom.springboot.service.PostService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	PostService postService = new PostService();

	@RequestMapping("/posts")
	public List<Post> getPosts() {
		return postService.getPosts();
	}

	@RequestMapping("/post/{post_id}")
	public Post getPost(@PathVariable int post_id) {
		return postService.getPost(post_id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/post")
	public void addPost(@RequestBody Post post) {
		postService.addPost(post);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/post")
	public void updatePost(@RequestBody Post post) {
		postService.updatePost(post);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/post/{post_id}")
	public void deletePost(@PathVariable int post_id) {
		postService.deletePost(post_id);
	}

}
