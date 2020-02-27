package com.example.laxamana_exer4_slambook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.laxamana_exer4_slambook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //makes a binding of components in activity_main
    private lateinit var binding: ActivityMainBinding
    //instantiates a class StringData
    private val myName = StringData("Welcome!","Name","Nickname","Age","When is your birthday?","Phone number"
    ,"Email address","Course","What's your ultimate dream?","Who is your secret crush?","What is your message for me?",
        "Enter name","Enter nickname","Enter age","Month-Day-Year","09XX-XXX-XXXX","Enter email address"
    ,"Enter course","Enter dream","Enter name of crush","Enter message","DONE","\n\nThank you for answering!")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //binding holds all components inside the <layout> tag
        binding.submitButton.setOnClickListener{
            displayData()
        }
        //assigns the newly-initialized myName class instance of StringData then give the value to the initiated variable named stringData found in activity_main
        binding.stringData = myName
    }

    private fun displayData() {
        //shortcut for binding each variables in Kotlin
        binding.apply{
            stringData?.nameVal = nameEdit.text.toString()
            stringData?.nicknameVal = nicknameEdit.text.toString()
            stringData?.ageVal = ageEdit.text.toString()
            stringData?.bdayVal = bdayEdit.text.toString()
            stringData?.phoneVal = phoneEdit.text.toString()
            stringData?.emailVal = emailEdit.text.toString()
            stringData?.courseVal = courseEdit.text.toString()
            stringData?.dreamVal = dreamEdit.text.toString()
            stringData?.crushVal = crushEdit.text.toString()
            stringData?.msgVal = msgEdit.text.toString()
            invalidateAll()         //updates the UI / refreshes the value of the variables above in binding object

            //all initial textViews will disappear when submit_button is pressed
            greetingsText.visibility = View.GONE
            nameText.visibility = View.GONE
            nameEdit.visibility = View.GONE
            nicknameText.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            ageText.visibility = View.GONE
            ageEdit.visibility = View.GONE
            bdayText.visibility = View.GONE
            bdayEdit.visibility = View.GONE
            phoneText.visibility = View.GONE
            phoneEdit.visibility = View.GONE
            emailText.visibility = View.GONE
            emailEdit.visibility = View.GONE
            courseText.visibility = View.GONE
            courseEdit.visibility = View.GONE
            dreamText.visibility = View.GONE
            dreamEdit.visibility = View.GONE
            crushText.visibility = View.GONE
            crushEdit.visibility = View.GONE
            msgText.visibility = View.GONE
            msgEdit.visibility = View.GONE
            submitButton.visibility = View.GONE
            //makes the output texts from user's input visible when submit_button is pressed
            outputName.visibility = View.VISIBLE
            outputNickname.visibility = View.VISIBLE
            outputAge.visibility = View.VISIBLE
            outputBday.visibility = View.VISIBLE
            outputPhone.visibility = View.VISIBLE
            outputEmail.visibility = View.VISIBLE
            outputCourse.visibility = View.VISIBLE
            outputDream.visibility = View.VISIBLE
            outputCrush.visibility = View.VISIBLE
            outputMsg.visibility = View.VISIBLE
            responseText.visibility = View.VISIBLE
        }
// Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.submitButton.windowToken, 0)

    }
}
