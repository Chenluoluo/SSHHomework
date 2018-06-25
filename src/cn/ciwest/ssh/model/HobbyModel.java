package cn.ciwest.ssh.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HW_hobby")
public class HobbyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	private String hobbyname;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<UserModel> users;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHobbyname() {
		return hobbyname;
	}

	public void setHobbyname(String hobbyname) {
		this.hobbyname = hobbyname;
	}

	public Set<UserModel> getUsers() {
		return users;
	}

	public void setUsers(Set<UserModel> users) {
		this.users = users;
	}

}
