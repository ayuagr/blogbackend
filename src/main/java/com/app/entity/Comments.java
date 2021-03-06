package com.app.entity;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "comments")
public class Comments {
	
	
	private Integer cmId;
	private User user;
	private Post post;
	private String comment;
	private Date createdAt;
	
	public Comments() {
		System.out.println("inside ctor of "+getClass().getName());
	}

	public Comments(String comment, Date createdAt) {
		super();
		this.comment = comment;
		this.createdAt = createdAt;
	}
    
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cm_id")
	public Integer getCmId() {
		return cmId;
	}

	public void setCmId(Integer cmId) {
		this.cmId = cmId;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User userId) {
		this.user = userId;
	}

	@ManyToOne
	@JoinColumn(name = "post_id")
	public Post getPost() {
		return post;
	}

	public void setPost(Post postId) {
		this.post = postId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Comments [cmId=" + cmId + ", userId=" + user + ", postId=" + post + ", comment=" + comment
				+ ", createdAt=" + createdAt + "]";
	}
	
	
}
