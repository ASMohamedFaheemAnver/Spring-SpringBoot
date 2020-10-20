package org.freedom.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	private int post_id;
	private String title;
	private String body;

	public Post() {
		super();

	}

	public Post(int post_id, String title, String body) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.body = body;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", title=" + title + ", body=" + body + "]";
	}

}
