package com.dchavez.models;

/**
 * Created by alumno on 11/7/15.
 */
public class Objeto {
    private String textoUno;
    private String textoDos;
    private String textoTres;
    private String textoCuatro;
    private String rutaImagen;

    public Objeto(String textoUno, String textoDos, String textoTres, String textoCuatro, String rutaImagen) {
        this.textoUno = textoUno;
        this.textoDos = textoDos;
        this.textoTres = textoTres;
        this.textoCuatro = textoCuatro;
        this.rutaImagen = rutaImagen;
    }

    public String getTextoUno() {
        return textoUno;
    }

    public void setTextoUno(String textoUno) {
        this.textoUno = textoUno;
    }

    public String getTextoDos() {
        return textoDos;
    }

    public void setTextoDos(String textoDos) {
        this.textoDos = textoDos;
    }

    public String getTextoTres() {
        return textoTres;
    }

    public void setTextoTres(String textoTres) {
        this.textoTres = textoTres;
    }

    public String getTextoCuatro() {
        return textoCuatro;
    }

    public void setTextoCuatro(String textoCuatro) {
        this.textoCuatro = textoCuatro;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
