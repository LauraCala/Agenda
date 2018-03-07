package local.com.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Array de contactos
    ArrayList<Contacto> miagenda;

    Button btnAñadir;
    Button btnBuscar;
    Button btnVerTodos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miagenda=new ArrayList<>();

        btnAñadir = findViewById(R.id.añadir);
        btnAñadir.setOnClickListener(this);
        btnBuscar = findViewById(R.id.buscar);
        btnBuscar.setOnClickListener(this);
        btnVerTodos = findViewById(R.id.verTodos);
        btnVerTodos.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.añadir:
                //Intent intent=new Intent(this,Anadir_Activity.class);
                //intent.putExtra("miagenda", miagenda);
                //this.startActivityForResult(intent,1);
                abrirParaInsertarEnDB();
                break;

            case R.id.buscar:
                Intent intent1=new Intent(this,Buscar_Activity.class);
                intent1.putExtra("miagenda", miagenda);
                this.startActivity(intent1);
                break;

            case R.id.verTodos:
                Intent intent2 = new Intent(this,VerTodos_Activity.class);
                intent2.putExtra("miagenda", miagenda);
                this.startActivity(intent2);
                break;

        }
    }

    //Abre la actividad AñadirActivity para poder insertar un registro de manera directa en la BD
    public void abrirParaInsertarEnDB(){
        Intent intent = new Intent(this, Anadir_Activity.class);
        startActivity(intent);
    }



    /*Esta actividad recibe datos de otras actividades.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Convertimos el array serializable a un arraylist.
        miagenda = (ArrayList<Contacto>)data.getSerializableExtra("miagenda");
    }
    */


}
