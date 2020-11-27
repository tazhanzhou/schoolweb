package com.jiacheng.schoolweb.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long role_id;

	private String role;

	@ManyToMany(mappedBy = "roles")
	private Set<Student> students;

	public Long getId() {
		return role_id;
	}

	public void setId(Long id) {
		this.role_id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setUsers(Set<Student> students) {
		this.students = students;
	}

}
