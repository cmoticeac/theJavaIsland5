package TheJavaIslandProd5.Modelo;

import TheJavaIslandProd5.Modelo.DAO.FactoryDAO;
import TheJavaIslandProd5.Modelo.DAO.FactoryDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class ListaArticulos extends Lista<Articulo>{

    //Contructor
    public ListaArticulos() {
        ListaArticulos.super.lista = new ArrayList<Articulo>();
    }
    public List<Articulo> getListaArticulos() {
        return FactoryDAO.crearArticuloDAO().list();
    }

    public int getSize() {
        return getListaArticulos().size();
    }

    public void add(Articulo t) {
        FactoryDAO.crearArticuloDAO().insert(t);
    }

    public void borrar(Articulo t) {
        FactoryDAO.crearArticuloDAO().delete(t);
    }

    public Articulo getAt(int position) {
        return getListaArticulos().get(position);
    }

    public boolean isEmpty() {
        return getListaArticulos().isEmpty();
    }

    public List<Articulo> getArrayList() {
        return getListaArticulos();
    }

    public Articulo existeArticulo(Articulo articulo) {
        for (int i = 0; i < getListaArticulos().size(); i++) {
            Articulo a = getListaArticulos().get(i);
            if (a.getCodigo() == articulo.getCodigo()) {
                return a;
            }
        }
        return null;
    }
    public static Articulo existeCodigoArticulo(String codigo) {
        Articulo articulo = FactoryDAO.crearArticuloDAO().readAll();
        // Verificar si el artículo con el código dado existe
        if (articulo != null && String.valueOf(articulo.getCodigo()).equals(codigo)) {
            return articulo;  // Devolver el artículo si se encuentra
        }
        return null;  // Devolver null si no se encuentra el artículo
    }


}
