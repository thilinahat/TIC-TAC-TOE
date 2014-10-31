/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.awt.Color;
import java.awt.Image;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class GUItest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
        StartForm sForm=new StartForm();
        sForm.setVisible(true);
        sForm.setSize(400, 300);
        sForm.getContentPane().setBackground(Color.BLACK); 
       
    }
}
