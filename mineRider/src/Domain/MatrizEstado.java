package Domain;


public class MatrizEstado {
    private static MatrizEstado instance;
    private int matriz[][];
    
    public static MatrizEstado getInstance() {
        if(instance==null){
            instance=new MatrizEstado();
        }
        return instance;
    }
    
    public MatrizEstado(){
        this.matriz = new int[6][6];
    }
    
    public void actualizarPosicion(int elemento, int posicionX, int posicionY){
        this.matriz[posicionX][posicionY]=elemento;
    }
    
    public void mostrarMatrizConsola(){
        String valores="";
        int x=40;
        int y=70;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                valores+="["+x+" "+y+"]";
                x+=100;
                y+=100;
            }
            valores+="\n";
        }
        System.out.println(valores);
    }
}
