package com.example.theappviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class ProfileActivity : AppCompatActivity() {

    var isFragmentOneLoaded = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = intent

        val name = intent.getStringExtra("Name")
        val nickname = intent.getStringExtra("Nickname")
        val emailId = intent.getStringExtra("User Email ID")
        val password = intent.getStringExtra("Password")
        val gender = intent.getStringExtra("Gender")
       val selected = intent.getStringExtra("Pet")


        val nameText = findViewById<TextView>(R.id.nameText)
        nameText.text = "Name: $name"
        val nicknameText = findViewById<TextView>(R.id.nicknameText)
        nicknameText.text = "Nickname: $nickname"
        val emailText = findViewById<TextView>(R.id.emailText)
        emailText.text = "User Email ID: $emailId"
        val genderTextView = findViewById<TextView>(R.id.genderTextView)
        genderTextView.text = "Gender: $gender"
        val petTextView = findViewById<TextView>(R.id.petTV)
        petTextView.text = ("Your Pet: $selected")

        viewPass.setOnClickListener {

            val passwordText = findViewById<TextView>(R.id.passwordText)
            passwordText.text = "Password: $password"
            passwordText.setVisibility(View.VISIBLE)

        }


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
       // val manager :FragmentManager = supportFragmentManager
      //  val transaction = supportFragmentManager.beginTransaction()
        val fragment = FragmentOne()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder,fragment)
        .addToBackStack(null)
        .commitAllowingStateLoss()
        isFragmentOneLoaded = true
    }

    fun showFragmentTwo(){
      //  val manager :FragmentManager = supportFragmentManager
      //  val transaction = supportFragmentManager.beginTransaction()
        val fragment = FragmentTwo()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder,fragment)
        .addToBackStack(null)
        .commitAllowingStateLoss()
        isFragmentOneLoaded = false
    }

}














