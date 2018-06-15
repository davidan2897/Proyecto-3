package Domain;


public class Matriz {
    private static Matriz instance;
    private int matriz[][];
    
    public static Matriz getInstance() {
        if(instance==null){
            instance=new Matriz();
        }
        return instance;
    }
    
    public Matriz(){
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
