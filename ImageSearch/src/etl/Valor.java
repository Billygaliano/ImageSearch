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
public class Valor {
    private String valor;
    private int id_valor;
    private int id_imagen;
    private int id_ruta;
    private int id_etiqueta;
    private int id_directorio;

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public int getId_etiqueta() {
        return id_etiqueta;
    }

    public void setId_etiqueta(int id_etiqueta) {
        this.id_etiqueta = id_etiqueta;
    }

    public int getId_directorio() {
        return id_directorio;
    }

    public void setId_directorio(int id_directorio) {
        this.id_directorio = id_directorio;
    }
    

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Valor{" + "valor=" + valor + ", id_valor=" + id_valor + ", id_imagen=" + id_imagen + ", id_ruta=" + id_ruta + ", id_etiqueta=" + id_etiqueta + ", id_directorio=" + id_directorio + '}';
    }

    
}
