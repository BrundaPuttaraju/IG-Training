package com.example.manytomanypractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App
{
    public static void main( String[] args )
    {
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");

        Student s = new Student();
        s.setName("Brunda");
        s.setRollno(1);
        s.setMarks(50);
        s.getLaptop().add(laptop);

        laptop.getStudent().add(s);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(registry);
        Session session = sf.openSession();

        session.beginTransaction();

        session.save(laptop);
        session.save(s);

        session.getTransaction().commit();
    }
}
