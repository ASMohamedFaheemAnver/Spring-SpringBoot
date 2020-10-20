package org.freedom.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.freedom.springboot.model.Post;
import org.freedom.springboot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public PostService() {
		super();

	}

	public List<Post> getPosts() {
		return (List<Post>) postRepository.findAll();
	}

	public Post getPost(int post_id) {
		return postRepository.findById(post_id).get();
	}

	public void addPost(Post post) {
		postRepository.save(post);
	}

	public void updatePost(Post post) {
		postRepository.save(post);
	}

	public void deletePost(int post_id) {
		postRepository.deleteById(post_id);
	}
}
