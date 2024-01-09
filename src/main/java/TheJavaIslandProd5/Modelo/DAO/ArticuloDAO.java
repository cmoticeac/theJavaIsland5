package TheJavaIslandProd5.Modelo.DAO;

import TheJavaIslandProd5.Modelo.*;

import java.util.*;

public interface ArticuloDAO {

    void insert(Articulo articulo);

    List<Articulo> readAll();

    Articulo findById(int id);

    void update(Articulo articulo);

    List<Articulo> list();
    void delete(Articulo articulo);
}