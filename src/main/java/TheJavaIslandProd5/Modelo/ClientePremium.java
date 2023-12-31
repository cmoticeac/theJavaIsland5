package TheJavaIslandProd5.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("estandar")
public class ClientePremium extends Cliente{

    //Atributos propios de usuarios premium
    @Column(name ="CuotaMensual")
    private Double cuota;
    @Column(name ="Descuento")
    private Double descuentoEnvio;


    //Contructor
    public ClientePremium( String n, String d, String nif, String m, double desc, double c) {
        super( n, d, nif, m);
        this.descuentoEnvio = desc;
        this.cuota = c;
    }
    public ClientePremium() {}
    //Setters i getters
    public Double getCuota() {return this.cuota;}
    public Double getDescuentoEnvio(){return this.descuentoEnvio;}

    public void setCuota(Double c) {this.cuota = c;}
    public void setDescuentoEnvio(Double c) {this.descuentoEnvio = c;}


    //toString()
    public String ToString(){
        return "Cliente Premium"
                + "\nNombre: " + this.getNombre()
                + "\nDireccion: " + this.getDomicilio()
                + "\nNif: " + this.getNif()
                + "\nEmail: " + getEmail();
    }
}
