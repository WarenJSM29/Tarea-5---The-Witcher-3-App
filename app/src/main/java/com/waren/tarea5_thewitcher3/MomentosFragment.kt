package com.waren.tarea5_thewitcher3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


class MomentosFragment : Fragment() {

    private val momentos = listOf(
        Momento(
            "Geralt se reencuentra con Ciri",
            R.drawable.momento1,
            "https://www.youtube.com/embed/6KpXbdgtns8",
            "Uno de los momentos más emotivos del juego base. Geralt encuentra a Ciri después de mucho tiempo buscándola, y su reacción depende de tus decisiones durante la historia."
        ),
        Momento(
            "Geralt vs Dettlaff",
            R.drawable.momento2,
            "https://www.youtube.com/embed/S-Td_aETp4I",
            "Una épica batalla contra el vampiro superior Dettlaff en el DLC 'Blood and Wine'. Una pelea visualmente espectacular y cargada de tensión narrativa."
        ),
        Momento(
            "Geralt conversa con Gaunter O'Dimm",
            R.drawable.momento3,
            "https://www.youtube.com/embed/Tb3aoah1mt0",
            "El clímax del DLC 'Hearts of Stone'. Una charla llena de filosofía y misterio con uno de los personajes más inquietantes y poderosos del universo Witcher. Este personaje seria el equivalente al Diablo en esta obra."
        )
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_momentos, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_momentos)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = MomentoAdapter(momentos) { momento ->
            val fragment = DetalleMomentoFragment.newInstance(momento)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}