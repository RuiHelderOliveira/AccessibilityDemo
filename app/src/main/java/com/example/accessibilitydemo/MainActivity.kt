package com.example.accessibilitydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.accessibilitydemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.nextBtn.setOnClickListener {

            if(binding.ibanText.text.toString().trim().isEmpty()){
                binding.ibanText.error = "Enter a distination account"
                return@setOnClickListener
            }

            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra(IBAN_STR, binding.ibanText.text.toString())
            intent.putExtra(NAME_STR, binding.toText.text.toString())
            startActivity(intent)
        }
    }
}