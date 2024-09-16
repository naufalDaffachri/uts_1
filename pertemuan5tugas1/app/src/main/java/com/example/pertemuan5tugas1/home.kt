package com.example.pertemuan5tugas1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class home : AppCompatActivity() {
    private lateinit var welcomeText: TextView
    private lateinit var emailText: TextView
    private lateinit var phoneText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        welcomeText = findViewById(R.id.textWelcome)
        emailText = findViewById(R.id.textEmail)
        phoneText = findViewById(R.id.textPhone)

        // Mendapatkan data dari LoginActivity
        val intent = intent
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")

        // Menampilkan data di halaman Home
        welcomeText.text = "Welcome $username"
        emailText.text = "Your email has been activated: $email"
        phoneText.text = "Your phone has been registered: $phone"
    }
}