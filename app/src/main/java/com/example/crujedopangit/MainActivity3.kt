package com.example.crujedopangit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity3 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        auth = FirebaseAuth.getInstance()

        val regEmail = findViewById<EditText>(R.id.regEmailEditText)
        val regPassword = findViewById<EditText>(R.id.regPasswordEditText)
        val registerBtn = findViewById<Button>(R.id.registerButton)
        val backToLogin = findViewById<TextView>(R.id.backToLoginTextView)

        registerBtn.setOnClickListener {
            val email = regEmail.text.toString().trim()
            val password = regPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 6) {
                Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Registration Successful! Please Login.", Toast.LENGTH_SHORT).show()
                        finish() // Go back to Login Activity
                    } else {
                        Toast.makeText(this, "Registration Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        backToLogin.setOnClickListener {
            finish()
        }
    }
}