package local.com.agenda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

import local.com.agenda.model.UtilsContactos;

/*
public class Buscar_Activity extends AppCompatActivity {
    ArrayList<Contacto> miagenda;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscar_layout);
        Intent intent1 = getIntent();
        miagenda=(ArrayList<Contacto>)intent1.getSerializableExtra("miagenda");

    }

    public void buscar (View view){
        String email = ((EditText)this.findViewById(R.id.EmailEditText)).getText().toString();
        Contacto contacto = null;
        for (Contacto contact: miagenda){
            if (contact.getEmail().equals(email)){
                contacto = contact;
                break;
            }
        }
        mostrar(contacto);
    }

    private void mostrar(Contacto contacto){
        if(contacto==null){
            AlertDialog.Builder cuadro=new AlertDialog.Builder(this);
            cuadro.setMessage("No se ha encontrado el contacto, ¿Desea realizar otra búsqueda?");

            //en caso de que diga que no, salimos de la actividad
            cuadro.setNegativeButton(android.R.string.no,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Buscar_Activity.this.finish();
                        }
                    });
            //no se define ningún escuchador para el botón de afirmación
            cuadro.setPositiveButton(android.R.string.yes,null);
            cuadro.show();

            } else{
            String datos="Nombre: "+contacto.getNombre() + "\n Email: " + contacto.getEmail()
                    + "\n Edad: "+contacto.getEdad();
            Toast.makeText(this,datos,Toast.LENGTH_LONG).show();

            }
        }

    public void salir (View view){

        this.finish();
    }
}
*/

public class Buscar_Activity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscar_layout);

    }


    public void buscar(View v){
        String email=((EditText)this.findViewById(R.id.buttonBuscar)).getText().toString();

        //guardamos aquí el contacto recuperado
        Contacto c = null;

        //creamos GestionContacto y buscamos
        UtilsContactos gestion=new UtilsContactos(this);
        c = gestion.buscarPorEmail(email);
        mostrarDato(c);

        //cerramos la base de datos
        gestion.close();
    }
    public void salir(View v){

        this.finish();
    }

    private void mostrarDato(Contacto c){
        if(c==null){
            AlertDialog.Builder cuadro=new AlertDialog.Builder(this);
            cuadro.setMessage("No se ha encontrado el contacto, ¿Desea realizar otra búsqueda?");
            cuadro.setNegativeButton(android.R.string.no,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Abandona la actividad
                            Buscar_Activity.this.finish();
                        }
                    });
            //no se define ningún escuchador para el botón de afirmación
            cuadro.setPositiveButton(android.R.string.yes,null);
            cuadro.show();

        }
        else{
            String datos = "Nombre: " + c.getNombre() + "\n Email:" + c.getEmail() + "\n Edad:" +
                    c.getEdad();
            Toast.makeText(this,datos,Toast.LENGTH_LONG).show();

        }
    }

}
