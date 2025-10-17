/**
 * MainActivity: Clase principal de la aplicación que gestiona
 * tres botones y muestra mensajes en un TextView según el botón pulsado.
 *
 * Botones:
 *  - btnSaludar: muestra "¡Hola!"
 *  - btnNoSaludar: muestra "No quiero saludar..."
 *  - btnSaludarClase: muestra "¡Hola clase!"
 *
 * @author Sergio Trillo Rodriguez
 */
package com.example.actividad7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    /**
     * TextView donde se mostrará el resultado según el botón pulsado.
     */
    private lateinit var txtResultado: TextView

    /**
     * Método llamado al crear la actividad.
     * Inicializa la vista y referencia el TextView.
     *
     * @param savedInstanceState Bundle con el estado previo de la actividad (si lo hubiera)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia al TextView del layout
        txtResultado = findViewById(R.id.txtResultado)
    }

    /**
     * Método llamado desde el XML mediante android:onClick.
     * Determina qué botón ha sido pulsado y actualiza el TextView.
     *
     * @param view El botón que ha sido pulsado.
     */
    fun capturarEvento(view: View) {
        when(view.id){
            R.id.btnSaludar -> txtResultado.text = "¡Hola!"
            R.id.btnNoSaludar -> txtResultado.text = "No quiero saludar..."
            R.id.btnSaludarClase -> txtResultado.text = "¡Hola clase!"
        }
    }
}
