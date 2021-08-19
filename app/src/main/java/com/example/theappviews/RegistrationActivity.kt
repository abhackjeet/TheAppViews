package com.example.theappviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.get
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registration.*
import java.lang.ref.PhantomReference

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val firstnameInput = findViewById<EditText>(R.id.firstnameInput)
        val lastnameInput = findViewById<EditText>(R.id.lastnameInput)
        val nicknameInput = findViewById<EditText>(R.id.nicknameInput)
        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)

        registerButton.setOnClickListener {


            if(TextUtils.isEmpty(firstnameInput.text.toString())) {
                firstnameInput.setError("Please enter first name ")
                return@setOnClickListener
            } else if(TextUtils.isEmpty(lastnameInput.text.toString())) {
                lastnameInput.setError("Please enter last name ")
                return@setOnClickListener
            }else if(TextUtils.isEmpty(usernameInput.text.toString())) {
                usernameInput.setError("Please enter user name ")
                return@setOnClickListener
            }else if(TextUtils.isEmpty(passwordInput.text.toString())) {
                passwordInput.setError("Please enter password ")
                return@setOnClickListener
            }
            else if(!male.isChecked() && !female.isChecked())
            {
                genderTextView.setError("Please select the Gender ")
                return@setOnClickListener
            }


            val name = firstnameInput.text.toString() + " " + lastnameInput.text.toString()
            val nickname = nicknameInput.text.toString()
            val emailId = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            val genderMale = male.text.toString()
            val genderFemale = female.text.toString()


            val intent = Intent(this@RegistrationActivity, ProfileActivity::class.java)
            intent.putExtra("Name", name)
            intent.putExtra("Nickname", nickname)
            intent.putExtra("User Email ID", emailId)
            intent.putExtra("Password", password)

            val id = radioGroup.checkedRadioButtonId

            when (id) {
                R.id.male -> intent.putExtra("Gender", "Male")
                R.id.female -> intent.putExtra("Gender", "Female")
                else -> Toast.makeText(this, "Then !!!",
                    Toast.LENGTH_LONG).show()
            }

            startActivity(intent)

        }

    }
}