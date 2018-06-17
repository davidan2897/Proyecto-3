package Domain;



import java.util.StringTokenizer;



public class MatrizCoordenadas {
    
    private static MatrizCoordenadas instance;
    private Coordenadas matriz[][];

    public static MatrizCoordenadas getInstance() {
        if (instance == null) {
            instance = new MatrizCoordenadas();
        }
        return instance;
    }

    public MatrizCoordenadas() {
        
        this.matriz = new Coordenadas[5][5];
    }

    public String enviarCoordenadas() {
        String valores = "";
        Coordenadas coordenadas = new Coordenadas(40, 70);
        int aux = 1;
        
        for ( int i = 0; i < matriz.length; i++) {
                 
            for (int j = 0; j < matriz[i].length; j++) {
                  
                 
                if (j == aux) {
                coordenadas.setX(coordenadas.getX() + 100);
                    aux++;
                }
               valores += coordenadas.toString();
               
// 
                   valores+=",";
//                matriz[i][j]= coordenadas;
            }
            coordenadas.setX(40);
            aux=1;
            if(i!=(matriz.length-1))
            coordenadas.setY(coordenadas.getY() + 100);
            
//            valores += "\n";
          
        }
       
        return valores;
    }
    public Coordenadas[][] enviaMatriz (String valores){
//            System.out.println(valores);
        StringTokenizer sT = new StringTokenizer(valores, ",");
        int columna =0, fila =0;
        while (sT.hasMoreTokens() && columna<matriz.length && fila<matriz.length) {          
//          System.out.println(columna+" "+fila);
        Coordenadas c = new Coordenadas(0, 0);
            int x = Integer.parseInt(sT.nextToken());
            int y = Integer.parseInt(sT.nextToken());
            c.setX(x);
            c.setY(y);
//            System.out.println(x+" "+y );
           matriz[columna][fila]=c;
        
           if(fila==matriz.length-1){
           columna++;
           fila=0;
           }
           else
          fila++;
  
        }
        
        
        return matriz;

    }

        
}
    
    
    
