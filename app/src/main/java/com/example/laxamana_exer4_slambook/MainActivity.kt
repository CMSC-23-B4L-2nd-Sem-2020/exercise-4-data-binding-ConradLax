package com.example.laxamana_exer4_slambook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.laxamana_exer4_slambook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName = StringData("Welcome!","Name","Nickname","Age","When is your birthday?","Phone number"
    ,"Email address","Course","What's your ultimate dream?","Who is your secret crush?","What is your message for me?",
        "Enter name","Enter nickname","Enter age","Month-Day-Year","09XX-XXX-XXXX","Enter email address"
    ,"Enter course","Enter dream","Enter name of crush","Enter message","DONE")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.submitButton.setOnClickListener{
            displayData()
        }

        binding.stringData = myName
    }

    private fun displayData() {
        binding.apply{
            stringData?.nameVal = nameEdit.text.toString()
            invalidateAll()
            greetingsText.visibility = View.GONE
            nameText.visibility = View.GONE
            nameEdit.visibility = View.GONE

        }


    }
}
