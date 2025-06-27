package com.waren.tarea5_thewitcher3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


class PersonajesFragment : Fragment() {

    private val personajes = listOf(
        Personaje("Eredin", R.drawable.eredin1, "Líder de la Cacería Salvaje, un elfo Aen Elle que busca capturar a Ciri."),
        Personaje("Triss Merigold", R.drawable.triss1, "Hechicera y aliada de Geralt, experta en magia curativa y fuego."),
        Personaje("Sigismund Dijkstra", R.drawable.dijkstra1, "Exespía real, astuto y manipulador; dirige la inteligencia de Redania."),
        Personaje("Vesemir", R.drawable.vesemir1, "El brujo más veterano de Kaer Morhen, figura paterna para Geralt."),
        Personaje("Lambert", R.drawable.lambert1, "Brujo joven y sarcástico de Kaer Morhen, amigo de Geralt."),
        Personaje("Eskel", R.drawable.eskel1, "Brujo leal y tranquilo, hermano de entrenamiento de Geralt."),
        Personaje("Letho de Guleta", R.drawable.letho1, "Brujo de la Escuela de la Víbora, involucrado en asesinatos de reyes."),
        Personaje("Dettlaff van der Eretein", R.drawable.dettlaff1, "Vampiro superior con conflictos humanos, antagonista de Blood and Wine."),
        Personaje("Anna Henrietta", R.drawable.anna_henrietta1, "Duquesa de Toussaint, noble impulsiva pero justa."),
        Personaje("Gaunter O'Dimm", R.drawable.gaunter1, "Entidad demoníaca que manipula deseos y almas. El 'Maestro Espejos'."),
        Personaje("Olgierd von Everec", R.drawable.olgierd1, "Noble maldito por su pacto con Gaunter, trágico y atormentado."),
        Personaje("Radovid V", R.drawable.radovid1, "Rey fanático de Redania, obsesionado con exterminar a los magos."),
        Personaje("Philippa Eilhart", R.drawable.philippa1, "Hechicera ambiciosa y poderosa, lidera la Logia de las Hechiceras."),
        Personaje("Keira Metz", R.drawable.keira1, "Hechicera pragmática que busca sobrevivir tras la caída de la Logia."),
        Personaje("Roche", R.drawable.roche1, "Soldado temeriano leal, amigo de Geralt, enemigo de Redania."),
        Personaje("Barón Sanguinario", R.drawable.baron1, "Señor de Velen, marcado por sus decisiones y su pasado familiar."),
        Personaje("Avallac'h", R.drawable.avallach1, "Elfo sabio del mundo Aen Elle, mentor de Ciri en su entrenamiento dimensional."),
        Personaje("Yennefer", R.drawable.yennefer1, "Hechicera poderosa y amor eterno de Geralt, madre adoptiva de Ciri."),
        Personaje("Emhyr var Emreis", R.drawable.emhyr1, "Emperador de Nilfgaard y padre biológico de Ciri. Su contrato con Geralt inicia la historia del juego."),
        Personaje("Ciri", R.drawable.ciri1, "Hija adoptiva de Geralt, con poderes ancestrales que le permiten viajar entre mundos."),
        Personaje("Geralt de Rivia", R.drawable.geralt1, "Brujo cazador de monstruos, protagonista de la saga y símbolo de moral gris."),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personajes, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_personajes)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = PersonajeAdapter(personajes) { personaje ->
            val fragment = DetallePersonajeFragment.newInstance(personaje)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
