package com.example.accessibilitydemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.accessibilitydemo.databinding.ActivityTransferBinding

class TransferActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransferBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransferBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.nextBtn.setOnClickListener {

            if(binding.ibanText.text.toString().trim().isEmpty()){
                binding.ibanText.error = "Enter a destination account"
                return@setOnClickListener
            }

            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra(IBAN_STR, binding.ibanText.text.toString())
            intent.putExtra(NAME_STR, binding.toText.text.toString())
            startActivity(intent)
        }
    }
}