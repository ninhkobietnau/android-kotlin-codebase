package com.ninhnau.base.aiart.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ninhnau.base.aiart.R
import com.ninhnau.base.aiart.util.HomeRecyclerViewClick
import java.util.ArrayList

class ModelAdapter(
    val context: Context,
    private val list: ArrayList<Int>,
    private val listPrompt: ArrayList<String>,
    private val type: String,
    private val click: HomeRecyclerViewClick
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model_layout, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ModelViewHolder) {
            holder.bind(list[position])
            holder.itemView.setOnClickListener {
                click.onClick(listPrompt[position], list[position], type)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ModelViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(drawable: Int) {
            val image = itemView.findViewById<AppCompatImageView>(R.id.img_item)
            image.setImageDrawable(ContextCompat.getDrawable(context, drawable))
        }
    }
}