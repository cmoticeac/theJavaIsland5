package TheJavaIslandProd5.Modelo.DAO;
import TheJavaIslandProd5.Modelo.*;
import java.sql.Connection;
import java.util.*;

public interface PedidoDAO {
    private Connection getConecction(){
        return thejavaislandConnection.getConnection();
    }
    void insert(Pedido pedido);

    ArrayList<Pedido> readAll();

    Pedido findById(int numeroPedido);

    void update(Pedido pedido);
    void delete(int numeroPedido);
    List<Pedido> list();
}