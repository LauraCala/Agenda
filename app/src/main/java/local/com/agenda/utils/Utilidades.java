package local.com.agenda.utils;

import android.content.Context;
import android.widget.Toast;


public class Utilidades {

    /**
     * //Muestra un toast con un mensaje para el usuario
     * @param context (Representa el contexto donde va a mostrar el mensaje)
     * @param mensaje (mensaje del usuario)
     */

    public void mostrarMensaje(Context context, int mensaje){

        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();

    }

}
