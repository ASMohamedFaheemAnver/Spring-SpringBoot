package org.freedom.springboot.repository;

import org.freedom.springboot.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends  CrudRepository<Post, Integer> {
}
