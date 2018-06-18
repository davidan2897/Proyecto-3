/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author david*/

public class Chimera implements Runnable{
    MovimientosObjetos movimientosObjetos = new MovimientosObjetos();
  private String nombre;
   private int posicionX;
   private int ataqueCorto;
   private int ataqueLargo;
   private int defensa;
   private double retraso;
   private int alcance;
   private String direccion;
      private ImageView imagen;
      private int posicionY;

    public Chimera(String nombre, int posicionX, int posicionY, int ataqueCorto, int ataqueLargo, int defensa, double retraso, int alcance, String direccion, ImageView imagen) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.ataqueCorto = ataqueCorto;
        this.ataqueLargo = ataqueLargo;
        this.defensa = defensa;
        this.retraso = retraso;
        this.alcance = alcance;
        this.direccion = direccion;
        this.imagen = imagen;
    }
   
   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

   

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
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

    @Override
    public void run() {
           int x;
        int y;
            ArrayList<String> Arraymovimientos = movimientosObjetos.elegirDireccion();
            String posicion = Arraymovimientos.get((int) +(Math.random() * Arraymovimientos.size()));
            System.out.println(posicion);

            switch (posicion) {
                case "arriba":
                    x = this.getPosicionY();
                    y = this.getPosicionX();
                    System.out.println("y " + y + "  " + "x " + x + this.getNombre());
                    if (y > 0) {
                        if (MatrizEstado.getInstance().getMatriz()[y - 1][x] == 0) {
                            y -= 1;
                            MatrizEstado.getInstance().actualizarPosicion(3, y, x);
                            this.setPosicionX(y);
                            MatrizEstado.getInstance().actualizarPosicion(0, y + 1, x);
                            MatrizEstado.getInstance().mostrarMatrizConsola();
                            movimientosObjetos.movimientoArriba(imagen);
                            System.out.println("y " + y + "  " + "x " + x + this.getNombre());
                        }
                    }
                    break;
                case "abajo":
                    x = this.getPosicionY();
                    y = this.getPosicionX();
                    System.out.println("y " + y + "  " + "x " + x + this.getNombre());
                    if (y < MatrizEstado.getInstance().enviarTamaño() - 1) {
                        if (MatrizEstado.getInstance().getMatriz()[y + 1][x] == 0) {

                            y += 1;
                            MatrizEstado.getInstance().actualizarPosicion(3, y, x);
                            this.setPosicionX(y);
                            MatrizEstado.getInstance().actualizarPosicion(0, y - 1, x);
                            MatrizEstado.getInstance().mostrarMatrizConsola();

                            movimientosObjetos.movimientoAbajo(imagen);
                            System.out.println("y " + y + "  " + "x " + x + this.getNombre());
                        }
                    }
                    break;
                case "Derecha":
                    x = this.getPosicionY();
                    y = this.getPosicionX();
                    System.out.println("y " + y + "  " + "x " + x + this.getNombre());
                    if (x < MatrizEstado.getInstance().enviarTamaño() - 1) {
                        if (MatrizEstado.getInstance().getMatriz()[y][x + 1] == 0) {
                            x = x + 1;
                            MatrizEstado.getInstance().actualizarPosicion(3, y, x);
                            this.setPosicionY(x);
                            MatrizEstado.getInstance().actualizarPosicion(0, y, x - 1);
                            MatrizEstado.getInstance().mostrarMatrizConsola();
                            movimientosObjetos.movimientoDerecha(imagen);
                            System.out.println("y " + y + "  " + "x " + x + this.getNombre());
                        }
                    }
                    break;
                case "izquierda":
                    x = this.getPosicionY();
                    y = this.getPosicionX();
                    System.out.println("y " + y + "  " + "x " + x + this.getNombre());
                    if (x > 0) {
                        if (MatrizEstado.getInstance().getMatriz()[y][x - 1] == 0) {
                            x -= 1;
                            MatrizEstado.getInstance().actualizarPosicion(3, y, x);
                            this.setPosicionY(x);
                            MatrizEstado.getInstance().actualizarPosicion(0, y, x + 1);
                            MatrizEstado.getInstance().mostrarMatrizConsola();
                            movimientosObjetos.movimientoIzquierda(imagen);
                            System.out.println("y " + y + "  " + "x " + x + this.getNombre());
                        }
                    }
                    break;

            }//fin swich

        }//fin run

    }
     


