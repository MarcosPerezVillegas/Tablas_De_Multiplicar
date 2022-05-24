package com.example.tablasdemultiplicar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView

class activity_respuesta : AppCompatActivity() {
    lateinit var animationView:LottieAnimationView
    lateinit var btnRegresarRe: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respuesta)
        btnRegresarRe = findViewById(R.id.btnRegresarRes)

        btnRegresarRe.setOnClickListener {
            val intentPracticar = Intent(this,PracticarActivity::class.java)
            startActivity(intentPracticar)
        }

        animationView= findViewById(R.id.animation_view)

        val extras=intent.extras
        val respuestaCorrecta=extras!!.getBoolean("respuesta")
        if (respuestaCorrecta){
            animationView.setAnimation(R.raw.success)
        }else{
            animationView.setAnimation(R.raw.wrong)
        }


    }
}