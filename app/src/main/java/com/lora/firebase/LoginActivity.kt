package com.lora.firebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.password)
        val login: Button = findViewById(R.id.login)
        login.setOnClickListener(View.OnClickListener {
            val txt_email = email.text.toString()
            println(txt_email)
            val txt_password = password.text.toString()
            loginUser(txt_email, txt_password)
        })
    }

    private fun loginUser(email: String, password: String) {
        val auth: FirebaseAuth? = FirebaseAuth.getInstance()
        auth?.signInWithEmailAndPassword(email, password)
            ?.addOnSuccessListener {
                Toast.makeText(this@LoginActivity, "Login Successful!", Toast.LENGTH_SHORT)
                    .show()
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
    }
}
