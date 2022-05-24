package com.example.tablasdemultiplicar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class PracticarActivity : AppCompatActivity() {
    lateinit var trespuesta: EditText
    lateinit var tfactor1: TextView
    lateinit var tfactor2: TextView
    lateinit var btnComprobar: Button
    var factor1: Int = 0
    var factor2: Int = 0
    var respuesta: Int = 0
    var respuestaCorrecta= false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practicar)
        initUI()
        btnComprobar.setOnClickListener {
            var strRespuesta = trespuesta.text.toString()
            if(strRespuesta.equals("")){
                Toast.makeText(this, "no tienes capacidad cognitiva o que?", Toast.LENGTH_SHORT).show()
                initUI()
            }
            else{
                if (respuesta==strRespuesta.toInt()){
                    respuestaCorrecta=true
                    Toast.makeText(this, "Ta bien", Toast.LENGTH_SHORT).show()
                    trespuesta.text.clear()
                }
                else{
                    respuestaCorrecta=false
                    Toast.makeText(this, "Vales pi##", Toast.LENGTH_SHORT).show()
                }
                val mostrarResultado= Intent(this,activity_respuesta::class.java)
                mostrarResultado.putExtra("respuesta",respuestaCorrecta)
                startActivity(mostrarResultado)
            }
        }
    }

    fun initUI(){
        tfactor1 = findViewById(R.id.factor1)
        tfactor2 = findViewById(R.id.factor2)
        trespuesta = findViewById(R.id.respuesta)
        btnComprobar = findViewById(R.id.btnComprobar)
        multi()
        tfactor1.text = "$factor1"
        tfactor2.text = "$factor2"

    }
    fun multi(){
        factor1 = Random.nextInt(0,10)
        factor2 = Random.nextInt(0,10)
        respuesta = factor1*factor2
    }
}