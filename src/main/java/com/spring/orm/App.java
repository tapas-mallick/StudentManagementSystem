package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws NumberFormatException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
		StudentDao dao = context.getBean("studentDao", StudentDao.class);
//		Student stu = new Student(4, "Jeevan Jyoti Jena", "Phulbani");
//		int r = dao.insert(stu);
//		System.out.println(r + " record inserted");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("******************** Student Management System ********************");
		System.out.println();
		boolean bool = true;
		while (bool) {

			System.out.println(" Press 1 to Add new Student");
			System.out.println(" Press 2 to Display all Students data");
			System.out.println(" Press 3 to Display individual Student data");
			System.out.println(" Press 4 to Update Student");
			System.out.println(" Press 5 to Delete Student");
			System.out.println(" Press 6 to Exit");

			try {
				Integer input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:// add new student
					System.out.println();
					System.out.println(" PRESSED 1");
					System.out.println(" Enter Student id :");
					int id = Integer.parseInt(br.readLine());
					System.out.println(" Enter Student name :");
					String name = br.readLine();
					System.out.println(" Enter Student address :");
					String address = br.readLine();
					Student st = new Student(id, name, address);
					dao.insert(st);
					System.out.println(" One record inserted");
					System.out.println();
					System.out.println();
					break;
				case 2:// display all students
					System.out.println();
					System.out.println(" PRESSED 2");
					List<Student> students=dao.getAllStudents();
					for(Student s:students) {
						System.out.println();
						System.out.println(" student id : "+s.getId());
						System.out.println(" student name : "+s.getName());
						System.out.println(" student address : "+s.getAddress());
						System.out.println("__________________________________________");
					}
					System.out.println("******************************************");
					break;
				case 3:// display individual student
					System.out.println();
					System.out.println(" PRESSED 3");
					System.out.println(" Enter Student id :");
					int sid = Integer.parseInt(br.readLine());
					Student s1 =dao.getStudent(sid);
					System.out.println();
					System.out.println(" student id : "+s1.getId());
					System.out.println(" student name : "+s1.getName());
					System.out.println(" student address : "+s1.getAddress());
					System.out.println();
					break;
				case 4:// update student
					System.out.println();
					System.out.println(" PRESSED 4");
					System.out.println(" Enter Student id :");
					int uid = Integer.parseInt(br.readLine());
					System.out.println(" Enter Student name :");
					String uname = br.readLine();
					System.out.println(" Enter Student address :");
					String uaddress = br.readLine();
					Student ust = new Student(uid, uname, uaddress);
					dao.update(ust);
					System.out.println(" One record updated");
					System.out.println();
					System.out.println();
					break;
				case 5:// delete student
					System.out.println();
					System.out.println(" PRESSED 5");
					System.out.println(" Enter Student id :");
					int stid = Integer.parseInt(br.readLine());
					System.out.println(dao.delete(stid));
					System.out.println();
					break;
				case 6:// exit
					bool = false;
					System.out.println(" Thank for using the Service , See you Soon!!");
					break;
				}

			} catch (Exception E) {
				System.out.println();
				System.out.println(" Invalid Input ,Press again");
				System.out.println(E.getMessage());
				System.out.println();
			}

		}

	}
}
