package com.example.pertemuan5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pertemuan5.databinding.ActivitySecondBinding
import com.example.pertemuan5.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        with(binding) {
            btnToSecondActivity.setOnClickListener {
                val resultIntent = Intent()
                // Memasukkan alamat ke Intent
                resultIntent.putExtra(SecondActivity.EXTRA_ADDRESS, edtAddress.text.toString())
                resultIntent.putExtra(MainActivity.EXTRA_NAME, name)
                // Menetapkan result code dan data Intent
                setResult(Activity.RESULT_OK, resultIntent)
                // Menyelesaikan aktivitas
                finish()
            }
        }
    }
}