package com.example.theappviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class ProfileActivity : AppCompatActivity() {

    var isFragmentOneLoaded = true
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = intent

        val name = intent.getStringExtra("Name")
        val nickname = intent.getStringExtra("Nickname")
        val emailId = intent.getStringExtra("User Email ID")
        val password = intent.getStringExtra("Password")
        val gender = intent.getStringExtra("Gender")


        val nameText = findViewById<TextView>(R.id.nameText)
        nameText.text = "Name: $name"
        val nicknameText = findViewById<TextView>(R.id.nicknameText)
        nicknameText.text = "Nickname: $nickname"
        val emailText = findViewById<TextView>(R.id.emailText)
        emailText.text = "User Email ID: $emailId"
        val genderTextView = findViewById<TextView>(R.id.genderTextView)
        genderTextView.text = "Gender: $gender"

        viewPass.setOnClickListener {

            val passwordText = findViewById<TextView>(R.id.passwordText)
            passwordText.text = "Password: $password"
            passwordText.setVisibility(View.VISIBLE)

        }

        /*

        fragmnwt
local login sys
rec view
views al

         */

        hidePass.setOnClickListener {

            val passwordText = findViewById<TextView>(R.id.passwordText)
            passwordText.setVisibility(View.GONE)

        }

        logoutButton.setOnClickListener {
            startActivity(Intent(this@ProfileActivity, LoginActivity::class.java))
        }

        view_cars.setOnClickListener {
            startActivity(Intent(this@ProfileActivity, RecViewScreen::class.java))
        }


        showFragmentOne()

        change_frag.setOnClickListener {
            if (isFragmentOneLoaded)
                showFragmentTwo()
            else
                showFragmentOne()
        }


    }
    fun showFragmentOne(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true
    }

    fun showFragmentTwo(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false
    }

}














