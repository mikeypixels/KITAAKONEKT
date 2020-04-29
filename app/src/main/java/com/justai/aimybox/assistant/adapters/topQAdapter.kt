package com.justai.aimybox.assistant.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.R

class topQAdapter(context: Context, questions_array: Array<String?>, answers_array: Array<String?>) : RecyclerView.Adapter<topQAdapter.ViewHolder>() {

    var context: Context

    var qn_array: Array<String?>
    var ans_array: Array<String?>

    init {
        this.context = context
        qn_array = questions_array
        ans_array = answers_array
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
        return qn_array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.qn.text = qn_array[position]
        holder.ans.text = ans_array[position]
    }

}