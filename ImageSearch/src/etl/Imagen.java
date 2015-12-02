/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl;

import java.util.ArrayList;

/**
 *
 * @author inftel11
 */
public class Imagen {
    private int id;
    private String nombre_imagen;
    private String extension;
    private int id_ruta;
    private int tamanio;

    public int getId() {
        return id;
    }

    public String getNombre_imagen() {
        return nombre_imagen;
    }

    public String getExtension() {
        return extension;
    }

    public int getRuta() {
        return id_ruta;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_imagen(String nombre_imagen) {
        this.nombre_imagen = nombre_imagen;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setRuta(int ruta) {
        this.id_ruta = ruta;
    }

    @Override
    public String toString() {
        return "Imagen{" + "id=" + id + ", nombre_imagen=" + nombre_imagen + ", extension=" + extension + ", id_ruta=" + id_ruta + ", tamanio=" + tamanio + '}';
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    
    
    
}
