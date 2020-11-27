package com.jiacheng.schoolweb.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jiacheng.schoolweb.models.Role;
import com.jiacheng.schoolweb.models.Student;
import com.jiacheng.schoolweb.repositories.RoleRepository;
import com.jiacheng.schoolweb.repositories.StudentRepository;

public class CustomStudentDetailsService implements UserDetailsService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Student student = studentRepository.findByEmail(email);  
        if(student != null) {
            List<GrantedAuthority> authorities = getUserAuthority(student.getRoles());
            return buildUserForAuthentication(student, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
	}
	private List<GrantedAuthority> getUserAuthority(Set<Role> studentRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        studentRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(Student student, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(student.getEmail(), student.getPassword(), authorities);
    }
}