package model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author inftel12
 */
public class Image {
    private int id_image;
    private String path;
    private String image_name;
    private String extension;
    private int size;
    private ArrayList<Directory> directories;

    public Image(int id_image, String path, String image_name, String extension, int size, ArrayList<Directory> directories) {
        this.id_image = id_image;
        this.path = path;
        this.image_name = image_name;
        this.extension = extension;
        this.size = size;
        this.directories = directories;
    }

    public Image() {}

    @Override
    public String toString() {
        return "Image{" + "id_image=" + id_image + ", path=" + path + ", image_name=" + image_name + ", extension=" + extension + ", size=" + size + ", directories=" + directories + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id_image;
        hash = 41 * hash + Objects.hashCode(this.path);
        hash = 41 * hash + Objects.hashCode(this.image_name);
        hash = 41 * hash + Objects.hashCode(this.extension);
        hash = 41 * hash + this.size;
        hash = 41 * hash + Objects.hashCode(this.directories);
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
        final Image other = (Image) obj;
        if (this.id_image != other.id_image) {
            return false;
        }
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.image_name, other.image_name)) {
            return false;
        }
        if (!Objects.equals(this.extension, other.extension)) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        if (!Objects.equals(this.directories, other.directories)) {
            return false;
        }
        return true;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Directory> getDirectory() {
        return directories;
    }

    public void setDirectory(ArrayList<Directory> directories) {
        this.directories = directories;
    }
    
    
}
