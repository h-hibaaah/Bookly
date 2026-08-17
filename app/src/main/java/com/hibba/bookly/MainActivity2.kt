package com.hibba.bookly

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val button = findViewById<AppCompatButton>(R.id.appCompatButton)
        button.setOnClickListener {
            button.animate()
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(1000)
                .withEndAction {
                    button.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(1000)
                        .withEndAction {
                            val intent = Intent(this, MainActivity3::class.java)
                            startActivity(intent)
                        }
                        .start()

                }
                .start()

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}