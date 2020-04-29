package com.justai.aimybox.assistant.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.R
import org.w3c.dom.Text

class HelpCentersAdapter(context: Context) : RecyclerView.Adapter<HelpCentersAdapter.ViewHolder>()  {

    var context: Context

    init {
        this.context = context
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var help_name: TextView
        var location: TextView
        var phone_no: TextView

        init {
            help_name = itemView.findViewById(R.id.help_name)
            location = itemView.findViewById(R.id.location)
            phone_no = itemView.findViewById(R.id.phone_no)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.help_center_layout, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.help_name.text = "Benjamin Mkapa Hospital"
    }


}