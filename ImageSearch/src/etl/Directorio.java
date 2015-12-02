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
public class Directorio {
    private int id_directorio;
    private String nombre_directorio;
    private ArrayList<String> etiqueta;

    public int getId_directorio() {
        return id_directorio;
    }

    public void setId_directorio(int id_directorio) {
        this.id_directorio = id_directorio;
    }

    public String getNombre_directorio() {
        return nombre_directorio;
    }

    public void setNombre_directorio(String nombre_directorio) {
        this.nombre_directorio = nombre_directorio;
    }

    public ArrayList<String> getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(ArrayList<String> etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return "Directorio{" + "id_directorio=" + id_directorio + ", nombre_directorio=" + nombre_directorio + ", etiqueta=" + etiqueta + '}';
    }

    
    
    
}
