/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.ImageView;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author David
 */
public class Archivos {

public ArrayList leerJson(){
          ArrayList array=new ArrayList();
        JSONParser parser = new JSONParser();

        try {     
            Object obj = parser.parse(new FileReader("C:\\Users\\Berny\\Documents\\NetBeansProjects\\Programacion II\\Proyecto 3\\Proyecto-3\\mineRider\\cueva.json"));

            JSONObject jsonObject =  (JSONObject) obj;

              String alto =  (String) jsonObject.get("alto");
            System.out.println(alto);

                String ancho = (String) jsonObject.get("ancho");
            System.out.println(ancho);

        array.add(alto);
        array.add(ancho);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return array;
    }
public void escribir(){
    JSONObject jsonObject = new JSONObject();



    jsonObject.put("nombre", "chimera");

    jsonObject.put("longAttack", "1");
     jsonObject.put("shortAttack", "3");

    jsonObject.put("defensa", "2");
    
      jsonObject.put("retraso", "1");

      jsonObject.put("alcance", "2");
       
      jsonObject.put("imagen", "Imagenes/Zombie.gif");
      
   
 

        try {

 

            FileWriter jsonFileWriter = new FileWriter("C:\\Users\\Berny\\Documents\\David\\Respaldos\\Proyecto-3\\mineRider\\chimera.json");

            jsonFileWriter.write(jsonObject.toJSONString());

            jsonFileWriter.flush();

            jsonFileWriter.close();

 
            System.out.println(jsonObject);

 

        } catch (IOException e) {

            e.printStackTrace();

        }
 
    }

public Zombie leerJsonZombie(){
           ImageView imagenZombie = new ImageView("Imagenes/Zombie.gif");
        JSONParser parser = new JSONParser();

        try {     
            Object obj = parser.parse(new FileReader("C:\\Users\\Berny\\Documents\\David\\Respaldos\\Proyecto-3\\mineRider\\zombie.json"));

            JSONObject jsonObject =  (JSONObject) obj;

              String nombre =  (String) jsonObject.get("nombre");
            System.out.println(nombre);

            String Ataque = (String) jsonObject.get("Ataque");
           System.out.println(Ataque);
            
              String defensa = (String) jsonObject.get("defensa");
            System.out.println(defensa);
            
              String retraso = (String) jsonObject.get("retraso");
            System.out.println(retraso);
            
              String alcance = (String) jsonObject.get("alcance");
            System.out.println(alcance);
            
             

           Zombie zombies=new Zombie(nombre, 0, 0, Integer.parseInt((String) Ataque), Integer.parseInt((String)defensa), (Double.parseDouble((String)retraso)), Integer.parseInt ((String)alcance),"Izquierda", imagenZombie);
             return zombies;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
       return null;
    }

public Chimera leerJsonChimera(){
            ImageView imagenChimera = new ImageView("Imagenes/charmander.gif");
        JSONParser parser = new JSONParser();

        try {     
            Object obj = parser.parse(new FileReader("C:\\Users\\Berny\\Documents\\David\\Respaldos\\Proyecto-3\\mineRider\\chimera.json"));

            JSONObject jsonObject =  (JSONObject) obj;

              String nombre =  (String) jsonObject.get("nombre");
            System.out.println(nombre);

            String longAttack = (String) jsonObject.get("longAttack");
           System.out.println(longAttack);
           
            String shortAttack = (String) jsonObject.get("shortAttack");
           System.out.println(shortAttack);
            
              String defensa = (String) jsonObject.get("defensa");
            System.out.println(defensa);
            
              String retraso = (String) jsonObject.get("retraso");
            System.out.println(retraso);
            
              String alcance = (String) jsonObject.get("alcance");
            System.out.println(alcance);
            
             
            Chimera chimera=new Chimera(nombre, 0, 0, Integer.parseInt((String)shortAttack), Integer.parseInt((String)longAttack),Integer.parseInt((String)defensa) ,Integer.parseInt((String)retraso) , Integer.parseInt((String)alcance), "Izquierda", imagenChimera);
             return chimera;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
       return null;
    }
}


