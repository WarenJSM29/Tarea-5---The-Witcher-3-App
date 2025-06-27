package com.waren.tarea5_thewitcher3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MomentoAdapter(
    private val momentos: List<Momento>,
    private val onClick: (Momento) -> Unit
) : RecyclerView.Adapter<MomentoAdapter.MomentoViewHolder>() {

    class MomentoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagen: ImageView = view.findViewById(R.id.img_momento)
        val titulo: TextView = view.findViewById(R.id.txt_titulo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_momento, parent, false)
        return MomentoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MomentoViewHolder, position: Int) {
        val momento = momentos[position]
        holder.imagen.setImageResource(momento.imagenResId)
        holder.titulo.text = momento.titulo
        holder.itemView.setOnClickListener { onClick(momento) }
    }

    override fun getItemCount(): Int = momentos.size
}
