package com.example.saveup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    var products = ArrayList<Product>()
    var productAdapter = ProductAdapter(products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        drawerLayout = findViewById(R.id.drawer_products)

        loadProducts()

        initView()
    }

    private fun initView() {
        val rvProducts = findViewById<RecyclerView>(R.id.rvProducts)

        rvProducts.adapter = productAdapter

        rvProducts.layoutManager = GridLayoutManager(this, 2)
    }

    private fun loadProducts() {
        products.add(Product("Leche Gloria", "14-11-2023", 12.03, 5))
        products.add(Product("Mantequilla Laive", "09-07-2024", 20.15, 10))
        products.add(Product("Frugos del Valle", "27-10-2024", 10.43, 9))
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
        recreate()
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