package com.example.pertemuan6tugas1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Success : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        val tv_detail_tiket: TextView = findViewById(R.id.tv_detail_tiket)

        val nama = intent.getStringExtra("nama")
        val tujuan = intent.getStringExtra("tujuan")
        val tanggal = intent.getStringExtra("tanggal")
        val waktu = intent.getStringExtra("waktu")


        tv_detail_tiket.text = """
            
            
            Nama: $nama
            Jam: $waktu
            Tanggal: $tanggal
            Tujuan: $tujuan
        """.trimIndent()
    }
}