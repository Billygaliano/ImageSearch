/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author inftel12
 */
public class ImageDAO {
    public ArrayList<Imagen> getImagesByName(String imageName){
        MongoClient mongoClient = new MongoClient("192.168.183.81", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("imagenes");
        ArrayList<Imagen> images = new ArrayList();
        Imagen image;
        
        FindIterable<Document> iterable = collection.find(
        new Document("nombre_imagen", imageName));
        
        for(Document document: iterable){
                image = new Imagen();
                image.setId_image((Integer) document.get("_id"));
                image.setPath((String) document.get("ruta"));
                image.setImage_name((String) document.get("nombre_imagen"));
                image.setExtension((String) document.get("extension"));
                images.add(image);
            }
        return images;
    }
    
    public ArrayList<Imagen> getImagesByExtension(String imageExtension){
        MongoClient mongoClient = new MongoClient("192.168.183.81", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("imagenes");
        ArrayList<Imagen> images = new ArrayList();
        Imagen image;
        
        FindIterable<Document> iterable = collection.find(
        new Document("extension", imageExtension));
        
        for(Document document: iterable){
                image = new Imagen();
                image.setId_image((Integer) document.get("_id"));
                image.setPath((String) document.get("ruta"));
                image.setImage_name((String) document.get("nombre_imagen"));
                image.setExtension((String) document.get("extension"));
                images.add(image);
            }
        return images;
    }
    
    public ArrayList<Imagen> getImagesByBrandLabel(String brandLabel){
        MongoClient mongoClient = new MongoClient("192.168.183.81", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("imagenes");
        ArrayList<Imagen> images = new ArrayList();
        Imagen image;
        
        FindIterable<Document> iterable = collection.find(
        new Document("directorio.etiquetas.valor", brandLabel));
        
        for(Document document: iterable){
                image = new Imagen();
                image.setId_image((Integer) document.get("_id"));
                image.setPath((String) document.get("ruta"));
                image.setImage_name((String) document.get("nombre_imagen"));
                image.setExtension((String) document.get("extension"));
                images.add(image);
            }
        
        return images;
    }
    
    public ArrayList<Imagen> getImagesByModelLabel(String modelLabel){
        MongoClient mongoClient = new MongoClient("192.168.183.81", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("imagenes");
        ArrayList<Imagen> images = new ArrayList();
        Imagen image;
        
        FindIterable<Document> iterable = collection.find(
        new Document("directorio.etiquetas.valor", modelLabel));
        
        for(Document document: iterable){
                image = new Imagen();
                image.setId_image((Integer) document.get("_id"));
                image.setPath((String) document.get("ruta"));
                image.setImage_name((String) document.get("nombre_imagen"));
                image.setExtension((String) document.get("extension"));
                images.add(image);
            }
        
        return images;
    }
    
    public ArrayList<Imagen> getImagesByDateLabel(String dateLabel){
        MongoClient mongoClient = new MongoClient("192.168.183.81", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("imagenes");
        ArrayList<Imagen> images = new ArrayList();
        Imagen image;
        
        FindIterable<Document> iterable = collection.find(
        new Document("directorio.etiquetas.valor", dateLabel));
        
        for(Document document: iterable){
                image = new Imagen();
                image.setId_image((Integer) document.get("_id"));
                image.setPath((String) document.get("ruta"));
                image.setImage_name((String) document.get("nombre_imagen"));
                image.setExtension((String) document.get("extension"));
                images.add(image);
            }
        
        return images;
    }
    
    public ArrayList<Imagen> getImagesByDirectoryLabel(String directoryLabel){
        MongoClient mongoClient = new MongoClient("192.168.183.81", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("imagenes");
        ArrayList<Imagen> images = new ArrayList();
        Imagen image;
        
        FindIterable<Document> iterable = collection.find(
        new Document("directorio.nombre_directorio", directoryLabel));
        
        for(Document document: iterable){
                image = new Imagen();
                image.setId_image((Integer) document.get("_id"));
                image.setPath((String) document.get("ruta"));
                image.setImage_name((String) document.get("nombre_imagen"));
                image.setExtension((String) document.get("extension"));
                images.add(image);
            }
        
        return images;
    }
    
    public Imagen getImageById(int imageId){
        MongoClient mongoClient = new MongoClient("192.168.183.81", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("imagen");
        Imagen image = new Imagen();
        ArrayList<Directory> directories = new ArrayList();
        
        FindIterable<Document> iterable = collection.find(
        new Document("id", imageId));        
        
        for(Document document: iterable){
            Directory directory = new Directory();
            Label label = new Label();
            image.setPath((String) document.get("ruta"));
            image.setImage_name((String) document.get("nombre_imagen"));
            image.setExtension((String) document.get("extension"));
            directory.setDirectory_name((String) document.get("directorio"));
            label.setName_label((String) document.get("etiqueta"));
            label.setValue((String) document.get("valor"));
            directory.setLabel(label);
            directories.add(directory);
            
            image.setDirectories(directories);
        }
        
        return image;
    }
}