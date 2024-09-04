package com.rifa.project1rifa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nama:EditText
    lateinit var submit:Button
    lateinit var output:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //nama = findViewById(R.id.editNama)
        //submit = findViewById(R.id.btnSubmit)
        //output = findViewById(R.id.txtOut)
        //submit.setOnClickListener {
            //output.text = "Nama Mahasiswa :"+nama.text.toString()
        val nama = findViewById<EditText>(R.id.editNama)
        val submit = findViewById<Button>(R.id.btnSubmit)
        val output = findViewById<TextView>(R.id.txtOut)
        submit.setOnClickListener {
            output.text = "Nama Mahasiswa :"+nama.text.toString()
        }
    }
}