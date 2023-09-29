package com.example.saveup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class PurchaseConfirmationActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_confirmation)

        drawerLayout = findViewById(R.id.drawer_purchase_confirmation)

        val textCard = findViewById<TextView>(R.id.purchase_confirmation_text)
        textCard.text = "Confirmación\nCompra exitosa"

        Handler().postDelayed({
            val intent = Intent(this, ProductsActivity::class.java)
            startActivity(intent)
            finish() // Cerramos esta actividad para que el usuario no pueda volver atrás
        }, 2000) // 2000 milisegundos (2 segundos)
    }

    // Toolbar

    fun clickMenu(view: View) {
        drawerLayout.openDrawer(GravityCompat.START)
    }

    fun clickCart(view: View) {
        val intent = Intent(this, CartActivity::class.java)
        startActivity(intent)
    }

    fun clickLens(view: View) {
        val intent = Intent(this, SearchProductsActivity::class.java)
        startActivity(intent)
    }

    // NavigationDrawer

    fun paginaPrincipal(view: View) {
        val intent = Intent(this, ProductsActivity::class.java)
        startActivity(intent)
    }

    fun bandejaEntrada(view: View) {
        val intent = Intent(this, BotActivity::class.java)
        startActivity(intent)
    }

    fun perfil(view: View) {
        Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()
    }

    fun historial(view: View) {
        val intent = Intent(this, HistoryActivity::class.java)
        startActivity(intent)
    }

    fun cerrarSesion(view: View) {
        val intent = Intent(this, LogOutActivity::class.java)
        startActivity(intent)
    }
}