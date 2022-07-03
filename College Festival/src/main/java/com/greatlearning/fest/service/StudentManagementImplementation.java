package com.greatlearning.fest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.fest.model.student;

@Service
public class StudentManagementImplementation implements StudentManagement{
	SessionFactory sessionFactory;
	Session session;
	@Autowired
	public StudentManagementImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = sessionFactory.getCurrentSession();
		}
		catch (HibernateException e) {
			// TODO: handle exception
			this.session=sessionFactory.openSession();
		}
	}
	@Override
	@Transactional
	public List<student> listAllData() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<student> l1= (List<student>)session.createQuery("from student").list();
		return l1;
	}

	@Override
	public void save(student s1) {
		// TODO Auto-generated method stub
		//System.out.println(s1.getId()+" "+s1.getCountry()+" "+s1.getDept()+" "+s1.getName());
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(s1);
		tx.commit();
		System.out.println("Save Completed");
		
	}

	@Override
	@Transactional
	public student delete(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		student s1 = session.get(student.class,id);
		session.delete(s1);
		tx.commit();
		return s1;
	}
	@Override
	public student getStudentDetails(int id) {
		// TODO Auto-generated method stub
		student s1 = session.get(student.class,id);
		return s1;
	}

}
