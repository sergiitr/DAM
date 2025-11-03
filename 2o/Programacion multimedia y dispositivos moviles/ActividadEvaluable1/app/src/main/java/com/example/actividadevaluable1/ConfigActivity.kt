/**
 * @author Sergio Trillo Rodriguez
 */
package com.example.actividadevaluable1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

/**
 * ConfigActivity
 * Permite al usuario ingresar y guardar su nombre y teléfono.
 * Funcionalidades:
 * - Muestra los datos guardados previamente en SharedPreferences.
 * - Valida los datos:
 *      - Nombre no vacío.
 *      - Teléfono solo números y 9 dígitos.
 * - Guarda los datos en SharedPreferences.
 * - Redirige a MainActivity enviando los datos actualizados.
 */

class ConfigActivity : AppCompatActivity() {
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        prefs = getSharedPreferences("app_config", MODE_PRIVATE)
        val etNombre = findViewById<EditText>(R.id.etName)
        val etTlfn = findViewById<EditText>(R.id.etPhone)
        val botonGuardar = findViewById<Button>(R.id.btnSave)

        etNombre.setText(prefs.getString("nombre", ""))
        etTlfn.setText(prefs.getString("telefono", ""))

        botonGuardar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val tlfn = etTlfn.text.toString().trim()

            if (nombre.isEmpty()) {
                etNombre.error = "Por favor, ingresa tu nombre"
                etNombre.requestFocus()
                return@setOnClickListener
            }

            if (tlfn.isEmpty()) {
                etTlfn.error = "Por favor, ingresa tu teléfono"
                etTlfn.requestFocus()
                return@setOnClickListener
            }

            if (!tlfn.matches(Regex("\\d+"))) {
                etTlfn.error = "El teléfono solo debe contener números"
                etTlfn.requestFocus()
                return@setOnClickListener
            }

            if (tlfn.length != 9) {
                etTlfn.error = "El teléfono debe tener 9 dígitos"
                etTlfn.requestFocus()
                return@setOnClickListener
            }

            prefs.edit().putString("nombre", nombre).putString("telefono", tlfn).apply()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("usuario_nombre", nombre)
            intent.putExtra("usuario_telefono", tlfn)
            startActivity(intent)
            finish()
        }
    }
}
