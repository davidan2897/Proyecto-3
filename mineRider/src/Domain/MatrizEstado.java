package Domain;

import java.util.StringTokenizer;

public class MatrizEstado {

    private static MatrizEstado instance;
    private Coordenadas matriz[][];

    public static MatrizEstado getInstance() {
        if (instance == null) {
            instance = new MatrizEstado();
        }
        return instance;
    }

    public MatrizEstado() {
        this.matriz = new Coordenadas[6][6];
    }

    public String enviarMatrizCoordenadas() {
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
               if(j!=matriz.length-1)
                   valores+=",";
//                matriz[i][j]= coordenadas;
            }
            coordenadas.setX(40);
            aux=1;
            if(i!=(matriz.length-1))
            coordenadas.setY(coordenadas.getY() + 100);
            
//            valores += "\n";
          
        }
       System.out.println(valores+"aaaa");
        return valores;
    }
    public Coordenadas[][] enviaMatriz (String valores){
         StringTokenizer sT =  new StringTokenizer(valores,",");
    //  for(int i=0;i<valores.length();i++){
          while(sT.hasMoreTokens()){
       
        int x = Integer.parseInt(sT.nextToken());
       int y=Integer.parseInt(sT.nextToken());
       
          System.out.println("PASO1"+x);
          
          for (int j = 0; j < matriz.length; j++) {
               System.out.println("PASO2");
              for (int k = 0; k < matriz[0].length; k++) {
                  
        System.out.println(x);
               Coordenadas c = new Coordenadas(0, 0);
               c.setX(x);
               c.setY(y);
               matriz[j][k]= c;
                   }
              }
              
         // }
        
        
          }
        
        
        return matriz;
        
        
        
        
        
        
        
    }
    
    
    
}
