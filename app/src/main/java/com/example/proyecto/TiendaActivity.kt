package com.example.proyecto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Clase para gestionar la venta de productos en una tienda
class TiendaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Carga el diseño XML de la tienda
        setContentView(R.layout.activity_tienda)

        // Referencia a los elementos de entrada de texto
        val etCantidad = findViewById<EditText>(R.id.etCantidad) // Ingreso de cuántos productos se venden
        val etPago = findViewById<EditText>(R.id.etPago) // Ingreso de cuánto dinero entrega el cliente
        
        // Referencia a los elementos de control y salida
        val btnCalcular = findViewById<Button>(R.id.btnCalcularTienda) // Botón para procesar la venta
        val tvTotal = findViewById<TextView>(R.id.tvTotal) // Muestra el costo total
        val tvCambio = findViewById<TextView>(R.id.tvCambio) // Muestra el cambio restante

        // Constante del precio unitario definido en el ejercicio
        val precioUnitario = 15000.0

        // Lógica al presionar el botón de calcular
        btnCalcular.setOnClickListener {
            // Conversión de datos de entrada a números decimales
            val cant = etCantidad.text.toString().toDoubleOrNull() ?: 0.0
            val pg = etPago.text.toString().toDoubleOrNull() ?: 0.0
            
            // Cálculo del total de la venta
            val total = cant * precioUnitario
            
            // Cálculo del cambio (dinero pagado menos el total de la venta)
            val cambio = pg - total

            // Actualización de la pantalla con el total calculado
            tvTotal.text = "Total: $$total"
            
            // Validación de si el pago fue suficiente
            if (cambio >= 0) {
                // Si el pago es mayor o igual al total, mostramos el cambio
                tvCambio.text = "Cambio: $$cambio"
            } else {
                // Si el dinero no alcanza, informamos al usuario
                tvCambio.text = "Cambio: Insuficiente"
            }
        }
    }
}
