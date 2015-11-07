package models;

/**
 * Created by alumno on 10/5/15.
 */
public class Imagenes {
    private String urlImagen;
    private String titulo;
    private String contenido;
    private String fecha;
    private int id;

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Imagenes(String urlImagen, String titulo, String contenido, String fecha, int id) {
        this.urlImagen = urlImagen;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.id = id;
    }


    public String getUrlImagen() {
        return urlImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getFecha() {
        return fecha;
    }



}
