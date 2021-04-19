package com.example.accessibilitydemo.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.accessibilitydemo.IBAN_STR
import com.example.accessibilitydemo.NAME_STR
import com.example.accessibilitydemo.databinding.ActivityConfirmationBinding

class ConfirmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bundle: Bundle? = intent.extras
        val iban: String? = intent.getStringExtra(IBAN_STR)
        val name: String? = intent.getStringExtra(NAME_STR)

        binding.ibanTextView.text = iban
        binding.toTextView.text = name

        binding.confirmButton.setOnClickListener {
            val intent = Intent(this, DoneActivity::class.java)
            startActivity(intent)
        }
    }
}