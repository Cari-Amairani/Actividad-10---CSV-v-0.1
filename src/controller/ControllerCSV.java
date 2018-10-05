
/**
 *
 * @author Carina Amairani Díaz Ramírez
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModelCSV;
import view.ViewCSV;

public class ControllerCSV {
    
     // Crea un objeto para modelo
    ModelCSV modelCSV;
    
    ViewCSV viewCSV; 
    // Crea un objeto para ls vista
    
 
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           if (e.getSource() == viewCSV.jB_Nuevo)
                    jB_Nuevo_action_performed();
            else if(e.getSource() == viewCSV.jB_Guardar){
                jB_Guardar_action_performed();
            }
        }
    };
    
    /**
     * Método para el boton Nuevo
     */

    private void jB_Nuevo_action_performed() {
         //limpia las cajas de texto
       viewCSV.jTF_Nombre.setText(" ");
       viewCSV.jTF_Email.setText(" ");
               
        }
     
    
    /**
     * Método para el boton Guardar
     */
      private void jB_Guardar_action_performed() {
          
          //Guarda el nuevo valor que se escriba en las cajas de texto 
          modelCSV.setNombre(String.valueOf(viewCSV.jTF_Nombre.getText()));
       modelCSV.setEmail(String.valueOf(viewCSV.jTF_Email.getText()));
        modelCSV.writeFile();
        
           
       }
    
    
    public ControllerCSV(ModelCSV modelCSV, ViewCSV viewCSV) {
        this.viewCSV = viewCSV;
        this.modelCSV = modelCSV;
        this.viewCSV.jB_Guardar.addActionListener(actionListener);
        this.viewCSV.jB_Nuevo.addActionListener(actionListener);
        initComponents();
    }
    
    
    /**
     * Conponentes de la vista
     */
    private void initComponents(){
            viewCSV.setVisible(true);
            modelCSV.readFile();
            viewCSV.jTF_Nombre.setText(modelCSV.getNombre());
            viewCSV.jTF_Email.setText(modelCSV.getEmail());
        
    }
    
}
