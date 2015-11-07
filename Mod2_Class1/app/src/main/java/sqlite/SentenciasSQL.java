package sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import models.Usuario;
import utils.ConstanteSQL;

/**
 * Created by alumno on 10/14/15.
 */
public class SentenciasSQL {

    private ManageOpenHelper dbConexion;

    public SentenciasSQL(Context context){
        dbConexion = new ManageOpenHelper(context);
    }

    public void registrarUsuario(Usuario usuario){
        SQLiteDatabase db = dbConexion.getWritableDatabase();
        db.execSQL(
                "INSERT INTO "+ ConstanteSQL.TB_USUARIOS +
                        "(" + ConstanteSQL.C_NOMBRE + "," +
                        ConstanteSQL.C_CORREO + "," +
                        ConstanteSQL.C_CONTRASENIA + " ) VALUES('" +
                        usuario.getNombre() + "','" +
                        usuario.getCorreo() + "','" +
                        usuario.getContrasenia() + "')"
        );
    }

    public Usuario obtenerUsuario(Usuario usuario){
        Usuario resultado = new Usuario();
        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ ConstanteSQL.TB_USUARIOS+" WHERE "+ ConstanteSQL.C_CORREO + "= '"+
                            usuario.getCorreo() + "' AND "+ ConstanteSQL.C_CONTRASENIA + "= '"+
                            usuario.getContrasenia() + "'", null );
        if (c!=null && c.getCount()>0){
            if (c.moveToFirst()){
                do{
                    resultado.setNombre(c.getString(c.getColumnIndex(ConstanteSQL.C_NOMBRE)));
                    resultado.setCorreo(c.getString(c.getColumnIndex(ConstanteSQL.C_CORREO)));
                }while(c.moveToNext());
            }
        }
        return resultado;
    }

    /*public static final String CREAR_TB_USUARIO = "CREATE TABLE" + TB_USUARIOS + "(" + C_NOMBRE + " TEXT," +
            C_CORREO + " TEXT, "+
            C_CONTRASENIA + " TEXT)";*/

    public void registrarSesion(String correo){
        SQLiteDatabase db = dbConexion.getWritableDatabase();
        db.execSQL(
                "INSERT INTO "+ ConstanteSQL.TB_SESION + " ) VALUES('" +
                        correo + "')"
        );
    }

    public void eliminarSesion(){
        SQLiteDatabase db = dbConexion.getWritableDatabase();
        db.execSQL(
                "DELETE FROM " + ConstanteSQL.TB_SESION
        );
    }

    public String obtenerNombreUsuarioLogueado(String correo){
        SQLiteDatabase db = dbConexion.getReadableDatabase();
        String nombre="";
        Cursor cursor = db.rawQuery(
                "SELECT "+ ConstanteSQL.C_NOMBRE + " FROM " + ConstanteSQL.TB_USUARIOS +
                        " WHERE "+ConstanteSQL.C_CORREO + "='" + correo + "'",
                null
        );
        if (cursor!=null && cursor.getCount()>0){
            if (cursor.moveToFirst()){
                do {
                    nombre = cursor.getString(cursor.getColumnIndex(ConstanteSQL.C_NOMBRE));
                }while (cursor.moveToNext());
            }
        }
        return nombre;
    }

    public Boolean verificarSesion(){
        SQLiteDatabase db= dbConexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM "+ ConstanteSQL.TB_SESION,
                null
        );

            return (cursor!=null ? (cursor.getCount() >0 ? true: false): false);
    }

    public String obtenerCorreoSesion(){
        String correo="";
        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+ConstanteSQL.C_CORREO + " FROM "+ ConstanteSQL.TB_SESION, null);

        if (cursor!=null && cursor.getCount()>0){
            if (cursor.moveToFirst()){
                do {
                    correo = cursor.getString(cursor.getColumnIndex(ConstanteSQL.C_CORREO));
                }while (cursor.moveToNext());
            }

        }
        return correo;
    }
}
