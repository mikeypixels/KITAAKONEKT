package com.justai.aimybox.assistant.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.R

class FactsAdapter(context: Context) : RecyclerView.Adapter<FactsAdapter.ViewHolder>() {

    var context: Context

    init {
        this.context = context
    }

    var fact_string_array = arrayOf(context.getString(R.string.fact1), context.getString(R.string.fact2), context.getString(R.string.fact3), context.getString(R.string.fact4), context.getString(R.string.fact5))

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var fact_txt: TextView

        init {
            fact_txt = itemView.findViewById(R.id.fact_txt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.fact_layout, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fact_string_array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fact_txt.text = fact_string_array[position]
    }

}