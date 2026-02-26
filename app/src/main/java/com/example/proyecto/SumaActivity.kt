package com.example.proyecto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Definición de la clase SumaActivity que hereda de AppCompatActivity (clase base para actividades modernas)
class SumaActivity : AppCompatActivity() {
    // Método que se ejecuta al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el diseño de la interfaz de usuario definido en activity_suma.xml
        setContentView(R.layout.activity_suma)

        // Referenciamos los componentes del XML por su ID
        val etNum1 = findViewById<EditText>(R.id.etNum1) // Cuadro de texto para el primer número
        val etNum2 = findViewById<EditText>(R.id.etNum2) // Cuadro de texto para el segundo número
        val btnCalcular = findViewById<Button>(R.id.btnCalcularSuma) // Botón para ejecutar la suma
        val tvResultado = findViewById<TextView>(R.id.tvResultadoSuma) // Etiqueta donde se mostrará el resultado

        // Configuramos la acción al hacer clic en el botón
        btnCalcular.setOnClickListener {
            // Obtenemos el texto, lo convertimos a String y luego a Double. Si no es un número válido, usamos 0.0
            val n1 = etNum1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = etNum2.text.toString().toDoubleOrNull() ?: 0.0
            
            // Realizamos la operación aritmética
            val suma = n1 + n2
            
            // Mostramos el resultado en el TextView concatenando el texto "Resultado: " con el valor de la suma
            tvResultado.text = "Resultado: $suma"
        }
    }
}
