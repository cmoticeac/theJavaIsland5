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


}