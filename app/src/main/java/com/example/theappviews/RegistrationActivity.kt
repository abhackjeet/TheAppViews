package com.example.theappviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.genderTextView





class RegistrationActivity : AppCompatActivity() {

    lateinit var option : Spinner
    lateinit var result : TextView
    lateinit var selected :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val firstnameInput = findViewById<EditText>(R.id.firstnameInput)
        val lastnameInput = findViewById<EditText>(R.id.lastnameInput)
        val nicknameInput = findViewById<EditText>(R.id.nicknameInput)
        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val spinnerInput = findViewById<Spinner>(R.id.spinnerOne)

/*
        val pets = arrayOf("Dog", "Cat", "Rabbit", "Horse", "Panda")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pets)

        spinnerOne.adapter = arrayAdapter

*/

        option = findViewById(R.id.spinnerOne) as Spinner
        result = findViewById(R.id.petsText) as TextView

        val options = arrayOf("Dog", "Cat", "Rabbit", "Horse", "Panda")

        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,options)


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
            // val genderMale = male.text.toString()
            // val genderFemale = female.text.toString()


            Log.d("ash",selected)
            val intent = Intent(this@RegistrationActivity, ProfileActivity::class.java)
            intent.putExtra("Name", name)
            intent.putExtra("Nickname", nickname)
            intent.putExtra("User Email ID", emailId)
            intent.putExtra("Password", password)
            intent.putExtra("pet",selected)

            val id = radioGroup.checkedRadioButtonId

            when (id) {
                R.id.male -> intent.putExtra("Gender", "Male")
                R.id.female -> intent.putExtra("Gender", "Female")
                else -> Toast.makeText(this, "Then !!!",
                    Toast.LENGTH_LONG).show()
            }


            startActivity(intent)

        }
        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Please Select an Option"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selected = spinnerInput.getItemAtPosition(position).toString()
            }
        }
    }
}