package com.example.actividadevaluable1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConfigActivity : AppCompatActivity() {
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        prefs = getSharedPreferences("app_config", MODE_PRIVATE)
        val etName = findViewById<EditText>(R.id.etName)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val btnSave = findViewById<Button>(R.id.btnSave)

        // Mostrar datos guardados si existen
        etName.setText(prefs.getString("nombre", ""))
        etPhone.setText(prefs.getString("telefono", ""))

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val phone = etPhone.text.toString().trim()

            // Validaciones
            if (name.isEmpty()) {
                etName.error = "Por favor, ingresa tu nombre"
                etName.requestFocus()
                return@setOnClickListener
            }

            if (phone.isEmpty()) {
                etPhone.error = "Por favor, ingresa tu teléfono"
                etPhone.requestFocus()
                return@setOnClickListener
            }

            // Verificar que solo tenga números
            if (!phone.matches(Regex("\\d+"))) {
                etPhone.error = "El teléfono solo debe contener números"
                etPhone.requestFocus()
                return@setOnClickListener
            }

            // Verificar que tenga 9 dígitos
            if (phone.length != 9) {
                etPhone.error = "El teléfono debe tener 9 dígitos"
                etPhone.requestFocus()
                return@setOnClickListener
            }

            // Guardar datos en SharedPreferences
            prefs.edit().putString("nombre", name).putString("telefono", phone).apply()

            // Pasar datos a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("usuario_nombre", name)
            intent.putExtra("usuario_telefono", phone)
            startActivity(intent)
            finish()
        }
    }
}
