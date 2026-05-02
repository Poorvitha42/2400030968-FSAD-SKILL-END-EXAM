package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        // Open Session
        Session session = sf.openSession();

        // Begin Transaction
        Transaction tx = session.beginTransaction();

        // 1️⃣ Insert records using persistent objects
        Transport t1 = new Transport("Bus", new Date(), "Active", "Public", 5000);
        Transport t2 = new Transport("Truck", new Date(), "Inactive", "Goods", 12000);

        session.save(t1);
        session.save(t2);

        tx.commit();

        // 2️⃣ View all records using HQL with named parameter
        session.beginTransaction();

        String hql = "FROM Transport t WHERE t.name LIKE :param";
        Query<Transport> query = session.createQuery(hql, Transport.class);

        // Named parameter (acts like no WHERE clause)
        query.setParameter("param", "%");

        List<Transport> list = query.list();

        System.out.println("----- Transport Records -----");

        for (Transport t : list) {
            System.out.println(
                    t.getId() + " | " +
                    t.getName() + " | " +
                    t.getDate() + " | " +
                    t.getStatus() + " | " +
                    t.getType() + " | " +
                    t.getCost()
            );
        }

        session.getTransaction().commit();

        // Close resources
        session.close();
        sf.close();
    }
}