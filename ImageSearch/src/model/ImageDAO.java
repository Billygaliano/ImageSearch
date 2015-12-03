/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mongodb.Block;
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
    public ArrayList<Image> getImagesByName(String imageName){
        ArrayList<Image> images = new ArrayList();
        
        return images;
    }
    
    public ArrayList<Image> getImagesByExtension(String imageExtension){
        ArrayList<Image> images = new ArrayList();
        
        return images;
    }
    
    public ArrayList<Image> getImagesByBrandLabel(String brandLabel){
        ArrayList<Image> images = new ArrayList();
        
        return images;
    }
    
    public ArrayList<Image> getImagesByModelLabel(String modelLabel){
        ArrayList<Image> images = new ArrayList();
        
        return images;
    }
    
    public ArrayList<Image> getImagesByLatitudeLabel(String latitudeLabel){
        ArrayList<Image> images = new ArrayList();
        
        return images;
    }
    
    public ArrayList<Image> getImagesByLongitudeLabel(String longitudeLabel){
        ArrayList<Image> images = new ArrayList();
        
        return images;
    }
    
    public Image getImageById(int imageId){
        MongoClient mongoClient = new MongoClient("192.168.183.81", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("imagenes");
        Image image = new Image();
        
        FindIterable<Document> iterable = collection.find(
        new Document("id", imageId));
        
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
        
        return image;
    }
}
