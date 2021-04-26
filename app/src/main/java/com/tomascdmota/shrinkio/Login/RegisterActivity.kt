package com.tomascdmota.shrinkio.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.tomascdmota.shrinkio.MainActivity
import com.tomascdmota.shrinkio.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.password
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerBtn.setOnClickListener{
            val email = mail.text.toString()
            val password = password.text.toString()

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                startActivity(Intent(this, MainActivity::class.java))
                it.user?.email?.let { it1 -> Log.e("TAG", it1) }
                overridePendingTransition(0,0)
            }
                .addOnFailureListener{
                    it.printStackTrace()
                }
        }



        toLogin.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java )
            startActivity(i)
            overridePendingTransition(0,0)
        }
    }
}