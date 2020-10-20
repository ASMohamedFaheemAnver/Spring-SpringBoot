package org.freedom.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.freedom.springboot.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	List<Post> posts = new ArrayList<Post>();

	public PostService() {
		super();
		posts.add(new Post(1, "Data", "Body"));
		posts.add(new Post(2, "Data2", "Body2"));
	}
	
	public List<Post> getPosts(){
		return posts;
	}
}
 