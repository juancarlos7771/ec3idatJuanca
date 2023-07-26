package com.juanca.ec3_campodonico.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.juanca.ec3_campodonico.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tilemail.editText?. addTextChangedListener   {text ->
            binding.btnlogin.isEnabled = validedEmailPass(text.toString(), binding.tilpass.editText?.text.toString())
        }

        binding.tilpass.editText?. addTextChangedListener {text ->
            binding.btnlogin.isEnabled = validedEmailPass(binding.tilemail.editText?.text.toString(), text.toString())
        }

        binding.btnlogin.setOnClickListener {
            Toast.makeText(this,"Login con Email", Toast.LENGTH_SHORT).show()
            //Para pasar a una siguiente actividad
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nombre", "Nene")
            startActivity(intent)
            Toast.makeText(this, "Bienvenido al app Los michis Store", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validedEmailPass(email: String, pass: String): Boolean {
        val ValidateEmail = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() && email=="ejemplo@idat.edu.pe"
        val ValidatePass = pass.matches("-?\\d+(\\.\\d+)?".toRegex()) && pass.length>=6 && pass == "123456"
        return ValidateEmail && ValidatePass
    }
}