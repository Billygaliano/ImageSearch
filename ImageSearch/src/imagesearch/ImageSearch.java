/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesearch;
import view.JF_MainFrame;

/**
 *
 * @author inftel12
 */
public class ImageSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            JF_MainFrame view= new JF_MainFrame();
                   
            public void run() {
                view.setVisible(true);
            }
        });
    }
    
}
