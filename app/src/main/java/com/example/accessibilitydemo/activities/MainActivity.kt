package com.example.accessibilitydemo.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.accessibilitydemo.NAVIGATION
import com.example.accessibilitydemo.SHARE
import com.example.accessibilitydemo.TRANSFER
import com.example.accessibilitydemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.transferButton.setOnClickListener {

            val intent = Intent(this, OptionActivity::class.java)
            intent.putExtra(NAVIGATION, TRANSFER)
            startActivity(intent)
        }

        binding.shareButton.setOnClickListener{

            val intent = Intent(this, OptionActivity::class.java)
            intent.putExtra(NAVIGATION, SHARE)
            startActivity(intent)
        }
    }
}