package com.example.saveup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class LogOutActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_out)

        drawerLayout = findViewById(R.id.drawer_log_out)

        val logOutText = findViewById<TextView>(R.id.log_out_text)
        logOutText.text = "¿Desea cerrar sesión?"

        val bt1 = findViewById<Button>(R.id.log_out_bt1)
        val bt2 = findViewById<Button>(R.id.log_out_bt2)

        bt1.text = "SI"
        bt2.text = "NO"

        bt1.setOnClickListener {
            finishAffinity()
        }
        bt2.setOnClickListener {
            val intent = Intent(this, ProductsActivity::class.java)
            startActivity(intent)
        }
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
        recreate()
    }
}