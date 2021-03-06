package com.app.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.app.dto.UserDto;

@Entity
@Table(name = "user")
public class User {
private Integer userId;
private String name,email,password,gender;
private UserRole role;
private Date created_at;
private byte[] image;
private long contact;
private boolean deleted;
private List<Post> posts;
private List<Comments> comments;

public User() {
	System.out.println("inside ctor of "+getClass().getName());
}

public User(String name, String email, String password, String gender, UserRole role, Date created_at, long contact) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.gender = gender;
	this.role = role;
	this.created_at = created_at;
	this.contact = contact;
}

public User(UserDto details) {
	this.name=details.getName();
	this.email=details.getEmail();
	this.password=details.getPassword();
	this.gender=details.getGender();
	this.contact=details.getContact();
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}

@Column(length = 20)
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Column(unique = true)
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Column(nullable = false)
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Column(length = 20)
public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}


@Enumerated(EnumType.STRING)
public UserRole getRole() {
	return role;
}

public void setRole(UserRole role) {
	this.role = role;
}

@Temporal(TemporalType.DATE)
@Column(name = "created_time")
public Date getCreated_at() {
	return created_at;
}

public void setCreated_at(Date created_at) {
	this.created_at = created_at;
}

@Lob
public byte[] getImage() {
	return image;
}

public void setImage(byte[] image) {
	this.image = image;
}

public long getContact() {
	return contact;
}

public void setContact(long contact) {
	this.contact = contact;
}


public boolean isDeleted() {
	return deleted;
}

public void setDeleted(boolean deleted) {
	this.deleted = deleted;
}


@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
public List<Post> getPosts() {
	return posts;
}

public void setPosts(List<Post> posts) {
	this.posts = posts;
}


@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
public List<Comments> getComments() {
	return comments;
}

public void setComments(List<Comments> comments) {
	this.comments = comments;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", gender="
			+ gender + ", role=" + role + ", created_at=" + created_at + ", contact=" + contact + "]";
}

}
