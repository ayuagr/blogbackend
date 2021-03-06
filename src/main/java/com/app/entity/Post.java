package com.app.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "post")
public class Post {
	private Integer pId;
	private String blogTitle;
	private String body,description;
	private Date createdAtPost;
	private boolean published;
	private byte[] image;
	private User user;
	private Category category;
	private long views;
	private List<Comments> comments;

	
	public Post() {
		System.out.println("inside ctor of "+getClass().getName());
	}

	public Post(String blogTitle, String body, String description, Date createdAtPost, boolean published,long views) {
		super();
		this.blogTitle = blogTitle;
		this.body = body;
		this.description = description;
		this.createdAtPost = createdAtPost;
		this.published = published;
		
		this.views = views;
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}
    @Column(length = 100)
	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
    @Column(length = 500)
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    @Temporal(TemporalType.DATE)
	public Date getCreatedAtPost() {
		return createdAtPost;
	}

	public void setCreatedAtPost(Date createdAtPost) {
		this.createdAtPost = createdAtPost;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
    @Lob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getViews() {
		return views;
	}

	public void setViews(long views) {
		this.views = views;
	}
	

	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [pId=" + pId + ", blogTitle=" + blogTitle + ", body=" + body + ", description=" + description
				+ ", createdAtPost=" + createdAtPost + ", published=" + published + ", user=" + user + ", category="
				+ category + ", views=" + views + "]";
	}
	
	

}
