package TheJavaIslandProd5.Modelo;
import jakarta.persistence.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/** Clase Articulo */

@Entity
@Table(name= "articulo")
public class Articulo implements List<Articulo> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    /** Atributos de la clase */
    private int codigo;
    @Column(name = "Descripcion")
    private String Descripcion;
    @Column(name = "PrecioDeVenta")
    private double precioDeVenta;
    @Column(name = "GastosDeEnvio")
    private double gastosDeEnvio;
    @Column(name = "TiempoDePreparacion")
    private double tiempoDePreparacion;


    /** Constructores */

    public Articulo(int codigo, String descripcion, double precioDeVenta, double gastoDeEnvio, double tiempoDePrepar) {
        this.codigo = codigo;
        this.Descripcion = descripcion;
        this.precioDeVenta = precioDeVenta;
        this.gastosDeEnvio = gastoDeEnvio;
        this.tiempoDePreparacion = tiempoDePrepar;
    }

    public Articulo() {
    }

    /**
     * Metodos getters y setters
     */

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecioDeVenta() {
        return this.precioDeVenta;
    }

    public void setPrecioDeVenta(double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public double getGastosDeEnvio() {
        return this.gastosDeEnvio;
    }

    public void setGastosDeEnvio(double gastosDeEnvio) {
        this.gastosDeEnvio = gastosDeEnvio;
    }

    public double getTiempoDePreparacion() {
        return this.tiempoDePreparacion;
    }

    public String getDescripcion() {return this.Descripcion;}

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public void setTiempoDePreparacion(double tiempoDePreparacion) {this.tiempoDePreparacion = tiempoDePreparacion;}

    /** El metodo toString() */
    public String toString() {
        return "articulos{codigo='" + this.codigo + "', descripcion='" + this.Descripcion + "', precioDeVenta=" + this.precioDeVenta + ", gastosDeEnvio=" + this.gastosDeEnvio + ", tiempoDePreparacion=" + this.tiempoDePreparacion + "}";
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Articulo> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Articulo> action) {
        List.super.forEach(action);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return List.super.toArray(generator);
    }

    @Override
    public boolean add(Articulo articulo) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Articulo> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Articulo> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super Articulo> filter) {
        return List.super.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<Articulo> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super Articulo> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {

    }

    @Override
    public Articulo get(int index) {
        return null;
    }

    @Override
    public Articulo set(int index, Articulo element) {
        return null;
    }

    @Override
    public void add(int index, Articulo element) {

    }

    @Override
    public Articulo remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Articulo> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Articulo> listIterator(int index) {
        return null;
    }

    @Override
    public List<Articulo> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<Articulo> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public Stream<Articulo> stream() {
        return List.super.stream();
    }

    @Override
    public Stream<Articulo> parallelStream() {
        return List.super.parallelStream();
    }
}

