/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.scene.control.TextField;

/**
 *
 * @author David
 */
public class auxiliarControles {


 
     //Validar si se ingresan numero en el tamño de matriz
        //comprobar si los strings que entran por textField son numerosEnteros
    public boolean isEntero(TextField numRow, TextField numColum) {
        int enteroRow;
        int enteroColum;
        boolean esEntero = true;
        try {
            enteroRow = (Integer.parseInt(numRow.getText()));
            enteroColum = (Integer.parseInt(numColum.getText()));
        } catch (Exception e) {
            esEntero = false;
            numRow.setText("");
            numColum.setText("");
        }
        return esEntero;
    }//fin isEntero

   
        }     
    

