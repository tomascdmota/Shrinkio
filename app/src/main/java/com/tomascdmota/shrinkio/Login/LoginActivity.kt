package com.tomascdmota.shrinkio.Login

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.Toast
import android.widget.Toolbar
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tomascdmota.shrinkio.MainActivity
import com.tomascdmota.shrinkio.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        // Getting the email and password
        loginBtn.setOnClickListener {
            val email = email.text.toString().trim()
            val password = password.text.toString().trim()

            Log.e("TAG",email)

            //Getting access to an instance of firebase and loggin in
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnSuccessListener {
                //Login successful, update UI
                startActivity(Intent(this, MainActivity::class.java))
                it.user?.email?.let { it1 -> Log.e("TAG", it1) }
                overridePendingTransition(0,0)

            } .addOnFailureListener{
                it.printStackTrace()
            }
                    .addOnCompleteListener{
                    }
        }


        register.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java )
            startActivity(i)
            overridePendingTransition(0,0)
        }



    }




    private fun validateForm(): Boolean {
        var valid = true

        val email = findViewById<View>(R.id.email).toString()
        val password = findViewById<View>(R.id.password).toString()
        val button = findViewById<View>(R.id.loginBtn)

        if(TextUtils.isEmpty(email)){
            valid = false
            Toast.makeText(this@LoginActivity, "Please use your email",Toast.LENGTH_SHORT).show()
        } else {

        }

        if(TextUtils.isEmpty(password)) {
            valid = false
            Toast.makeText(this@LoginActivity, "Please enter a password",Toast.LENGTH_SHORT).show()
        } else {

        }

        return valid
    }




}