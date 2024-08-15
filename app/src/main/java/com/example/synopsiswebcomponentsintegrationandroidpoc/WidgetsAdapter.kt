package com.example.synopsiswebcomponentsintegrationandroidpoc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WidgetsAdapter(
    private val sessions: List<com.example.synopsiswebcomponentsintegrationandroidpoc.Session>,
    private val context: Context
) :
    RecyclerView.Adapter<WidgetsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sessionTitle: TextView = itemView.findViewById(R.id.sessionTitle)
        val webWidget: WebView = itemView.findViewById(R.id.webWidget)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.widgets_adapter, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val session = sessions[position]
        holder.sessionTitle.text = session.title
        holder.webWidget.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    evaluateJavascript(
                        """
                            document.querySelector('#btnLive').addEventListener('click', function(event) {
                                Android.onButtonClicked(document.querySelector('#btnLive').getAttribute('data-redirect-url'));
                            });
                        """.trimIndent(), null
                    )


//                    val webView = view.findViewById<WebView>(R.id.webWidget)
//                    webView.settings.javaScriptEnabled = true
//                    webView.loadUrl("https://synopsis-web-components.vercel.app")
//
//                    webView.webViewClient = object : WebViewClient() {
//                        override fun onPageFinished(view: WebView?, url: String?) {
//                            super.onPageFinished(view, url)
//                            webView.evaluateJavascript(
//                                """
//                        console.log('started');
//                        console.log("document.querySelector('#btnLive')", document.querySelector('#btnLive'));
//
//                        document.querySelector('#btnLive').addEventListener('click', function(event) {
//                            console.log('event', event);
//
//                            var button = event.target;
//                            var redirectUrl = document.querySelector('#btnLive').getAttribute('data-redirect-url')
//
//                            console.log("document.querySelector('#btnLive').getAttribute('data-redirect-url')", document.querySelector('#btnLive').getAttribute('data-redirect-url'));
//                            Android.onButtonClicked(redirectUrl);
//                        });
//                    """
//                            ) { result ->
//                                print(result)
//                            }
//                        }
//                    }
//
//                    webView.loadUrl("https://synopsis-web-components.vercel.app")
//                    webView.addJavascriptInterface(WebAppInterface(requireContext()), "Android")

                }
            }
            addJavascriptInterface(WebAppInterface(context), "Android")
            loadUrl(session.widgetUrl)
        }
    }

    override fun getItemCount(): Int = sessions.size
}