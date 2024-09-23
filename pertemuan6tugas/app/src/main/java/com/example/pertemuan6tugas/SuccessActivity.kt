package com.example.pertemuan6tugas

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        val tvHasil: TextView = findViewById(R.id.tv_hasil)

        // Ambil data dari Intent
        val tujuan = intent.getStringExtra("tujuan")
        val tanggal = intent.getStringExtra("tanggal")
        val waktu = intent.getStringExtra("waktu")

        // Tampilkan data di TextView
        tvHasil.text = """
            Berhasil Mendapatkan Tiket!
            
            Tujuan: $tujuan
            Tanggal: $tanggal
            Waktu: $waktu
        """.trimIndent()
    }
}