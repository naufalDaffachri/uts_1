package com.example.pertemuan6tugas1

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var namaPemesan: EditText
    private lateinit var jamKeberangkatan: AppCompatButton
    private lateinit var tanggalKeberangkatan: AppCompatButton
    private lateinit var spinnerTujuan: Spinner
    private lateinit var btnPesan: AppCompatButton

    private var selectedWaktu: String? = null
    private var selectedTanggal: String? = null
    private var selectedTujuan: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        namaPemesan = findViewById(R.id.namaPemesan)
        jamKeberangkatan = findViewById(R.id.jamKeberangkatan)
        tanggalKeberangkatan = findViewById(R.id.tanggalKeberangkatan)
        spinnerTujuan = findViewById(R.id.spinner_tujuan)
        btnPesan = findViewById(R.id.btn_pesan)

        val tujuanAdapter = ArrayAdapter.createFromResource(
            this, R.array.tujuan, android.R.layout.simple_spinner_item
        )
        tujuanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTujuan.adapter = tujuanAdapter

        jamKeberangkatan.setOnClickListener { showTimePickerDialog() }
        tanggalKeberangkatan.setOnClickListener { showDatePickerDialog() }
        btnPesan.setOnClickListener { processTicket() }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            selectedTanggal = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            tanggalKeberangkatan.text = selectedTanggal
        }, year, month, day)
        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
            selectedWaktu = "$selectedHour:$selectedMinute"
            jamKeberangkatan.text = selectedWaktu
        }, hour, minute, true)
        timePickerDialog.show()
    }

    private fun processTicket() {
        selectedTujuan = spinnerTujuan.selectedItem.toString()
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Pemesanan")
            .setMessage("Harga Tiket: Rp200.000")
            .setPositiveButton("Beli") { _, _ ->
                openSuccessPage()
            }
            .setNegativeButton("Batal", null)
            .show()
    }

    private fun openSuccessPage() {
        val nama = namaPemesan.text.toString()
        val intent = Intent(this, Success::class.java)
        // Log untuk mengecek apakah data benar
        Log.d("MainActivity", "Nama: $nama, Tujuan: $selectedTujuan, Tanggal: $selectedTanggal, Waktu: $selectedWaktu")
        intent.putExtra("nama", nama)
        intent.putExtra("tujuan", selectedTujuan)
        intent.putExtra("tanggal", selectedTanggal)
        intent.putExtra("waktu", selectedWaktu)
        startActivity(intent)
    }
}