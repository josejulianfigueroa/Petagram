package mismascotas;

import java.io.Serializable;

/**
 * Created by JULIAN on 02/05/2016.
 */
public class Mascotas implements Serializable {
    private String nombre;
    private int foto,rate,id;

    public Mascotas(String nombre,int rate, int foto) {
        this.nombre = nombre;
        this.rate = rate;
        this.foto = foto;
    }

    public Mascotas() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
