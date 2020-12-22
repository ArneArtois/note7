package com.lora.firebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val register: Button = findViewById(R.id.register)
        val login: Button = findViewById(R.id.login)
        register.setOnClickListener(View.OnClickListener {
            println("test")
            startActivity(Intent(this@StartActivity, RegisterActivity::class.java))
            finish()
        })
        login.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@StartActivity, LoginActivity::class.java))
            finish()
        })
    }
}