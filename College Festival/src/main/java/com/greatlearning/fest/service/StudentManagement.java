package com.greatlearning.fest.service;

import java.util.List;

import com.greatlearning.fest.model.student;

public interface StudentManagement {
	public List<student> listAllData();
	public void save(student s1);
	public student delete(int id);
	public student getStudentDetails(int id);
}
