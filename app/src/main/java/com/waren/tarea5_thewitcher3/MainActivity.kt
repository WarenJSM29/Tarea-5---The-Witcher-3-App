package com.waren.tarea5_thewitcher3  // Reemplaza esto con tu paquete real

import PortadaFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargar la portada por defecto
        loadFragment(PortadaFragment(), "Portada")

        // Configurar navegación inferior
        val nav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        nav.setOnItemSelectedListener {
            val (fragment, title) = when (it.itemId) {
                R.id.nav_home -> PortadaFragment() to "Portada"
                R.id.nav_personajes -> PersonajesFragment() to "Personajes"
                R.id.nav_momentos -> MomentosFragment() to "Momentos"
                R.id.nav_acerca -> AcercaDeFragment() to "Acerca de"
                R.id.nav_en_mi_vida -> EnMiVidaFragment() to "En mi vida"
                // Los otros botones los dejas igual
                else -> PortadaFragment() to "Portada"
            }

            loadFragment(fragment, title)
            true
        }
    }

    // Función para cargar fragmentos
    private fun loadFragment(fragment: Fragment, title: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
        supportActionBar?.title = title
    }

    // Menú de tres puntos
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        return true
    }

    // Manejo de selección del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_contratame -> {
                loadFragment(ContratameFragment(), "Contrátame")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
