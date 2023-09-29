package com.example.saveup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ProductAdapter(var products: ArrayList<Product>): RecyclerView.Adapter<ProductPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_product, parent, false)

        return ProductPrototype(view)
    }

    override fun onBindViewHolder(holder: ProductPrototype, position: Int) {
        holder.bind(products.get(position))
    }

    override fun getItemCount(): Int {
        return products.size
    }

}

class ProductPrototype(itemView: View): RecyclerView.ViewHolder(itemView) {
    val ivProduct = itemView.findViewById<ImageView>(R.id.ivProduct)
    val tvNombre = itemView.findViewById<TextView>(R.id.tvNombre)
    val tvFechaVencimiento = itemView.findViewById<TextView>(R.id.tvFechaVencimiento)
    val tvPrecio = itemView.findViewById<TextView>(R.id.tvPrecio)
    val tvStock = itemView.findViewById<TextView>(R.id.tvStock)
    val ivIcon = itemView.findViewById<ImageView>(R.id.ivIcon)

    fun bind(product: Product) {
        tvNombre.text = product.nombre
        tvFechaVencimiento.text = "Fecha de vencimiento:\n${product.fechaVencimiento}"
        tvPrecio.text = "Precio: S/${product.precio}"
        tvStock.text = "Stock: ${product.stock}"
    }
}
