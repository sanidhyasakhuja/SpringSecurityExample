package com.example.SecurityExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SecurityExample.model.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students,Integer> {

}
