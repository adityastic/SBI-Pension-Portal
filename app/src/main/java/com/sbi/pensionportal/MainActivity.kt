package com.sbi.pensionportal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sbi.pensionportal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.webViewSBI.webViewClient = SBIWebsiteClient(this)
        binding.webViewSBI.settings.javaScriptEnabled = true
        binding.webViewSBI.settings.builtInZoomControls = true
        binding.webViewSBI.settings.displayZoomControls = false
        binding.webViewSBI.loadUrl("https://www.pensionseva.sbi")

        setContentView(binding.root)
    }

    override fun onBackPressed() {
        if (binding.webViewSBI.canGoBack()) {
            binding.webViewSBI.goBack()
        } else {
            super.onBackPressed()
        }
    }
}