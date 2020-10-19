package org.freedom.model;

public class User {
	private String id;
	private String email;
	private boolean verified_email;
	private String picture;

	public User() {
		super();
	}

	public User(String id, String email, boolean verified_email, String picture) {
		super();
		this.id = id;
		this.email = email;
		this.verified_email = verified_email;
		this.picture = picture;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVerified_email() {
		return verified_email;
	}

	public void setVerified_email(boolean verified_email) {
		this.verified_email = verified_email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", verified_email=" + verified_email + ", picture=" + picture
				+ "]";
	}

}
