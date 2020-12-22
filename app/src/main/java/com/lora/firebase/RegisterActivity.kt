package com.lora.firebase

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
         val email: EditText? = findViewById(R.id.email)
         val password: EditText? = findViewById(R.id.password)
         val register: Button? = findViewById(R.id.register)
        register?.setOnClickListener(View.OnClickListener {
            val txt_email = email?.text.toString()
            println(txt_email)
            val txt_password = password?.text.toString()
            println(txt_password)
            if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                Toast.makeText(this@RegisterActivity, "Empty credentials!", Toast.LENGTH_SHORT)
                    .show()
            } else if (txt_password.length < 6) {
                Toast.makeText(this@RegisterActivity, "Password too short!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                registerUser(txt_email, txt_password)
            }
        })
    }

    private fun registerUser(email: String, password: String) {
        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                this@RegisterActivity
            ) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Registering user successful!",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Registration failed!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}