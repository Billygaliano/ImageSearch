/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Directory;
import model.Imagen;
import model.ImageDAO;

/**
 *
 * @author inftel12
 */
public class Controller {
    public void printImagesByName(JTable jTableImages, String imageName){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Imagen> images = imageDao.getImagesByName(imageName);
        
        String title[] = {"Id", "Ruta", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[3];
        
        for (Imagen image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getPath();
            row[2] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printImagesByExtension(JTable jTableImages, String imageExtension){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Imagen> images = imageDao.getImagesByExtension(imageExtension);
        
        String title[] = {"Id", "Ruta", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[3];
        
        for (Imagen image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getPath();
            row[2] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printImagesByBrandLabel(JTable jTableImages, String brandLabel){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Imagen> images = imageDao.getImagesByBrandLabel(brandLabel);
        
        String title[] = {"Id", "Ruta", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[3];
        
        for (Imagen image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getPath();
            row[2] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printImagesByModelLabel(JTable jTableImages, String modelLabel){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Imagen> images = imageDao.getImagesByModelLabel(modelLabel);
        
        String title[] = {"Id", "Ruta", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[3];
        
        for (Imagen image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getPath();
            row[2] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printImagesByDateLabel(JTable jTableImages, String dateLabel){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Imagen> images = imageDao.getImagesByDateLabel(dateLabel);
        
        String title[] = {"Id", "Ruta", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[3];
        
        for (Imagen image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getPath();
            row[2] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printImagesByDirectoryLabel(JTable jTableImages, String directoryLabel){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Imagen> images = imageDao.getImagesByDirectoryLabel(directoryLabel);
        
        String title[] = {"Id", "Ruta", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[3];
        
        for (Imagen image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getPath();
            row[2] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printSelectedImage(JLabel jLabelImage, JTable jTableImagesData, int imageId) throws IOException{
        ImageDAO imageDao = new ImageDAO();
        Imagen image = imageDao.getImageById(imageId);
        System.out.println(image);
        ArrayList<Directory> directories = image.getDirectories();
        String pathFrom = image.getPath()+"/"+image.getImage_name()+"."+image.getExtension(); 
        String pathTo = "src/properties/thumbnail.png";
        
        //Setting the resized image as icon of jLabelImage
        ImageIcon icon = new ImageIcon(pathFrom);
        ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_DEFAULT));
        jLabelImage.setIcon(icon2);
        
        //Adding the text with de image's info in the jTableImagesData
        String title[] = {"Directorio", "Etiqueta", "Valor"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[3];  
        for (Directory directory : directories) {
            row[0] = directory.getDirectory_name();
            row[1] = directory.getLabel().getName_label();
            row[2] = directory.getLabel().getValue();
            
            m.addRow(row); 
        }        
        jTableImagesData.setModel(m);
    }
}
