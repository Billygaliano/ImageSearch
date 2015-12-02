/**
 * ////////////////////    Indexer   ////////////////////
 * Description: 
 */
package indexer;

/**
 *
 * @author FERNANDO
 */

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author Fernando
 */
public class Indexer
{
    private static ArrayList<File> getArchivos(File ruta){
        ArrayList<File> archivos = new ArrayList();
        File[] nombres_archivos = ruta.listFiles();
        for(File file: nombres_archivos){
            if(file.isDirectory()){
                ArrayList<File> archivos_subcarpeta = getArchivos(file);
                for (File archivo : archivos_subcarpeta) {
                    archivos.add(archivo);
                }
            }else{
                archivos.add(file);
            }
        }
        
        return archivos;
    }
    
    private static String insertMetadata(String Imagen, String nomDirectorio, String nomEtiqueta, String nomValor){
        Connection connection = null;
        Statement statementSQL;
        ResultSet result;
        String upperCased = null;
        String url = "jdbc:oracle:thin:INFTEL15_11/INFTEL@olimpia.lcc.uma.es:1521:edgar";
        
        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);
            connection = DriverManager.getConnection(url);
            } catch (Exception e) {
            System.out.println("Error loading the driver or connect to data base");
            }
            try {
            ResultSet rs_id = connection.createStatement().executeQuery("select id_imagen from imagen where NOMBRE_IMAGEN='" + Imagen + "'");
            rs_id.next();
            int id_imagen = rs_id.getInt(1);
                
            CallableStatement upperProc = connection.prepareCall("{ call INSERTMETADATA2(?,?,?,?)}");
            upperProc.setInt(1,id_imagen);
            upperProc.setString(2,nomDirectorio);
            upperProc.setString(3,nomEtiqueta);
            upperProc.setString(4,nomValor);
            
            upperProc.execute();
            upperProc.close();
            } catch (SQLException ex) {
            }
        return upperCased;
    }
    
    private static String insertarImagen(String Ruta_Nombre,String Nombre_Imagen,String Extension,long Tamano){
        Connection connection = null;
        Statement statementSQL;
        ResultSet result;
        String upperCased = null;
        String url = "jdbc:oracle:thin:INFTEL15_11/INFTEL@olimpia.lcc.uma.es:1521:edgar";
        
        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);
            connection = DriverManager.getConnection(url);
            } catch (Exception e) {
            System.out.println("Error loading the driver or connect to data base");
            }
            try {

            CallableStatement upperProc = connection.prepareCall("{ ? = call INSERTIMAGE(?,?,?,?)}");
            upperProc.registerOutParameter(1, Types.VARCHAR);
            upperProc.setString(2,Ruta_Nombre);
            upperProc.setString(3,Nombre_Imagen);
            upperProc.setString(4,Extension);
            upperProc.setLong(5,Tamano);
            
            upperProc.execute();
            upperCased = upperProc.getString(1);
            upperProc.close();
            } catch (SQLException ex) {
            }
        return upperCased;
    }
    
    private static String muestraContenido() throws FileNotFoundException, IOException {
        String nombreArchivo = new String();
        try {
            Properties propiedades = new Properties();
            propiedades.load(new FileInputStream("./src/properties/config.properties"));
            nombreArchivo = propiedades.getProperty("nombreArchivo");
        } catch (FileNotFoundException e) {
            System.out.println("Error, El archivo no exite");
        } catch (IOException e) {
            System.out.println("Error, No se puede leer el archivo");
        }
        
        return nombreArchivo;
    }
    
    public static void main(String[] args ) throws ImageProcessingException, IOException{
        String rutaOriginal = muestraContenido();
        File ruta = new File(rutaOriginal);
        ArrayList<File> imagenes = getArchivos(ruta);
        
        for (Iterator<File> it = imagenes.iterator(); it.hasNext();) {
            File image = it.next();
            String nombreRuta = image.getParent();
            String imagen = image.getName();
            int indiceImagen = imagen.lastIndexOf('.');
            String nombreImagen = imagen.substring(0,indiceImagen);
            imagen = image.getName();
            String extension = imagen.substring(indiceImagen+1);
            long tamano = image.length();
            System.out.println("\n\n\n"+nombreRuta+"  " + nombreImagen + " " + extension + " " + tamano+"\n\n\n");
            String imageninsertada = insertarImagen(nombreRuta,nombreImagen,extension,tamano);
                    
            if(!image.getName().equals(".DS_Store")){
                Metadata metadata = new Metadata();
                metadata = ImageMetadataReader.readMetadata(image);
                if (metadata != null) {
                    for (Directory directory : metadata.getDirectories()) {
                        System.out.println("directory: " + directory);
                        for (Tag tag : directory.getTags()) {
                            System.out.println("  tag: " + tag.getTagName() + "  " + " valor es " +tag.getDescription());
                            String metadata2 = insertMetadata(nombreImagen, directory.getName(),tag.getTagName(),tag.getDescription());
                        }
                    }
                }
            }
        }
    }
}
