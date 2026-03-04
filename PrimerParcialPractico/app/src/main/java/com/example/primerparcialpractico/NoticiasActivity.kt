package com.example.primerparcialpractico

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primerparcialpractico.databinding.ActivityNoticiasBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NoticiasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoticiasBinding
    private val listaNoticias = mutableListOf<Noticia>()
    private lateinit var adapter: NoticiasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticiasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupListeners()
        cargarNoticiasEjemplo()
    }

    private fun setupRecyclerView() {
        adapter = NoticiasAdapter(listaNoticias)
        binding.rvNoticias.layoutManager = LinearLayoutManager(this)
        binding.rvNoticias.adapter = adapter
    }

    private fun setupListeners() {
        binding.btnPublicar.setOnClickListener {
            val titulo = binding.etTitulo.text.toString()
            val contenido = binding.etContenido.text.toString()

            if (titulo.isNotEmpty() && contenido.isNotEmpty()) {
                val fechaActual = SimpleDateFormat("dd 'de' MMMM, yyyy", Locale("es", "ES")).format(Date())
                val nuevaNoticia = Noticia(titulo, contenido, fechaActual)
                
                listaNoticias.add(0, nuevaNoticia)
                adapter.notifyItemInserted(0)
                binding.rvNoticias.scrollToPosition(0)

                binding.etTitulo.text.clear()
                binding.etContenido.text.clear()
            }
        }
    }

    private fun cargarNoticiasEjemplo() {
        listaNoticias.add(Noticia("Reunión de Seguridad", "Mañana a las 6:00 PM en el salón comunal.", "15 de Octubre, 2023"))
        listaNoticias.add(Noticia("Corte de Agua", "Se suspenderá el servicio por mantenimiento de 8 AM a 4 PM.", "14 de Octubre, 2023"))
        listaNoticias.add(Noticia("Jornada de Limpieza", "Trae tus herramientas para limpiar el parque principal.", "12 de Octubre, 2023"))
        adapter.notifyDataSetChanged()
    }
}