package com.johannfjs.utils;

/**
 * Created by alumno on 10/21/15.
 */
public class Querys {

    public static final String DB_NAME = "dbtest";
    public static final Integer DB_VERSION  = 1;
    public static final String TB_ARTICULOS = "tb_articulos";
    public static final String C_ID = "id";
    public static final String C_TITULO = "titulo";
    public static final String C_DESCRIPCION = "descripcion";
    public static final String C_CATEGORIA = "categoria";

    public static final String CREAR_TB_ARTICULOS = "CREATE TABLE "+ TB_ARTICULOS +
            "(" + C_ID + " INTEGER AUTOINCREMENT PRIMARY KEY, "+
            C_TITULO + " TEXT,"+
            C_DESCRIPCION+" TEXT,"+
            C_CATEGORIA+" TEXT)";
    public static final String ELIMINAR_TB_ARTICULOS = "DROP TABLE "+ TB_ARTICULOS;

    public static final String TB_IMAGENES = "tb_imagenes";
    public static final String C_URL = "url";
    public static final String CREAR_TB_IMAGENES = "CREATE TABLE "+ TB_IMAGENES + "("+
            C_TITULO + " TEXT," + C_URL + " TEXT)";
    public static final String ELIMINAR_TB_IMAGENES = "DROP TABLE "+TB_IMAGENES;
}
