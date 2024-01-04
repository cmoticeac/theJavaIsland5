package TheJavaIslandProd5.Modelo;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Hibernate {
    private static SessionFactory sessionFactory;
    private static SessionFactory buildSessionFactory() {
        try {
        // Create the SessionFactory from hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        System.out.println("Connfiguracion de Hibernate cargada");

        // Configura las clases de entidad que deseas mapear
        configuration.addAnnotatedClass(Articulo.class);
        configuration.addAnnotatedClass(Cliente.class);
        configuration.addAnnotatedClass(ClientePremium.class);
        configuration.addAnnotatedClass(ClienteEstandar.class);
        configuration.addAnnotatedClass(Pedido.class);
        //apply configuration property settings to StandardServiceRegistryBuilder
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        System.out.println("Registro de Hibernate creado correctamente");

        SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }
        catch (Throwable ex) {
        // Make sure you log the exception, as it might be swallowed
        System.err.println("Error al iniciar SessionFactory." + ex);
        throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

}
