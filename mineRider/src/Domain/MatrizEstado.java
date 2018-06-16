package Domain;


public class MatrizEstado {
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
        this.matriz = new int[20][20];
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
