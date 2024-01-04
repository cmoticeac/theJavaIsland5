package TheJavaIslandProd5.Modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("premium")
public class ClienteEstandar extends Cliente{

    public ClienteEstandar(String n, String d, String nif, String m) {
        super(n, d, nif, m);
    }
public ClienteEstandar() {}
    public String ToString(){
        return "Cliente Estandar"
                + "\nNombre: " + this.getNombre()
                + "\nDireccion: " + this.getDomicilio()
                + "\nNif: " + this.getNif()
                + "\nEmail: " + getEmail();
    }
}
