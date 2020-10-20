package org.freedom.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.freedom.springboot.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	private static List<Post> posts = new ArrayList<>(
			Arrays.asList(new Post(1, "Data", "Body"), new Post(2, "Data2", "Body2")));

	public PostService() {
		super();

	}

	public List<Post> getPosts() {
		return posts;
	}

	public Post getPost(int post_id) {
		Post post = new Post();
		for (Post tP : posts) {
			if (tP.getPost_id() == post_id) {
				post = tP;
			}
		}
		return post;
	}

	public void addPost(Post post) {
		posts.add(post);
	}

	public void updatePost(Post post) {
		for (Post tP : posts) {
			if (tP.getPost_id() == post.getPost_id()) {
				posts.remove(tP);
				posts.add(post);
			}
		}
	}

	public void deletePost(int post_id) {
		Post post = new Post();
		for (Post tP : posts) {
			if (tP.getPost_id() == post_id) {
				posts.remove(tP);
			}
		}
	}
}
