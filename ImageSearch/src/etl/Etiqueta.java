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
public class Etiqueta {
    
    int id_etiqueta;
    String nombre_etiqueta;
    ArrayList<String> valor;

    public int getId_etiqueta() {
        return id_etiqueta;
    }

    public void setId_etiqueta(int id_etiqueta) {
        this.id_etiqueta = id_etiqueta;
    }

    public String getNombre_etiqueta() {
        return nombre_etiqueta;
    }

    public void setNombre_etiqueta(String nombre_etiqueta) {
        this.nombre_etiqueta = nombre_etiqueta;
    }

    public ArrayList<String> getValor() {
        return valor;
    }

    public void setValor(ArrayList<String> valor) {
        this.valor = valor;
    }
    
}
