package local.com.agenda;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;


public class VerTodos_Activity extends AppCompatActivity {

    ArrayList<Contacto> miagenda;
    String datos = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vertodos_layout);
        Intent intent2 = getIntent();

        miagenda=(ArrayList<Contacto>)intent2.getSerializableExtra("miagenda");
        TextView eTLista= this.findViewById(R.id.editTextLista);


        for (Contacto contacto2: miagenda) {
            datos += "\n\nNombre: " + contacto2.getNombre() + " Email: " + contacto2.getEmail()
                    + " Edad: "+ contacto2.getEdad();
        }

        eTLista.setText(datos);

    }

    public void salir (View view){

        this.finish();
    }
}
