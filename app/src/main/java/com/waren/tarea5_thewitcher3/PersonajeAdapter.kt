package com.waren.tarea5_thewitcher3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonajeAdapter(
    private val lista: List<Personaje>,
    private val onClick: (Personaje) -> Unit
) : RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder>() {

    class PersonajeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre = view.findViewById<TextView>(R.id.txt_nombre)
        val imagen = view.findViewById<ImageView>(R.id.img_personaje)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_personaje, parent, false)
        return PersonajeViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        val personaje = lista[position]
        holder.nombre.text = personaje.nombre
        holder.imagen.setImageResource(personaje.imagenResId)

        holder.itemView.setOnClickListener {
            onClick(personaje)
        }
    }

    override fun getItemCount() = lista.size
}
