package cn.ciwest.ssh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HW_blog")
public class BlogModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	private String title;
	private String author;
	private String type;
	private String decoration;
	private String create_time;
	private String alter_time;
	private String text;
	@ManyToOne(targetEntity=UserModel.class)  
	@JoinColumn(name = "number",updatable=false,insertable=false,nullable=true)
	private UserModel userModel;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDecoration() {
		return decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getAlter_time() {
		return alter_time;
	}

	public void setAlter_time(String alter_time) {
		this.alter_time = alter_time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
}
