package com.waren.tarea5_thewitcher3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

class EnMiVidaFragment : Fragment() {

    private val videoUrl = "https://www.youtube.com/embed/hixFSyCIksQ?si=KMUMDXI-G8Xx9IcD"  // 🔴 Usa el link embed

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_en_mi_vida, container, false)

        val webView = view.findViewById<WebView>(R.id.video_testimonio)
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.loadData(
            "<iframe width=\"100%\" height=\"300\" src=\"$videoUrl\" frameborder=\"0\" allowfullscreen></iframe>",
            "text/html",
            "utf-8"
        )

        return view
    }
}