/**
 * @author Sergio Trillo Rodriguez
 */

package com.example.actividadevaluable1

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/**
 * CallActivity
 * Permite realizar llamadas telefónicas a un número configurado por el usuario.
 * Funcionalidades:
 * - Obtiene el teléfono desde el Intent o SharedPreferences.
 * - Verifica permisos de llamada en tiempo de ejecución.
 * - Si se concede el permiso, realiza la llamada directa.
 * - Si no, abre el marcador con el número.
 */

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

        // Obtener teléfono desde Intent o SharedPreferences
        val telefonoIntent = intent.getStringExtra("usuario_telefono")
        telefonoUri = if (!telefonoIntent.isNullOrEmpty())
            "tel:$telefonoIntent"
        else {
            val telefonoGuardado = prefs.getString("telefono", "")
            if (!telefonoGuardado.isNullOrEmpty())
                "tel:$telefonoGuardado"
            else
                "tel:+34123456789"
        }

        tv.text = "Llamar a: ${telefonoUri.removePrefix("tel:")}"

        btnCall.setOnClickListener {
            hacerLlamada()
        }
    }

    /**
     * Intenta realizar una llamada telefónica al número configurado en [telefonoUri].
     *
     * Funcionalidad:
     * 1. Comprueba si el permiso CALL_PHONE ha sido concedido.
     *    - Si sí, inicia una llamada directa usando `Intent.ACTION_CALL`.
     *    - Si no, verifica si se debe mostrar una explicación al usuario mediante
     *      `shouldShowRequestPermissionRationale`. Si es necesario, muestra un Toast.
     * 2. Solicita el permiso CALL_PHONE al usuario en tiempo de ejecución.
     */
    private fun hacerLlamada() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse(telefonoUri)))
            return
        }

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE))
            Toast.makeText(this, "La app necesita permiso para realizar llamadas.", Toast.LENGTH_LONG).show()


        ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CALL_PHONE),REQ_CALL)
    }

    /**
     * Maneja la respuesta del usuario tras solicitar permisos en tiempo de ejecución.
     *
     * @param requestCode Código de solicitud enviado al solicitar el permiso.
     * @param permissions Array de permisos solicitados.
     * @param grantResults Array con los resultados de los permisos solicitados.
     *
     * Funcionalidad:
     * 1. Comprueba si el código de solicitud corresponde a [REQ_CALL].
     * 2. Si el permiso CALL_PHONE fue concedido:
     *    - Inicia una llamada directa al número [telefonoUri].
     * 3. Si el permiso fue denegado:
     *    - Muestra un Toast indicando que se abrirá el marcador.
     *    - Abre el marcador con `Intent.ACTION_DIAL` y el número [telefonoUri].
     */
    override fun onRequestPermissionsResult( requestCode: Int, permissions: Array<out String>, grantResults: IntArray ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQ_CALL) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                startActivity(Intent(Intent.ACTION_CALL, Uri.parse(telefonoUri)))
            else {
                Toast.makeText(this, "Permiso denegado. Se abrirá el marcador", Toast.LENGTH_SHORT).show()
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(telefonoUri)))
            }
        }
    }
}
