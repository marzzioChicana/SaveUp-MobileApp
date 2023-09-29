package com.example.saveup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        //Agregar animaciones
        val animacion1: Animation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animacion2: Animation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)

        val textViewInicio: TextView = findViewById(R.id.textView_inicio)
        val imageViewInicio: ImageView = findViewById(R.id.imageView_inicio)

        textViewInicio.startAnimation(animacion2)
        imageViewInicio.startAnimation(animacion1)

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, ProductsActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) //Delay en milisegundos
    }
}