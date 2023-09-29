package com.example.saveup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class BotActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    private lateinit var chatTextView: TextView
    private lateinit var messageEditText: EditText
    private lateinit var chatLayout: LinearLayout // Agregar referencia al LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot)

        initComponents()

        drawerLayout = findViewById(R.id.drawer_bot)
    }

    private fun initComponents() {
        chatTextView = findViewById(R.id.chatTextView)
        messageEditText = findViewById(R.id.messageEditText)
        chatLayout = findViewById(R.id.chatLayout) // Referencia al LinearLayout en el XML
    }

    fun sendMessage(view: View) {
        val message = messageEditText.text.toString().trim()
        if (!message.isEmpty()) {
            // Crear un TextView para el mensaje del usuario
            val userMessage = TextView(this)
            userMessage.text = "You: $message"
            userMessage.gravity = Gravity.END // Alineación a la derecha
            chatLayout.addView(userMessage)

            // Aquí puedes agregar la lógica del chatbot y generar una respuesta apropiada
            // Por ejemplo, responder con un mensaje fijo para este ejemplo básico.
            val botResponse = "Bot: Hola, soy un chatbot. Has dicho: $message"

            // Crear un TextView para la respuesta del chatbot
            val botMessage = TextView(this)
            botMessage.text = botResponse
            botMessage.gravity = Gravity.START // Alineación a la izquierda
            chatLayout.addView(botMessage)

            // Borrar el mensaje de entrada después de enviarlo.
            messageEditText.text.clear()
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
        recreate()
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