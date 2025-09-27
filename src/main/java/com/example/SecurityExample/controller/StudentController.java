package com.example.SecurityExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SecurityExample.model.Students;
import com.example.SecurityExample.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping("/students")
	public ResponseEntity<List<Students>> getStudents() {
		List<Students> list = service.getAllStudents();
		return new ResponseEntity<List<Students>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/csrf")
	public CsrfToken geCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PostMapping("/students")
	public ResponseEntity<Students> addStudent(@RequestBody Students student) {
		Students students = service.addStudent(student);
		return new ResponseEntity<Students>(students,HttpStatus.OK);
	}
}
