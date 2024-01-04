package TheJavaIslandProd5.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoCliente", discriminatorType = DiscriminatorType.STRING)
public abstract class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    //Atributos
    private int id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Domicilio")
    private String Domicilio;
    @Column(name = "NIF")
    private String Nif;
    @Column(name = "Email")
    private String Email;

    //Contructor
    public Cliente(String n, String d, String nif, String m) {
        this.Nombre = n;
        this.Domicilio = d;
        this.Nif = nif;
        this.Email = m;
    }
    public Cliente(){}
    //Setters y getters
    public int getId(){return id;}
    public String getNombre() {return Nombre;}

    public String getDomicilio() {return Domicilio;}

    public String getNif() {return Nif;}

    public String getEmail() {return Email;}
    public void setId(int id){this.id = id;}

    public void setNombre(String c) {this.Nombre = c;}

    public void setDomicilio(String c) {this.Domicilio = c;}

    public void setNif(String c) {this.Nif = c;}

    public void setEmail(String c) {this.Email = c;}

}
