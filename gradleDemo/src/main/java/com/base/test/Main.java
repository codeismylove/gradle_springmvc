package com.base.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class Main {
 
    private ApplicationContext context;
 
 
    public Main() {
 
        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
 
    }
 
    @Test
    public void testCreateTable() {
 
    }
 
 
}
