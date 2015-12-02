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
            System.out.print(file.getName());
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
    
//    private static int insertarDatos(){
//        Connection connection;
//        Statement statementSQL;
//        ResultSet result;
//        String url = "jdbc:oracle:thin:INFTEL15_11/INFTEL@olimpia.lcc.uma.es:1521:edgar";
//        return i;
//    }
    
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
            System.out.println(image.getName()+"\n\n\n");
            if(!image.getName().equals(".DS_Store")){
                Metadata metadata = new Metadata();
                metadata = ImageMetadataReader.readMetadata(image);
                if (metadata != null) {
                    for (Directory directory : metadata.getDirectories()) {
                        System.out.println("directory: " + directory);
                        for (Tag tag : directory.getTags()) {
                            System.out.println("  tag: " + tag);
                        }
                    }
                }
            }
        }
    }
}
