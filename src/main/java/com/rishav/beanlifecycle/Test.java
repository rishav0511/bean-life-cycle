package com.rishav.beanlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/com/rishav/beanlifecycle/beans.xml");
        StudentDAO studentDAO = context.getBean("studentDAO",StudentDAO.class);
        studentDAO.selectAllRows();
        ((ClassPathXmlApplicationContext)context).close();
    }
}
