package Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Entity.CustomerAccount;
import Entity.Play;
import Entity.Seat;
import Entity.SeatReservation;
import Entity.Shows;
import Entity.TheaterHall;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
            try {
            	Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
            	.addAnnotatedClass(Play.class).addAnnotatedClass(CustomerAccount.class).addAnnotatedClass(Shows.class)
            	.addAnnotatedClass(Seat.class).addAnnotatedClass(TheaterHall.class).addAnnotatedClass(SeatReservation.class);
            	ServiceRegistryBuilder sb = new ServiceRegistryBuilder();
            	sb.applySettings(cfg.getProperties());
            	ServiceRegistry standardServiceRegistry = sb.buildServiceRegistry();           	
            	sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);      	
            } catch (Throwable th) {
                    System.err.println("Enitial SessionFactory creation failed" + th);
                    throw new ExceptionInInitializerError(th);
            }
    }
    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }
}
