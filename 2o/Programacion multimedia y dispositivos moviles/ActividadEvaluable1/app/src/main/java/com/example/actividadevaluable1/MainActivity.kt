package com.example.actividadevaluable1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvIdent = findViewById<TextView>(R.id.tvIdent)
        val btnCallActivity = findViewById<ImageButton>(R.id.btnCallActivity)
        val btnUrl = findViewById<ImageButton>(R.id.btnUrl)
        val btnAlarm = findViewById<ImageButton>(R.id.btnAlarm)
        val btnEmail = findViewById<ImageButton>(R.id.btnEmail)
        val btnConfig = findViewById<Button>(R.id.btnConfig)

        // Recuperar SharedPreferences
        val prefs = getSharedPreferences("app_config", MODE_PRIVATE)

        // Obtener datos del Intent o SharedPreferences
        val nombre = intent.getStringExtra("usuario_nombre") ?: prefs.getString("nombre", "Usuario")
        val telefono = intent.getStringExtra("usuario_telefono") ?: prefs.getString("telefono", "N/A")

        // Mostrar en el TextView
        tvIdent.text = "Bienvenido, $nombre\nTeléfono: $telefono"

        // --- BOTÓN LLAMADA ---
        btnCallActivity.setOnClickListener {
            // Llamada con número dinámico
            val callIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$telefono")
            }
            startActivity(callIntent)
        }

        // --- BOTÓN WEB ---
        btnUrl.setOnClickListener {
            val url = "https://www.iesvirgendelcarmen.com/"
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(webIntent)
        }

        // --- BOTÓN CORREO ---
        btnEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("srodher115@g.educaand.es"))
                putExtra(Intent.EXTRA_SUBJECT, "Entrega Actividad Evaluable 1")
                putExtra(Intent.EXTRA_TEXT, "Hola Santi, soy $nombre y envío mi práctica.")
            }
            startActivity(emailIntent)
        }

        // --- BOTÓN CONFIGURACIÓN ---
        btnConfig.setOnClickListener {
            val intentConfig = Intent(this, ConfigActivity::class.java)
            startActivity(intentConfig)
            finish() // opcional: cerrar MainActivity para que se recargue al volver
        }

        // --- BOTÓN ALARMA ---
        btnAlarm.setOnClickListener {
            val alarmIntent = Intent(this, AlarmActivity::class.java)
            startActivity(alarmIntent)
        }

    }
}
