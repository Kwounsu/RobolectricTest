package com.example.employeedemo

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        button_changeAge.setOnClickListener {
            val ageTextView = findViewById<TextView>(R.id.textView_age)
            if (ageTextView.text == "99") {
                ageTextView.text = "12"
            } else {
                ageTextView.text = "99"
            }
        }
    }
}