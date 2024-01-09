package TheJavaIslandProd5.Modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Datos {

    //Atributos
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;

    //Contructor
    public Datos() {
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos();
    }

    //ToString
    @Override
    public String toString() {
        String imprimir = new String();
        imprimir = "LISTA DE ARTICULOS: " + listaArticulos.toString() + "\nLISTA DE CLIENTES: " + listaClientes.toString() + "\nLISTA DE PEDIDOS: " + listaPedidos.toString();
        return imprimir;
    }

    //Getters y Setters
    public ListaArticulos getListaArticulos() {
        return this.listaArticulos;
    }

    public ListaClientes getListaClientes() {
        return this.listaClientes;
    }

    public ListaPedidos getListaPedidos() {
        return this.listaPedidos;
    }

    public void setListaArticulos(ListaArticulos l) {
        this.listaArticulos = l;
    }

    public void setListaClientes(ListaClientes l) {
        this.listaClientes = l;
    }

    public void setListaPedidos(ListaPedidos l) {
        this.listaPedidos = l;
    }
}
    //Metodos


