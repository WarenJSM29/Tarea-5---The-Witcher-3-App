package com.waren.tarea5_thewitcher3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetallePersonajeFragment : Fragment() {

    companion object {
        private const val ARG_NOMBRE = "nombre"
        private const val ARG_IMAGEN = "imagen"
        private const val ARG_DESC = "descripcion"

        fun newInstance(personaje: Personaje): DetallePersonajeFragment {
            val fragment = DetallePersonajeFragment()
            val bundle = Bundle().apply {
                putString(ARG_NOMBRE, personaje.nombre)
                putInt(ARG_IMAGEN, personaje.imagenResId)
                putString(ARG_DESC, personaje.descripcion)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detalle_personaje, container, false)

        val nombre = arguments?.getString(ARG_NOMBRE)
        val imagenRes = arguments?.getInt(ARG_IMAGEN)
        val descripcion = arguments?.getString(ARG_DESC)

        view.findViewById<TextView>(R.id.txt_nombre_detalle).text = nombre
        view.findViewById<TextView>(R.id.txt_descripcion_detalle).text = descripcion
        view.findViewById<ImageView>(R.id.img_detalle_personaje).setImageResource(imagenRes ?: R.drawable.geralt1)

        return view
    }
}