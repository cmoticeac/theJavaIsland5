package TheJavaIslandProd5.Modelo.DAO;
import TheJavaIslandProd5.Modelo.*;
import java.util.*;


import TheJavaIslandProd5.Modelo.Hibernate;
import org.hibernate.*;

public class ArticuloDAOImpl implements ArticuloDAO {

    private SessionFactory sessionFactory;

    public ArticuloDAOImpl(){
        this.sessionFactory = Hibernate.getSessionFactory();
    }

    @Override
    public void insert(Articulo articulo) {
     try (Session session = sessionFactory.openSession()){
         Transaction transaction = session.beginTransaction();
         session.save(articulo);
         transaction.commit();
     }
    }

    @Override
    public Articulo readAll(){
        try (Session session = sessionFactory.openSession()) {
            return (Articulo) session.createQuery("FROM Articulo", Articulo.class).list();
        }
    }

    @Override
    public Articulo findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Articulo art = session.get(Articulo.class, id);
            return art;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    // Método para actualizar un artículo en la base de datos
    public void update(Articulo articulo) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(articulo);
            transaction.commit();
        }
    }
    public List<Articulo> list() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Articulo", Articulo.class).list();
        }
    }
    public void delete(Articulo articulo) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(articulo);
            transaction.commit();
        }
    }
}