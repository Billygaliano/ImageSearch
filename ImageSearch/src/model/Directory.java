/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author inftel12
 */
public class Directory {
    private String directory_name;
    private ArrayList<Label> labels;

    public Directory(String directory_name, ArrayList<Label> labels) {
        this.directory_name = directory_name;
        this.labels = labels;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.directory_name);
        hash = 23 * hash + Objects.hashCode(this.labels);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Directory other = (Directory) obj;
        if (!Objects.equals(this.directory_name, other.directory_name)) {
            return false;
        }
        if (!Objects.equals(this.labels, other.labels)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Directory{" + "directory_name=" + directory_name + ", labels=" + labels + '}';
    }

    public String getDirectory_name() {
        return directory_name;
    }

    public void setDirectory_name(String directory_name) {
        this.directory_name = directory_name;
    }

    public ArrayList<Label> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<Label> labels) {
        this.labels = labels;
    }
    
    
}
