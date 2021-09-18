package com.zeygame.newsdh.view

import android.R.attr
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.zeygame.newsdh.R
import com.zeygame.newsdh.databinding.FragmentWebViewBinding
import android.R.attr.data

import android.content.Intent
import android.net.Uri


class WebViewFragment : Fragment(R.layout.fragment_web_view) {
    private var _binding : FragmentWebViewBinding?=null
    private val binding get() = _binding!!

    private val args:WebViewFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWebViewBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpWebView(args.webUrl)

        binding.btnOpenAtBrowser.setOnClickListener {
            val defaultBrowser = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
            defaultBrowser.data = Uri.parse(args.webUrl)
            startActivity(defaultBrowser)
        }
    }

    private fun setUpWebView(url:String){
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}