package com.example.primerparcialpractico

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoticiasAdapter(private val noticias: List<Noticia>) :
    RecyclerView.Adapter<NoticiasAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitulo: TextView = view.findViewById(R.id.tvTitulo)
        val tvFecha: TextView = view.findViewById(R.id.tvFecha)
        val tvDescripcion: TextView = view.findViewById(R.id.tvDescripcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_noticia, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val noticia = noticias[position]
        holder.tvTitulo.text = noticia.titulo
        holder.tvFecha.text = noticia.fecha
        holder.tvDescripcion.text = noticia.descripcion
    }

    override fun getItemCount() = noticias.size
}