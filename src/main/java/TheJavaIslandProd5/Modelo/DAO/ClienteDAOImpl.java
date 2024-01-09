package TheJavaIslandProd5.Modelo.DAO;

import java.util.*;


import TheJavaIslandProd5.Modelo.*;
import TheJavaIslandProd5.Modelo.Hibernate;
import jakarta.persistence.NoResultException;
import org.hibernate.*;
import org.hibernate.query.Query;

public class ClienteDAOImpl implements ClienteDAO {

    private SessionFactory sessionFactory;

    public ClienteDAOImpl () {
        this.sessionFactory = Hibernate.getSessionFactory();
    }

    @Override
    public void insert(Cliente cliente) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(cliente);
            transaction.commit();
        }
    }

    @Override
    public ArrayList<Cliente> readAll() {
        try (Session session = sessionFactory.openSession()) {
            ArrayList<Cliente> cl = new ArrayList<Cliente>();
           ArrayList<ClienteEstandar> ce = (ArrayList<ClienteEstandar>) session.createQuery("FROM ClienteEstandar", ClienteEstandar.class).list();
           ArrayList<ClientePremium> cp = (ArrayList<ClientePremium>) session.createQuery("FROM ClientePremium", ClientePremium.class).list();
           cl.addAll(ce);
           cl.addAll(cp);
           return cl;
        }
    }

    public Cliente findById(String nif) {
        try (Session session = sessionFactory.openSession()) {
            Query<Cliente> query = session.createNativeQuery("SELECT * FROM Cliente WHERE nif = :nif", Cliente.class);
            query.setParameter("nif", nif);
            Cliente art = query.getSingleResult();
            return art;
        } catch (NoResultException e) {
            // No se encontraron resultados
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Cliente cliente) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(cliente);
            transaction.commit();
        }
    }
    public List<Cliente> list() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Cliente", Cliente.class).list();
        }
    }

    public Cliente obtenerUltimo() {
        try (Session session = sessionFactory.openSession()) {
            Query<Cliente> query = session.createQuery("FROM Cliente ORDER BY id DESC", Cliente.class);
            query.setMaxResults(1); // Obtener solo un resultado
            List<Cliente> resultados = query.getResultList();

            if (!resultados.isEmpty()) {
                return resultados.get(0);
            } else {
                return null; // o lanza una excepción si prefieres
            }
        }
    }
    public void delete(Cliente cliente) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(cliente);
            transaction.commit();
        }
    }
}