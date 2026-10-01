package com.example.crujedopangit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val exploreButton = findViewById<Button>(R.id.superButton)
        val signOutButton = findViewById<Button>(R.id.signOutButton)

        // 1. Explore Dashboard Action
        exploreButton.setOnClickListener {
            Toast.makeText(this, "Exploring Dashboard...", Toast.LENGTH_SHORT).show()
        }

        // 2. Sign Out Action -> Redirects back to MainActivity
        signOutButton.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            // Clears activity stack so user is properly logged out
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}