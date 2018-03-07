package local.com.agenda.model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import local.com.agenda.Contacto;
import local.com.agenda.constantes.Constantes;

public class UtilsContactos {

    //Atributos
    private SQLiteDatabase db = null;
    private DatabaseHelper dbhelper = null;

    //Contexto
    Context context;

    //Todo: Constructor ed nuestra clase para instanciar la clase Database Contactos y para usar
    //los métodos para escribir en nuestra base de datos
    public UtilsContactos(Context contexto){
        this.context=contexto;
        //crea una instancia del helper
        dbhelper=new DatabaseHelper(context);
        //crea un objeto SQLiteDatabase para operar
        //contra la base de datos
        db=dbhelper.getWritableDatabase();
    }

    //Todo: cerramos la base
    public void close(){
        dbhelper.close();
    }

    public long guardarContacto(Contacto c){
        ContentValues initialValues=new ContentValues();
        initialValues.put("nombre", c.getNombre());
        initialValues.put("email", c.getEmail());
        initialValues.put("edad", c.getEdad());
        return db.insert(Constantes.CONTACTOS_TABLA, null, initialValues);
    }

    public Cursor recuperarContactos(){
        return db.query(Constantes.CONTACTOS_TABLA, new String[]{
                Constantes.CAMPO_ID, Constantes.CAMPO_NOMBRE, Constantes.CAMPO_EMAIL, Constantes.CAMPO_EDAD},
                null, null, null, null, null);

    }
    public Contacto buscarPorEmail(String email){
        Contacto con=null;
        Cursor c=db.query(Constantes.CONTACTOS_TABLA, new String[]{Constantes.CAMPO_ID,
                Constantes.CAMPO_NOMBRE, Constantes.CAMPO_EMAIL, Constantes.CAMPO_EDAD},
                "email=?", new String[]{email}, null,null,null);
        if(c.moveToNext()){
            con=new Contacto(c.getString(1),c.getString(2),c.getInt(3));
        }
        return con;
    }

}








