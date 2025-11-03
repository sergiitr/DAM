/**
 * @author Sergio Trillo Rodriguez
 */
package com.example.actividadevaluable1
import android.content.Context
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AlarmActivity : AppCompatActivity() {
    private var vibracion: Vibrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        val tvTime = findViewById<TextView>(R.id.tvTime)
        val botonApagarAlarma = findViewById<Button>(R.id.btnDismiss)

        val current = java.util.Calendar.getInstance()
        tvTime.text = "Hora: %02d:%02d".format(
            current.get(java.util.Calendar.HOUR_OF_DAY),
            current.get(java.util.Calendar.MINUTE)
        )

        vibracion = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibracion?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                it.vibrate(VibrationEffect.createWaveform(longArrayOf(0, 1000, 500, 1000), 0))
            } else {
                @Suppress("DEPRECATION")
                it.vibrate(longArrayOf(0, 1000, 500, 1000), 0)
            }
        }


        botonApagarAlarma.setOnClickListener {
            vibracion?.cancel()
            finish()
        }
    }

    override fun onDestroy() {
        vibracion?.cancel()
        super.onDestroy()
    }
}
