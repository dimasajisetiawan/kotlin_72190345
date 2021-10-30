package com.example.kotlin_72190345

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.kotlin_72190345.crud.GetPetaniActivity

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin : Button
    lateinit var edEmail : EditText
    lateinit var edPassword : EditText
    var prefs_name = "session_login"
    lateinit var sharedPref : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edEmail = findViewById(R.id.edEmail)
        edPassword = findViewById(R.id.edPassword)
        btnLogin = findViewById(R.id.btnLogin)

        sharedPref = getSharedPreferences(prefs_name, Context.MODE_PRIVATE)

        var tmpEmail = sharedPref.getString("email",null)
        var tmpPassword = sharedPref.getString("password",null)

        if(!tmpEmail.isNullOrEmpty() && !tmpPassword.isNullOrEmpty()){
            finish()
            var intent = Intent(this@LoginActivity, GetPetaniActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener(View.OnClickListener { view ->
            val sharedEditor : SharedPreferences.Editor = sharedPref.edit()
            sharedEditor.putString("email",edEmail.text.toString())
            sharedEditor.putString("password",edPassword.text.toString())
            sharedEditor.apply()

            finish()
            var intent = Intent(this@LoginActivity, GetPetaniActivity::class.java)
            startActivity(intent)
        })
    }
}