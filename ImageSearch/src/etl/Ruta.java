/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl;

/**
 *
 * @author inftel11
 */
public class Ruta {
    private int id_ruta;
    private String nombre_ruta;

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getNombre_ruta() {
        return nombre_ruta;
    }

    public void setNombre_ruta(String nombre_ruta) {
        this.nombre_ruta = nombre_ruta;
    }

    @Override
    public String toString() {
        return "Ruta{" + "id_ruta=" + id_ruta + ", nombre_ruta=" + nombre_ruta + '}';
    }
    
    
}
