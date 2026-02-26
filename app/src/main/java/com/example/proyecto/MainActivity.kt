package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnSuma).setOnClickListener {
            startActivity(Intent(this, SumaActivity::class.java))
        }

        findViewById<Button>(R.id.btnTienda).setOnClickListener {
            startActivity(Intent(this, TiendaActivity::class.java))
        }

        findViewById<Button>(R.id.btnTemperatura).setOnClickListener {
            startActivity(Intent(this, TemperaturaActivity::class.java))
        }

        findViewById<Button>(R.id.btnVacuna).setOnClickListener {
            startActivity(Intent(this, VacunaActivity::class.java))
        }
    }
}
