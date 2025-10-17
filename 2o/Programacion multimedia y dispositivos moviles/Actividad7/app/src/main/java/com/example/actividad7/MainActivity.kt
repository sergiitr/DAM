/**
 * @author Sergio Trillo Rodriguez
 * @description:
 *  Trabajaremos con los eventos de los botones. Implementaremos un ejemplo, con tres botones.
 *      - saludar
 *      - no saludar
 *      - saludar a clase
 *
 */
package com.example.actividad7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtResultado = findViewById(R.id.txtResultado)
    }

    // Método llamado desde el XML
    fun capturarEvento(view: View) {
        when(view.id){
            R.id.btnSaludar -> txtResultado.text = "¡Hola!"
            R.id.btnNoSaludar -> txtResultado.text = "No quiero saludar..."
            R.id.btnSaludarClase -> txtResultado.text = "¡Hola clase!"
        }
    }
}
