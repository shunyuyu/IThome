package com.example.ithome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        fullScreen(this)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        val prefs = getPreferences(MODE_PRIVATE)
        val isDemember = prefs.getBoolean("remember_pwd",false)
        if (isDemember){
            val phone = prefs.getString("phone","")
            val pwd = prefs.getString("pwd","")
            Phone.setText(phone)
            Pass.setText(pwd)
            checkBoxPass.isChecked = true
        }
        LoginButton.setOnClickListener {
            val phone = Phone.text.trim().toString()
            val pwd = Pass.text.trim().toString()
            if (phone== "123456" && pwd == "123456"){
                val editor = prefs.edit()
                if (checkBoxPass.isChecked){
                    editor.putBoolean("remember_pwd",true)
                    editor.putString("phone",phone)
                    editor.putString("pwd",pwd)
                }else{
                    editor.clear()
                }
                editor.apply()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"账号或者密码错误，请重试", Toast.LENGTH_LONG).show()
            }
        }

        Geregistreer.setOnClickListener {
            val intent = Intent(this,GeregistreerActivity::class.java)
            startActivity(intent)
        }
    }
}