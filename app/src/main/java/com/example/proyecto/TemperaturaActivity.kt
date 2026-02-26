package com.example.proyecto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Actividad para convertir temperaturas de Fahrenheit a Celsius
class TemperaturaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflamos el diseño XML de temperatura
        setContentView(R.layout.activity_temperatura)

        // Vinculamos los objetos Kotlin con los elementos visuales del XML
        val etFahrenheit = findViewById<EditText>(R.id.etFahrenheit) // Entrada para grados F
        val btnConvertir = findViewById<Button>(R.id.btnConvertir) // Botón para iniciar conversión
        val tvResultado = findViewById<TextView>(R.id.tvResultadoTemp) // Donde mostraremos el resultado en C

        // Acción al pulsar el botón
        btnConvertir.setOnClickListener {
            // Obtenemos el valor ingresado. Si el campo está vacío, usamos 0.0
            val f = etFahrenheit.text.toString().toDoubleOrNull() ?: 0.0
            
            // Aplicamos la fórmula matemática solicitada: C = ((F-32)*5)/9
            val c = ((f - 32) * 5) / 9
            
            // Formateamos el resultado a 2 decimales para que no se vea una cadena larga de números
            val resultadoFormatted = String.format("%.2f", c)
            
            // Publicamos el resultado en la pantalla
            tvResultado.text = "Resultado: $resultadoFormatted °C"
        }
    }
}
