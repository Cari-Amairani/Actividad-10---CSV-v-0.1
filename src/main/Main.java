/**
 *
 * @author Carina Amairani Díaz Ramírez
 */
package main;

import controller.ControllerCSV;
import model.ModelCSV;
import view.ViewCSV;


public class Main {

    public static void main(String[] args) {
        ModelCSV modelCSV = new ModelCSV();
        ViewCSV viewCSV = new ViewCSV();
        ControllerCSV controllerCSV = new ControllerCSV(modelCSV, viewCSV); 
    }
    
}
