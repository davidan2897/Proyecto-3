/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author david*/

public class Chimera {
  private String nombre;
   private int posicion;
   private int ataqueCorto;
   private int ataqueLargo;
   private int defensa;
   private double retraso;
   private int alcance;
   private String direccion;
   
     public Chimera(String nombre, int posicion, int ataqueCorto, int ataqueLargo, int defensa, double retraso, int alcance, String direccion) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.ataqueCorto = ataqueCorto;
        this.ataqueLargo = ataqueLargo;
        this.defensa = defensa;
        this.retraso = retraso;
        this.alcance = alcance;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getAtaqueCorto() {
        return ataqueCorto;
    }

    public void setAtaqueCorto(int ataqueCorto) {
        this.ataqueCorto = ataqueCorto;
    }

    public int getAtaqueLargo() {
        return ataqueLargo;
    }

    public void setAtaqueLargo(int ataqueLargo) {
        this.ataqueLargo = ataqueLargo;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public double getRetraso() {
        return retraso;
    }

    public void setRetraso(double retraso) {
        this.retraso = retraso;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
     
}
