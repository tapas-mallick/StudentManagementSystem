package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		Integer r=(Integer)this.hibernateTemplate.save(student);
		return r;
	}
	
	public Student getStudent(int id) {
		Student student= this.hibernateTemplate.get(Student.class, id);
		return student;
	}
	
	public List<Student> getAllStudents(){
		List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	@Transactional
	public Student update(Student stu) {
		this.hibernateTemplate.update(stu);
		return stu;
	}
	
	@Transactional
	public Student delete(int stu) {
		Student stud=this.hibernateTemplate.get(Student.class,stu);
		this.hibernateTemplate.delete(stud);
		return stud;
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
