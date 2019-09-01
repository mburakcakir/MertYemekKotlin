package com.mburcak.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.mburcak.R

class MenuFragment : Fragment() {
    internal lateinit var webview: WebView
    internal lateinit var menuView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        menuView = inflater.inflate(R.layout.fragment_menu, container, false)

        menuWebViewSet()

        return menuView
    }

    fun menuWebViewSet() {
        // initialize
        webview = menuView.findViewById(R.id.menuVW) as WebView

        // Enable Javascript
        webview.settings.javaScriptEnabled = true

        // Force links and redirects to open in the WebView instead of in a browser
        webview.webViewClient = WebViewClient()
        webview.clearCache(true)
        webview.settings.domStorageEnabled = true
        webview.loadUrl("https://mertyemek.net/gunluk-menuler-2-3-2/")

    }


}
