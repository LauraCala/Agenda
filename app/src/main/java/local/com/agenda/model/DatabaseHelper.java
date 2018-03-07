package local.com.agenda.model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import local.com.agenda.constantes.Constantes;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Todo Constantes para crear y eliminar la tabla de contactos
    private static final String CREATE_TABLE_CONTACTOS = "CREATE TABLE " +
            Constantes.CONTACTOS_TABLA + " (" +
            Constantes.CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Constantes.CAMPO_NOMBRE + " TEXT NOT NULL, " +
            Constantes.CAMPO_EMAIL + " TEXT NOT NULL, " +
            Constantes.CAMPO_EDAD + " INTEGER NOT NULL)";

    private static final String DELETE_TABLE_CONTACTOS = "DROP TABLE IF EXIST " + Constantes.CONTACTOS_TABLA;


    //TODO: Constructos de nuestra clase para crear una referenecia a nuestra base de datos
    public DatabaseHelper (Context context) {
        super (context, Constantes.DATABASE_NAME, null, Constantes.DATABASE_VERSION);

    }


    //TODO: El método onCreate se llama al crear la base de datso

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Invocamos al método createTables
        createTables(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Eliminamos la tabla y la volvemos a crear
        deleteTables (db);
        createTables(db);

    }

    //TODO: Usamos un método para crear nuestra tabla
    //Con el parametro db "SQLiteDatabase" ejecutamos el instructor de SQL para crear nuestra tabla
    private void createTables(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_CONTACTOS);
    }

    private void deleteTables(SQLiteDatabase db) {

        db.execSQL(DELETE_TABLE_CONTACTOS);
    }


}
