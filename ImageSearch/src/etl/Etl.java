/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl;


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

/**
 *
 * @author inftel11
 */
public class Etl {
    
    public static void main(String args[]){
        MongoClient mongoClient = new MongoClient("192.168.183.81", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("imagenes");
        ArrayList<Imagen> imagenes=new ArrayList<>();
        Imagen imagen= new Imagen();
        Directorio directorio =new Directorio();
        ArrayList<Directorio> directorios=new ArrayList<>();
        Etiqueta etiqueta=new Etiqueta();
        Ruta ruta = new Ruta();
//        ArrayList<Etiqueta> etiquetas=new ArrayList<>();
        
        
        Connection connection=null;
       
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
            ResultSet rs=connection.createStatement().executeQuery("Select * from imagen");
                rs.next();
                imagen.setId(rs.getInt("id_imagen"));
                int id_imagen=rs.getInt("id_imagen");
                imagen.setRuta(rs.getInt("id_ruta"));
                int id_ruta = rs.getInt("id_ruta");
                imagen.setNombre_imagen(rs.getString("nombre_imagen"));
                imagen.setExtension(rs.getString("extension"));
                imagen.setTamanio(rs.getInt("tamanio_imagen"));
                System.out.println(imagen);
            
            rs=connection.createStatement().executeQuery("Select * from ruta where id_ruta="+id_ruta);
            rs.next();
            ruta.setNombre_ruta(rs.getString("nombre_ruta"));
            System.out.println(ruta);
            
            rs=connection.createStatement().executeQuery("Select * from valor where id_ruta="+id_ruta+" and id_imagen="+id_imagen);
            rs.next();
            ruta.setNombre_ruta(rs.getString("nombre_ruta"));
            
            
            
        }catch(SQLException ex){
            System.out.println("Error en sql");
        }
            
        
        
//        try{
//            ResultSet rs=connection.createStatement().executeQuery("Select * from imagen");
//            while(rs.next()){
//                imagen.setId(rs.getInt("id_imagen"));
//                imagen.setRuta(rs.getInt("id_ruta"));
//                imagen.setNombre_imagen(rs.getString("nombre_imagen"));
//                imagen.setExtension(rs.getString("extension"));
//                imagen.setTamanio(rs.getInt("tamanio_imagen"));
//                imagenes.add(imagen);
//                System.out.println(imagen);
//            }
//        
//        }catch(SQLException ex){
//            System.out.println("Error en sql");
//        }
//        
//        try{
//            ResultSet rs=connection.createStatement().executeQuery("Select * from directorio");
//            while(rs.next()){
//                directorio.setId_directorio(rs.getInt("id_directorio"));
//                directorio.setNombre_directorio(rs.getString("nombre_directorio"));
//                directorios.add(directorio);
//                System.out.println(directorio);
//            }
//        
//        }catch(SQLException ex){
//            System.out.println("Error en sql");
//        }
//        
//        try{
//            ResultSet rs=connection.createStatement().executeQuery("Select * from etiqueta");
//            while(rs.next()){
//                etiqueta.setId_etiqueta(rs.getInt("id_etiqueta"));
//                etiqueta.setNombre_etiqueta(rs.getString("nombre_etiqueta"));
//                etiqueta.setValor(rs.getString("valor"));
//                System.out.println(directorio);
//            }
//        
//        }catch(SQLException ex){
//            System.out.println("Error en sql");
//        }
//        
//        
        
        
        
//        collection.insertOne(
//                new Document("id",8)
//                    .append("nombre_imagen","prueba2")
//                    .append("extension","jpg")
//                    .append("ruta","/imagen")
//                    .append("tamaño",23)
//                    .append("directorio",asList(
//                            new Document()
//                            .append("nombre_directorio","gps")
//                            .append("etiqueta",asList(
//                                new Document()
//                                .append("nombre_etiqueta","model")
//                                .append("valor","bq")))))
//        );
//        
        
        
        
        
        
               
//{
//	"_id" : ObjectId("565f0d7993a38bf39c9729fc"),
//	"id" : 1,
//	"nombre_imagen" : "prueba",
//	"extension" : "jpg",
//	"ruta" : "imagen/",
//	"tamaño" : "23",
//	"directorio" : [
//		{
//			"nombre_directorio" : "exif",
//			"etiqueta" : [
//				{
//					"nombre_etiqueta" : "marca",
//					"valor" : "bq"
//				}
//			]
//		}
//	]
//}

//        );
    
    }
}
