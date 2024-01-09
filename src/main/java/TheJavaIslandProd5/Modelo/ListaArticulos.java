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


}
