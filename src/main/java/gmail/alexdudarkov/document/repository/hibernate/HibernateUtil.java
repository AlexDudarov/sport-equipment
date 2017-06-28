package gmail.alexdudarkov.document.repository.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory = createSessionFactory();
	private HibernateUtil() {
	}

	private static SessionFactory createSessionFactory() {
		/*Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;*/
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
	}
	return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
