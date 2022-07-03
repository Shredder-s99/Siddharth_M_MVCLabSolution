package com.greatlearning.fest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.fest.model.student;
import com.greatlearning.fest.service.StudentManagementImplementation;

@Controller
@RequestMapping("/student")
public class studentController {
@Autowired
StudentManagementImplementation data;

@RequestMapping("/") 
public String printStudentData(Model m1){
	List<student> l1 = data.listAllData();
	m1.addAttribute("result",l1);
	return "print";
	
}
@RequestMapping("/add")
public String addBook(Model theModel) {
	student s1= new student();
	theModel.addAttribute("result",s1);
	return "saveDetails";
}

@RequestMapping("/update")
public String updateBook(@RequestParam("id") int id,Model theModel) {
	
	student s1 = data.getStudentDetails(id);
	theModel.addAttribute("result", s1);
	System.out.println(s1.getId()+" Id");
	return "saveDetails";
}

@RequestMapping("/delete")
public String deleteBook(@RequestParam("id") int id) {
	data.delete(id);
	return "redirect:/student/";
}
@PostMapping("/save")
public String saveDetails(@RequestParam("id") int id, @RequestParam("name") String name,
		@RequestParam("dept") String dept, @RequestParam("country") String country) {
	student s1;
	System.out.println(id+" ID");
	if(id != 0) {
		s1 = data.getStudentDetails(id);
	}else {
		s1 = new student();
	}
	System.out.println("Id "+s1.getId());
	s1.setName(name);
	s1.setCountry(country);
	s1.setDept(dept);
	data.save(s1);
	return "redirect:/student/";
}
}
