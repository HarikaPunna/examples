package com.pkg1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.dao.Employee;



public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf=cfg.buildSessionFactory();
	    Session session=sf.openSession();
	    Employee employee=(Employee)context.getBean("employee");
	    System.out.println(employee.getId());
	    System.out.println(employee.getName());
	    Transaction tx=session.beginTransaction();
	    session.save(employee);
	    tx.commit();
	    session.close();
	    sf.close();
	}
}
