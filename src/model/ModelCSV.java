/**
 *
 * @author Carina Amairani Díaz Ramírez
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ModelCSV {
    
    private String nombre = " ";
    private String email = " ";
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Almacena la ruta del archivo
     private String path = "C:\\Users\\Ami\\Documents\\NetBeansProjects\\CSV_!0\\base.csv"; 
     
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    
    /**
     * Método para mostrar contenido del archivo.
     *
     * @param path: Indica la ruta donde se encuentra el archivo.
     * @return
     */
    public void readFile(){
        try{
            //Muestra las filas. 
                String row; 
                // Muestra el contenido del archivo
            try (FileReader file = new FileReader(path);
              // Almacena el contenido 
                    BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                    String [] posicion = row.split(",");
                    nombre = posicion[0];
                    email = posicion[1]; 
                }
            } 
             //Marca los errores
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"No existe el archivo" + ex.getMessage());
                 //Marca error si no se puede visualizar el archivo
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Error en I/O operación" + ex.getMessage());
        }
    }
    
    
    
    /**
     * Método para escribir Guardar  el nuevo contenido del fichero
     * @param path: Ruta del archivo
     * @param message: Almacena el texto 
     */
    public void writeFile(){
        try{
            //Abre el archivo, si no existe se crea
                File file = new File(path);
                FileWriter fileWriter = new FileWriter (file,true);
                try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                        ArrayList<String> nuevo = new ArrayList<>();
                        nuevo.add(nombre);
                        nuevo.add(email);
                        //Separa cada registro del nombre y el email meiante una coma
                        printWriter.print(nombre + "," + email + "\n ");
                        printWriter.close();
            }
                //Evalua si no hay errores
                JOptionPane.showMessageDialog(null, "Registro guardado");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Error en I/O operación" + ex.getMessage());
                }
            }
    
}
