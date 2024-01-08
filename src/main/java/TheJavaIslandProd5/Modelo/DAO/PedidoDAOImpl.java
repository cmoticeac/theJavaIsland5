package TheJavaIslandProd5.Modelo.DAO;
import TheJavaIslandProd5.Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import TheJavaIslandProd5.Modelo.Hibernate;
import org.hibernate.*;


public class PedidoDAOImpl implements PedidoDAO {

    private SessionFactory sessionFactory;

    public PedidoDAOImpl () {
        this.sessionFactory = Hibernate.getSessionFactory();
    }
    @Override
    public void insert(Pedido pedido) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pedido);
            transaction.commit();
        }
    }

    @Override
    public ArrayList<Pedido>readAll(){
        try (Session session = sessionFactory.openSession()) {
            return (ArrayList<Pedido>) session.createQuery("FROM Pedido", Pedido.class).list();
        }
    }

    @Override
    public Pedido findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Pedido art = session.get(Pedido.class, id);
            return art;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Pedido pedido) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(pedido);
            transaction.commit();
        }
    }
    public void delete(int numPedido) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Pedido.class, numPedido));
            transaction.commit();
        }
    }
    public List<Pedido> list() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Pedido", Pedido.class).list();
        }
    }
}