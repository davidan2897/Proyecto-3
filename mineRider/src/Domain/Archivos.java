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
            Object obj = parser.parse(new FileReader("C:\\Users\\UsuarioPC\\Desktop\\proyectopppp - copia\\Proyecto-3\\mineRider\\prueba.json"));

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

 

        jsonObject.put("alto", "20");

 

        jsonObject.put("ancho", "20");

 

       

 

        try {

 

            FileWriter jsonFileWriter = new FileWriter("C:\\Users\\UsuarioPC\\Desktop\\proyectopppp - copia\\Proyecto-3\\mineRider\\prueba.json");

            jsonFileWriter.write(jsonObject.toJSONString());

            jsonFileWriter.flush();

            jsonFileWriter.close();

 
            System.out.println(jsonObject);

 

        } catch (IOException e) {

            e.printStackTrace();

        }
 
    }
}


