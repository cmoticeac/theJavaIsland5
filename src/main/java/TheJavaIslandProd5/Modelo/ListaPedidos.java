package TheJavaIslandProd5.Modelo;

import TheJavaIslandProd5.Modelo.DAO.FactoryDAO;

import java.util.ArrayList;
import java.util.List;

public class ListaPedidos extends Lista<Pedido>{

    //Contructor
    public List<Pedido> getListaPedidos() {
        return FactoryDAO.crearPedidoDAO().list();
    }

    public int getSize() {
        return getListaPedidos().size();
    }

    public void add(Pedido t) {
        FactoryDAO.crearPedidoDAO().insert(t);
    }

    public void borrar(int numeroPedido) {
        FactoryDAO.crearPedidoDAO().delete(numeroPedido);
    }

    public Pedido getAt(int position) {
        return getListaPedidos().get(position);
    }

    public boolean isEmpty() {
        return getListaPedidos().isEmpty();
    }

    public List<Pedido> getArrayList() {
        return getListaPedidos();
    }


}
