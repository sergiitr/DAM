/**
 * @author Sergio Trillo Rodriguez
 */

package com.example.actividadevaluable1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvIdent = findViewById<TextView>(R.id.tvIdent)
        val btnCallActivity = findViewById<ImageButton>(R.id.btnCallActivity)
        val btnUrl = findViewById<ImageButton>(R.id.btnUrl)
        val btnAlarm = findViewById<ImageButton>(R.id.btnSetAlarm)
        val btnEmail = findViewById<ImageButton>(R.id.btnEmail)
        val btnConfig = findViewById<Button>(R.id.btnConfig)

        // Recuperar datos del usuario
        val prefs = getSharedPreferences("app_config", MODE_PRIVATE)
        val nombre = prefs.getString("nombre", "Usuario")
        val telefono = prefs.getString("telefono", "N/A")

        tvIdent.text = "Bienvenido, $nombre\nTeléfono: $telefono"

        // Botón de llamada
        btnCallActivity.setOnClickListener {
            val intent = Intent(this, CallActivity::class.java).apply {
                putExtra("usuario_telefono", telefono)
            }
            startActivity(intent)
        }

        // Botón web
        btnUrl.setOnClickListener {
            val url = "https://www.iesvirgendelcarmen.com/"
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(webIntent)
        }

        // Botón correo
        btnEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("srodher115@g.educaand.es"))
                putExtra(Intent.EXTRA_SUBJECT, "Entrega Actividad Evaluable 1")
                putExtra(Intent.EXTRA_TEXT, "Hola Santi, soy $nombre y envío mi práctica.")
            }
            startActivity(emailIntent)
        }

        //  Botón alarma
        btnAlarm.setOnClickListener {
            programarAlarma()
        }

        // Botón configuración
        btnConfig.setOnClickListener {
            val intentConfig = Intent(this, ConfigActivity::class.java)
            startActivity(intentConfig)
            finish()
        }
    }

    private fun programarAlarma() {
        Toast.makeText(this, "La alarma sonará en 15 segundos", Toast.LENGTH_SHORT).show()
        android.os.Handler(mainLooper).postDelayed({
            val intent = Intent(this, AlarmActivity::class.java)
            startActivity(intent)
        }, 15_000) // 15000 ms = 15 segundos, para 2 minutos poner 120000 ms
    }
}
