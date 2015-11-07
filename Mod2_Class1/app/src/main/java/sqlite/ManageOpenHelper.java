package sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import utils.ConstanteSQL;

/**
 * Created by alumno on 10/14/15.
 */
public class ManageOpenHelper extends SQLiteOpenHelper {
    public ManageOpenHelper(Context context) {
        super(context, ConstanteSQL.DB_NAME, null, ConstanteSQL.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConstanteSQL.CREAR_TB_USUARIO);
        db.execSQL(ConstanteSQL.CREAR_TB_SESION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ConstanteSQL.ELIMINAR_TB_USUARIO);
        db.execSQL(ConstanteSQL.ELIMINAR_TB_SESION);
        onCreate(db);
    }
}
