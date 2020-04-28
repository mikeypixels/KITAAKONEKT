package com.justai.aimybox.assistant.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.R

class topQAdapter(context: Context) : RecyclerView.Adapter<topQAdapter.ViewHolder>() {

    var context: Context

    init {
        this.context = context
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var qn: TextView
        var ans: TextView

        init {
            qn = itemView.findViewById(R.id.qn)
            ans = itemView.findViewById(R.id.ans)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.topquestion_layout, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.qn.text = context.getString(R.string.relationship_q1)
        holder.ans.text = context.getString(R.string.relationship_ans1)
    }

}