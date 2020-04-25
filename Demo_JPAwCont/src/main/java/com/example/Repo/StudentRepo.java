package com.example.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	List<Student> findByTech(String tech);
	List<Student> findByIdGreaterThan(int id);
	
	@Query("from Student  where tech=?1 order by name")
	List<Student> findByTechSorted(String tech);

}
