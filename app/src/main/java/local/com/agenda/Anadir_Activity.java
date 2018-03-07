package local.com.agenda;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

import local.com.agenda.model.UtilsContactos;
import local.com.agenda.utils.Utilidades;

public class Anadir_Activity extends AppCompatActivity{


    ArrayList<Contacto> miagenda;
    Button btnAdd;

    String nombre;
    String email;
    String edad;

    EditText editTextNombre;
    EditText editTextEmail;
    EditText editTextEdad;

    Utilidades u = new Utilidades();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anadir_layout);
        //Intent intent = this.getIntent();

        //miagenda=(ArrayList<Contacto>)intent.getSerializableExtra("miagenda");

        editTextNombre = this.findViewById(R.id.editTextNombre);
        editTextEmail = this.findViewById(R.id.editTextEmail);
        editTextEdad = this.findViewById(R.id.editTextEdad);

        btnAdd = findViewById(R.id.btnguardar);



    }


    /*public void guardar (View view){


        Boolean auxnulo;
        auxnulo = nombre.equals(null);

        Contacto contacto = new Contacto (nombre, email, edad);

        if (auxnulo == true){
            AlertDialog.Builder cuadro=new AlertDialog.Builder(this);
            cuadro.setMessage("Escriba el nombre");
            this.finish();
        } else {
            miagenda.add(contacto);
        }


        Intent intent=new Intent();
        intent.putExtra("miagenda", miagenda);
        this.setResult(0, intent);

        //cerramos la actividad
        this.finish();
    }*/

    public void anadirContactoADB (View view){

        //Resources rs = getResources();
        nombre = editTextNombre.getText().toString();
        email = editTextEmail.getText().toString();
        edad = editTextEdad.getText().toString();

        if(TextUtils.isEmpty(editTextNombre.getText()) ||
                TextUtils.isEmpty(editTextEmail.getText()) ||
                TextUtils.isEmpty(editTextEdad.getText())){

                 //Mostrar mensaje de error "campos vacios"

            u.mostrarMensaje(this, R.string.campos_vacios);

        } else {


            nombre = editTextNombre.getText().toString();
            email = editTextEmail.getText().toString();
            int edad = Integer.parseInt(editTextEdad.getText().toString());

            Contacto c=new Contacto(nombre, email, edad);

            //creamos un UtilsContactos y añadimos
            //el nuevo contacto
            UtilsContactos gestion=new UtilsContactos(this);

            gestion.guardarContacto(c);
            //cerramos la base de datos
            gestion.close();
            //finalizamos la actividad
            this.finish();

        }

    }

    private void cerrarActivity(){
        //Cerramos la actividad

        this.finish();
    }

}
