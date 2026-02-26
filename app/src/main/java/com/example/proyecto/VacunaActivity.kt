package com.example.proyecto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Actividad para calcular la dosis de una vacuna basándose en peso y edad
class VacunaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Cargamos el diseño XML de la vacuna
        setContentView(R.layout.activity_vacuna)

        // Obtenemos las referencias de los elementos visuales por su ID
        val etPeso = findViewById<EditText>(R.id.etPeso) // Campo para ingresar el peso
        val etEdad = findViewById<EditText>(R.id.etEdad) // Campo para ingresar la edad
        val btnCalcular = findViewById<Button>(R.id.btnCalcularDosis) // Botón de cálculo
        val tvResultado = findViewById<TextView>(R.id.tvResultadoVacuna) // Texto para mostrar la dosis

        // Programamos el evento del botón
        btnCalcular.setOnClickListener {
            // Extraemos los valores de texto y los convertimos a números (Double)
            val p = etPeso.text.toString().toDoubleOrNull() ?: 0.0
            val e = etEdad.text.toString().toDoubleOrNull() ?: 0.0
            
            // Fórmula solicitada: dosis = (peso + edad) / 2
            val d = (p + e) / 2
            
            // Mostramos el resultado final en el TextView
            tvResultado.text = "Cantidad de dosis necesarias: $d"
        }
    }
}
