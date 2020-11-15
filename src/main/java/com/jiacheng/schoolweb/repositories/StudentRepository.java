package com.jiacheng.schoolweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jiacheng.schoolweb.models.Student;

public interface StudentRepository  extends JpaRepository<Student, Long> {
	
	Student findByEmail(final String email);
}
