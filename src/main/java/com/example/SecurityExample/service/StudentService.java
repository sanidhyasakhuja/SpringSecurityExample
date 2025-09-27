package com.example.SecurityExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SecurityExample.model.Students;
import com.example.SecurityExample.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Students> getAllStudents(){
		return studentRepository.findAll();
	}

	public Students addStudent(Students student) {
		return studentRepository.save(student);
	}
}
