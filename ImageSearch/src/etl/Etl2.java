/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl;


import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.sql.*;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import org.bson.Document;
import com.mongodb.util.JSON;


/**
 *
 * @author inftel11
 */
public class Etl2 {
    
    public static void main(String args[]){
        MongoClient mongoClient = new MongoClient("192.168.183.81", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("imagen");   
        Connection connection=null;
        
        String directorio_antiguo=null;
       
        Statement stmt;
        String url="jdbc:oracle:thin:INFTEL15_11/INFTEL@olimpia.lcc.uma.es:1521:edgar";
        try{
            String driver="oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);
            connection=DriverManager.getConnection(url);
        }catch(Exception e){
            System.out.println("Error al conectar con la base de datos");
        }
        
        try{
            ResultSet rs_imagen=connection.createStatement().executeQuery("Select * from imagen");
               while (rs_imagen.next()) {
                    int id_imagen = rs_imagen.getInt("id_imagen");
                    int id_ruta = rs_imagen.getInt("id_ruta");
                    String nombre_imagen = rs_imagen.getString("nombre_imagen");
                    String extension = rs_imagen.getString("extension");
                    int tamanio = rs_imagen.getInt("tamanio_imagen");

                    ResultSet rs_ruta = connection.createStatement().executeQuery("Select * from ruta where id_ruta=" + id_ruta);
                    rs_ruta.next();
                    String nombre_ruta = rs_ruta.getString("nombre_ruta");

                    ResultSet rs_valor = connection.createStatement().executeQuery("Select * from valor where id_ruta=" + id_ruta + " and id_imagen=" + id_imagen +"order by id_directorio");
                    int i = 0;
                    while (rs_valor.next()) {

                        String valor = rs_valor.getString("valor");
                        int id_etiqueta = rs_valor.getInt("id_etiqueta");
                        int id_directorio = rs_valor.getInt("id_directorio");

                        ResultSet rs_etiqueta = connection.createStatement().executeQuery("Select * from etiqueta where id_etiqueta=" + id_etiqueta);
                        rs_etiqueta.next();
                        String nombre_etiqueta = rs_etiqueta.getString("nombre_etiqueta");

                        ResultSet rs_directorio = connection.createStatement().executeQuery("Select * from directorio where id_directorio=" + id_directorio);
                        rs_directorio.next();
                        String nombre_directorio = rs_directorio.getString("nombre_directorio");
                        System.out.println(nombre_directorio);
                            
                                                
                    collection.insertOne(
                            new Document("id", id_imagen)
                            .append("nombre_imagen", nombre_imagen)
                            .append("extension", extension)
                            .append("ruta",nombre_ruta)
                            .append("directorio",nombre_directorio)
                            .append("etiqueta", nombre_etiqueta)
                            .append("valor",valor));
                        
                        rs_etiqueta.close();
                        rs_directorio.close();
                    }
            }
        } catch (SQLException ex) {
            System.out.println("Error en sql"+ex);
        } 
    }
}

