package Domain;


public class MatrizEstado {
    private int matriz[][];

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
       
    public MatrizEstado(){
        this.matriz = new int[5][5];
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
}
