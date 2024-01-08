package TheJavaIslandProd5.Modelo;

import TheJavaIslandProd5.Modelo.DAO.FactoryDAO;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes extends Lista<Cliente>{

    //Contructor
    public ListaClientes() {
        ListaClientes.super.lista = new ArrayList<Cliente>();
    }
    public List<Cliente> getListaClientes() {
        return FactoryDAO.crearClienteDao().list();
    }

    public int getSize() {
        return getListaClientes().size();
    }

    public void add(Cliente t) {
        FactoryDAO.crearClienteDao().insert(t);
    }

    public void borrar(Cliente t) {
        FactoryDAO.crearClienteDao().delete(t);
    }

    public Cliente getAt(int position) {
        return getListaClientes().get(position);
    }

    public boolean isEmpty() {
        return getListaClientes().isEmpty();
    }

    public List<Cliente> getArrayList() {
        return getListaClientes();
    }

    public Cliente existeCliente(Cliente cliente) {
        for (int i = 0; i < getListaClientes().size(); i++) {
            Cliente c = getListaClientes().get(i);
            if (c.getEmail().equals(cliente.getEmail())) {
                return c;
            }
        }
        return null;
    }
    public static Cliente existeEmailCliente(String email) {
        List<Cliente> listaClientes = FactoryDAO.crearClienteDao().readAll();
        for (Cliente cliente : listaClientes) {
            if (cliente.getEmail() != null && cliente.getEmail().equals(email)) {
                return cliente;  // Se encontró un cliente con el correo electrónico dado
            }
        }
        return null;  // No se encontró ningún cliente con el correo electrónico dado
    }



}