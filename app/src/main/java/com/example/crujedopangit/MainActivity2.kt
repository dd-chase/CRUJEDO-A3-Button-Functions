package com.example.crujedopangit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity2 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        auth = FirebaseAuth.getInstance()

        val exploreButton = findViewById<Button>(R.id.superButton)
        val signOutButton = findViewById<Button>(R.id.signOutButton)

        exploreButton.setOnClickListener {
            Toast.makeText(this, "Exploring Dashboard...", Toast.LENGTH_SHORT).show()
        }

        signOutButton.setOnClickListener {
            auth.signOut()
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}