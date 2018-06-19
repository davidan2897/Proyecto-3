package Domain;

import java.util.ArrayList;


public class MatrizEstado {
     Archivos archivo = new Archivos();
    ArrayList tamaño = archivo.leerJson();
    int TamañoFilaCueva = Integer.parseInt((String) tamaño.get(0));                
    int TamañoColumnaCueva = Integer.parseInt((String) tamaño.get(1)); 
    private static MatrizEstado instance;
    private int matriz[][];

    public static MatrizEstado getInstance() {
        if (instance == null) {
            instance = new MatrizEstado();
        }
        return instance;

    }
    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
       
    public MatrizEstado(){
        this.matriz = new int[TamañoColumnaCueva][TamañoFilaCueva];
    }
    
    public void actualizarPosicion(int elemento, int posicionX, int posicionY){
        this.matriz[posicionX][posicionY]=elemento;
    }
    
    public void mostrarMatrizConsola(){
        String valores="";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                valores+="["+matriz[i][j]+"]";
            }
            valores+="\n";
        }
        System.out.println(valores);
    }
    public int enviarTamaño(){
        return TamañoColumnaCueva;
        
    }
}
