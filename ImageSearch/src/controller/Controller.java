/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import model.Image;
import model.ImageDAO;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

/**
 *
 * @author inftel12
 */
public class Controller {
    public void printImagesByName(JTable jTableImages, String imageName){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Image> images = imageDao.getImagesByName(imageName);
        
        String title[] = {"Id", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[2];
        
        for (Image image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printImagesByExtension(JTable jTableImages, String imageExtension){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Image> images = imageDao.getImagesByExtension(imageExtension);
        
        String title[] = {"Id", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[2];
        
        for (Image image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printImagesByBrandLabel(JTable jTableImages, String brandLabel){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Image> images = imageDao.getImagesByBrandLabel(brandLabel);
        
        String title[] = {"Id", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[2];
        
        for (Image image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printImagesByModelLabel(JTable jTableImages, String modelLabel){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Image> images = imageDao.getImagesByModelLabel(modelLabel);
        
        String title[] = {"Id", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[2];
        
        for (Image image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printImagesByLatitudeLabel(JTable jTableImages, String latitudeLabel){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Image> images = imageDao.getImagesByLatitudeLabel(latitudeLabel);
        
        String title[] = {"Id", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[2];
        
        for (Image image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printImagesByLongitudeLabel(JTable jTableImages, String longitudeLabel){
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Image> images = imageDao.getImagesByLongitudeLabel(longitudeLabel);
        
        String title[] = {"Id", "Imagen"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[2];
        
        for (Image image : images) {
            row[0] = Integer.toString(image.getId_image());
            row[1] = image.getImage_name();
            
            m.addRow(row); 
        }
        
        jTableImages.setModel(m);
    }
    
    public void printSelectedImage(JLabel jLabelImage, JTextArea jTextAreaData, int imageId) throws IOException{
        ImageDAO imageDao = new ImageDAO();
        Image image = imageDao.getImageById(imageId);
        
        String pathFrom = image.getPath()+image.getImage_name()+"."+image.getExtension(); 
        String pathTo = "./src/properties/thumbnails/thumbnail.png";
        
        Thumbnails.of(new File(pathFrom))
        .size(400, 290)
        .toFile("./src/properties/thumbnails/thumbnail.png");
        
        URL url = this.getClass().getResource(pathTo);  
        ImageIcon icon = new ImageIcon(url); 
        jLabelImage.setIcon(null);
        
        
    }
}
