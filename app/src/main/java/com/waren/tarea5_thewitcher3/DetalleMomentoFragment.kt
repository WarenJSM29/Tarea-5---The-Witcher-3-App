package com.waren.tarea5_thewitcher3

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.TextView

class DetalleMomentoFragment : Fragment() {

    companion object {
        private const val ARG_TITULO = "titulo"
        private const val ARG_URL = "url"

        fun newInstance(momento: Momento): DetalleMomentoFragment {
            val fragment = DetalleMomentoFragment()
            val bundle = Bundle().apply {
                putString(ARG_TITULO, momento.titulo)
                putString(ARG_URL, momento.videoUrl)
                putString("descripcion", momento.descripcion)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detalle_momento, container, false)

        val titulo = arguments?.getString("titulo")
        val videoUrl = arguments?.getString("url")

        view.findViewById<TextView>(R.id.txt_momento_titulo).text = titulo
        val webView = view.findViewById<WebView>(R.id.video_webview)

        val descripcion = arguments?.getString("descripcion")
        view.findViewById<TextView>(R.id.txt_momento_descripcion).text = descripcion

        // Configurar correctamente el WebView
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.mediaPlaybackRequiresUserGesture = false

        // HTML con iframe correctamente formateado
        val html = """
        <html>
        <body style="margin:0;padding:0;">
        <iframe 
            width="100%" height="100%" 
            src="$videoUrl" 
            title="YouTube video player" 
            frameborder="0" 
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
            allowfullscreen>
        </iframe>
        </body>
        </html>
    """.trimIndent()

        webView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null)

        return view
    }
}