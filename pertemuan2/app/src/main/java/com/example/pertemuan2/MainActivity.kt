package com.example.pertemuan2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pertemuan2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            txtCounter.text = number.toString()
            btnCount.setOnClickListener{
                number++
                txtCounter.text = number.toString()
            }
            btnToast.setOnClickListener{
                Toast.makeText(this@MainActivity, "Count $number",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}
