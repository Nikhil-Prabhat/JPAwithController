package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Repo.StudentRepo;
import com.example.model.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentRepo repo;

	@RequestMapping("/")
	public String gethome() {
		return "home.jsp";
	}

	@RequestMapping("/insert")
	public String addStudent(Student student) {
		repo.save(student);
		return "home.jsp";
	}

	/*
	@RequestMapping("/update")
	public ModelAndView getAlien(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("showPage.jsp");
		Student myst = repo.findById(id).orElse(new Student());
		
		System.out.println(repo.findByIdGreaterThan(1));
		System.out.println(repo.findByTechSorted("Java"));
		mv.addObject(myst);

		return mv;
	}
	*/
	
	
	@DeleteMapping("student/{id}")
	@ResponseBody                 //Not returning view name but instead data
	public String deleteAlien(@PathVariable int id) 
	{
		Student student = repo.getOne(id);
		repo.deleteById(id);
		//return student;
		
		return "deleted";
	}
	
	@RequestMapping(path="students",produces= {"application/xml"})
	@ResponseBody                 //Not returning view name but instead data
	public List<Student> getAliens() 
	{
		return  repo.findAll();
	}
	
	@PutMapping("student")
	@ResponseBody                 //Not returning view name but instead data
	public Student updateAlien(@RequestBody Student student) 
	{
		repo.save(student);
		return student;
	}
	
	
	@PostMapping(path="student",consumes= {"application/xml"})
	@ResponseBody                 //Not returning view name but instead data
	public Student addAlien(@RequestBody Student student) 
	{
		repo.save(student);
		return student;
	}
	
	@RequestMapping("student/{id}")
	@ResponseBody                 //Not returning view name but instead data
	public Optional<Student> getAlien(@PathVariable int id) 
	{
		return repo.findById(id);
	}
	
	
	

}
