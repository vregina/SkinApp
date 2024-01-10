package com.example.skinapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skinapp.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        with(binding) {
            tvForgotPassword.setOnClickListener {
                val intent = Intent(this@LoginActivity, RecoverPasswordActivity::class.java)
                startActivity(intent)
            }
        }
    }
}