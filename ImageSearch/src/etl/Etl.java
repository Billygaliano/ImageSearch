/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.sql.*;
import java.util.ArrayList;
import org.bson.Document;
import java.util.List;
import java.util.TreeSet;


/**
 *
 * @author inftel11
 */
public class Etl {
    
    public static void main(String args[]){
        MongoClient mongoClient = new MongoClient("192.168.183.81", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("imagenes");   
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

                ResultSet rs_valor = connection.createStatement().executeQuery("Select DISTINCT * from valor where id_ruta=" + id_ruta + " and id_imagen=" + id_imagen +"order by id_directorio");
                int i = 0;
                List<Document> directorios = new ArrayList();
                List<Document> etiquetas = new ArrayList();
                TreeSet<Integer> directorios_id = new TreeSet();
                ArrayList<Integer> etiquetas_id = new ArrayList();

                while(rs_valor.next()){
                    directorios_id.add(rs_valor.getInt("id_directorio"));
                }

                for (Integer id_directorio : directorios_id) {
                    ResultSet rs_valor1 = connection.createStatement().executeQuery("Select * from valor where id_directorio=" + id_directorio + " and id_imagen="+id_imagen+ " and id_ruta="+id_ruta);
                    etiquetas = new ArrayList();
                    while(rs_valor1.next()){
                        Document etiqueta = new Document();
                        int id_etiqueta = rs_valor1.getInt("id_etiqueta");
                        ResultSet rs_etiqueta = connection.createStatement().executeQuery("Select nombre_etiqueta from etiqueta where id_etiqueta=" + id_etiqueta);
                        rs_etiqueta.next();
                        String nombre_etiqueta = rs_etiqueta.getString("nombre_etiqueta");
                        String valor = rs_valor1.getString("valor");
                        etiqueta.append("nombre_etiqueta",nombre_etiqueta);
                        etiqueta.append("valor", valor);
                        etiquetas.add(etiqueta);
                    }

                    Document directorio = new Document();
                    ResultSet rs_directorio = connection.createStatement().executeQuery("Select nombre_directorio from directorio where id_directorio=" + id_directorio);
                    rs_directorio.next();
                    String nombre_directorio = rs_directorio.getString("nombre_directorio");
                    directorio.append("nombre_directorio",nombre_directorio);
                    directorio.append("etiquetas", etiquetas);
                    directorios.add(directorio);                       
                }

                Document doc = new Document("_id",id_imagen);
                doc.append("ruta", nombre_ruta);
                doc.append("nombre_imagen",nombre_imagen);
                doc.append("extension", extension);
                doc.append("directorio",directorios);

                collection.insertOne(doc);
            }
        } catch (SQLException ex) {
            System.out.println("Error en sql"+ex);
        } 
    }
}
