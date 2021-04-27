package com.example.leruamerlendemo.components.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.leruamerlendemo.R
import com.example.leruamerlendemo.data.Category
import com.example.leruamerlendemo.utils.getResource

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private var categories: List<Category> = listOf()

    fun setItems(list: List<Category>) {
        categories = list
    }

    class CategoryHolder(val context: Context, view: View): RecyclerView.ViewHolder(view) {
        private val titleView = view.findViewById<TextView>(R.id.category_title)
        private val imgView = view.findViewById<ImageView>(R.id.category_image)
        fun bindTo(item: Category) {
            titleView.text = item.name
            val regex = """(\w+).(png|jpg)""".toRegex()
            val matchResult = regex.find(item.img)
            val (name, format) = matchResult!!.destructured
            imgView.setImageDrawable(context.getResource(name))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.caterogy_item, parent, false)
        return CategoryHolder(parent.context, view)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val item = categories[position]
        holder.bindTo(item)
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}