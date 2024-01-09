package TheJavaIslandProd5.Modelo.DAO;


import java.util.List;

public class FactoryDAO {
    public static ArticuloDAO crearArticuloDAO() {return new ArticuloDAOImpl(); }
    public static ClienteDAO crearClienteDao () {return new ClienteDAOImpl(); }
    public static PedidoDAO crearPedidoDAO() {return new PedidoDAOImpl();}
}
