package com.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.to.Player;
import com.to.Team;

public class HibernateMain {
	public static void main(String[] args) {
		try {
//			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
//					.configure("hibernate.cfg.xml").build();
//			
//			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
//			SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
			Configuration cfg = new Configuration().configure();
			cfg.addAnnotatedClass(com.to.Player.class);
			cfg.addAnnotatedClass(com.to.Team.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties());
			SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());

			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Team t1 = new Team("india");
			Player p1 = new Player("virat", t1, 26);
			session.save(t1);
			session.save(p1);
			transaction.commit();
			session.close();
			
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
	}

}
