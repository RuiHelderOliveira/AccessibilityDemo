package com.example.accessibilitydemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.accessibilitydemo.databinding.ActivityConfirmationBinding
import com.example.accessibilitydemo.databinding.ActivityDoneBinding

class DoneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}
