package com.hibernatework.application;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernatework.model.Student;

public class Hprogram1 {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		
		 config.configure();
		
		 config.addAnnotatedClass(Student.class);
		
		SessionFactory SessionFactory = config.buildSessionFactory();
		
		Session openSession = SessionFactory.openSession();
		
		Transaction Transaction = openSession.beginTransaction();
		
//		Logics
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the RollNumber:");
		int rollno = sc.nextInt();
		System.out.print("Enter the Name:");
		String name = sc.next();
		System.out.print("Enter the Email:");
		String Email = sc.next();
		Student s1 = new Student(rollno,name,Email);
		Serializable save = openSession.save(s1);
		System.out.println(save);
		
		Transaction.commit();
		  
	}

}
 
