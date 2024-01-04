package TheJavaIslandProd5.Modelo.DAO;

import TheJavaIslandProd5.Modelo.*;

import java.util.*;

public interface ArticuloDAO {

    void insert(Articulo articulo);

    ArrayList<Articulo> readAll();

    Articulo findById(int id);

    void update(Articulo articulo);
}