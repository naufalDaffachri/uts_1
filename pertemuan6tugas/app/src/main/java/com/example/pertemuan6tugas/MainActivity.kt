package com.example.pertemuan6tugas

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerTujuan: Spinner
    private lateinit var btnPilihTanggal: Button
    private lateinit var btnPilihWaktu: Button
    private lateinit var btnProsesTiket: Button

    private var selectedTujuan: String? = null
    private var selectedTanggal: String? = null
    private var selectedWaktu: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerTujuan = findViewById(R.id.spinner_tujuan)
        btnPilihTanggal = findViewById(R.id.btn_pilih_tanggal)
        btnPilihWaktu = findViewById(R.id.btn_pilih_waktu)
        btnProsesTiket = findViewById(R.id.btn_proses_tiket)

        // Set up Spinner dengan daftar tujuan
        val tujuanAdapter = ArrayAdapter.createFromResource(
            this, R.array.daftar_tujuan, android.R.layout.simple_spinner_item
        )
        tujuanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTujuan.adapter = tujuanAdapter

        // Event Listener untuk Button Pilih Tanggal
        btnPilihTanggal.setOnClickListener { showDatePickerDialog() }

        // Event Listener untuk Button Pilih Waktu
        btnPilihWaktu.setOnClickListener { showTimePickerDialog() }

        // Event Listener untuk Button Proses Tiket
        btnProsesTiket.setOnClickListener { processTicket() }
    }

    // Fungsi untuk menampilkan DatePicker
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            selectedTanggal = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        }, year, month, day)
        datePickerDialog.show()
    }

    // Fungsi untuk menampilkan TimePicker
    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
            selectedWaktu = "$selectedHour:$selectedMinute"
        }, hour, minute, true)
        timePickerDialog.show()
    }

    // Fungsi untuk memproses tiket dan menampilkan Custom Alert
    private fun processTicket() {
        selectedTujuan = spinnerTujuan.selectedItem.toString()

        // Menampilkan AlertDialog dengan harga tiket
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Pemesanan")
            .setMessage("Harga Tiket: Rp200.000")
            .setPositiveButton("Beli") { _, _ ->
                openSuccessPage()
            }
            .setNegativeButton("Batal", null)
            .show()
    }

    // Fungsi untuk membuka halaman sukses
    private fun openSuccessPage() {
        val intent = Intent(this, SuccessActivity::class.java)
        intent.putExtra("tujuan", selectedTujuan)
        intent.putExtra("tanggal", selectedTanggal)
        intent.putExtra("waktu", selectedWaktu)
        startActivity(intent)
    }
}