/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author David
 */
public class Personaje implements Runnable{
    private String nombre;
    private int vida;
    private int pala;
    private int latigo;
    private int espada ;
    private int posicion;
    private int alcance;
    private String direccion;
    private String url;

    public Personaje(String nombre, int vida, int pala, int latigo, int espada, int posicion, int alcance, String direccion,String url) {
        this.nombre = nombre;
        this.vida = vida;
        this.pala = pala;
        this.latigo = latigo;
        this.espada = espada;
        this.posicion = posicion;
        this.alcance = alcance;
        this.direccion = direccion;
        this.url=url;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPala() {
        return pala;
    }

    public void setPala(int pala) {
        this.pala = pala;
    }

    public int getLatigo() {
        return latigo;
    }

    public void setLatigo(int latigo) {
        this.latigo = latigo;
    }

    public int getEspada() {
        return espada;
    }

    public void setEspada(int espada) {
        this.espada = espada;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    @Override
    public void run() {
      
    }
    
}
