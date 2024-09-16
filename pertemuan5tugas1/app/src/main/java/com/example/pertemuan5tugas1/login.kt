package com.example.pertemuan5tugas1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button

    private var regUsername: String? = null
    private var regPassword: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.editUsernameLogin)
        password = findViewById(R.id.editPasswordLogin)
        loginButton = findViewById(R.id.buttonLogin)

        // Mendapatkan data dari RegisterActivity

        regUsername = intent.getStringExtra("username")
        regPassword = intent.getStringExtra("password")
        if (regUsername == null || regPassword == null) {
            Toast.makeText(this, "Error: Data not received from RegisterActivity!", Toast.LENGTH_SHORT).show()
            return
        }

        loginButton.setOnClickListener {
            val userLogin = username.text.toString()
            val passLogin = password.text.toString()

            // Mengecek apakah username dan password sesuai
            if (userLogin == regUsername && passLogin == regPassword) {
                val homeIntent = Intent(this@login, home::class.java)
                homeIntent.putExtra("username", regUsername)
                homeIntent.putExtra("email", intent.getStringExtra("email"))
                homeIntent.putExtra("phone", intent.getStringExtra("phone"))
                startActivity(homeIntent)
                finish()
            } else {
                // Jika gagal login
                Toast.makeText(this@login, "Login failed! Incorrect username or password.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}