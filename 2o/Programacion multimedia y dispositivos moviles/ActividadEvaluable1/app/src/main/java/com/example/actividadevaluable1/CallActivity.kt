package com.example.actividadevaluable1

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class CallActivity : AppCompatActivity() {
    private val REQ_CALL = 100
    private var telefonoUri: String = ""

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        prefs = getSharedPreferences("app_config", MODE_PRIVATE)

        val tv = findViewById<TextView>(R.id.tvCallTitle)
        val btnCall = findViewById<ImageButton>(R.id.btnDoCall)

        // Primero intentar obtener teléfono del Intent
        val telefonoIntent = intent.getStringExtra("usuario_telefono")
        telefonoUri = if (!telefonoIntent.isNullOrEmpty()) {
            "tel:$telefonoIntent"
        } else {
            // Si no hay en Intent, usar SharedPreferences
            val telefonoGuardado = prefs.getString("telefono", "")
            if (!telefonoGuardado.isNullOrEmpty()) {
                "tel:$telefonoGuardado"
            } else {
                // Número por defecto
                "tel:+34123456789"
            }
        }

        // Actualizar TextView con número
        tv.text = "Llamar a: ${telefonoUri.removePrefix("tel:")}"

        btnCall.setOnClickListener {
            hacerLlamada()
        }
    }

    private fun hacerLlamada() {
        val callIntent = Intent(Intent.ACTION_CALL, Uri.parse(telefonoUri))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    REQ_CALL
                )
                return
            }
        }

        startActivity(callIntent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQ_CALL) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivity(Intent(Intent.ACTION_CALL, Uri.parse(telefonoUri)))
            } else {
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(telefonoUri)))
            }
        }
    }
}
