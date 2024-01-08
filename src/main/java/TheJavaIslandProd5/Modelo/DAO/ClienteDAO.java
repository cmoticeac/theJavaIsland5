package TheJavaIslandProd5.Modelo.DAO;
import TheJavaIslandProd5.Modelo.*;

import java.util.*;

public interface ClienteDAO {

    void insert(Cliente cliente);

    ArrayList<Cliente> readAll();

    Cliente findById(String id);

    void update(Cliente cliente);
    List<Cliente> list();
    void delete(Cliente cliente);
}