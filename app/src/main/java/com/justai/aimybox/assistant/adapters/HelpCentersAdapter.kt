package com.justai.aimybox.assistant.adapters

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.HelpCenter
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.activities.MapsActivity

class HelpCentersAdapter(context: Context, helpCenters: ArrayList<HelpCenter>) : RecyclerView.Adapter<HelpCentersAdapter.ViewHolder>()  {

    var context: Context

    var helpCenters: ArrayList<HelpCenter>

    init {
        this.context = context
        this.helpCenters = helpCenters
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var help_name: TextView
        var location: TextView
        var phone_no: TextView
        var map_img: ImageView

        init {
            help_name = itemView.findViewById(R.id.help_name)
            location = itemView.findViewById(R.id.location)
            phone_no = itemView.findViewById(R.id.phone_no)
            map_img = itemView.findViewById(R.id.map_img)
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
        holder.help_name.text = helpCenters.get(position).name
        holder.location.text = helpCenters.get(position).location
        holder.phone_no.text = helpCenters.get(position).phone_no
        if(helpCenters.get(position).phone_no == "Unk"){
            holder.phone_no.setTextColor(context.resources.getColor(R.color.red))
        }else{
            holder.phone_no.setTextColor(context.resources.getColor(R.color.blue))
        }

        holder.phone_no.setOnClickListener{
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + "0712957994")

            Toast.makeText(context, "Just inside the listener", Toast.LENGTH_SHORT).show()
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.CALL_PHONE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return@setOnClickListener
            }
            Toast.makeText(context, "after the listener", Toast.LENGTH_SHORT).show()
            context.startActivity(intent)
        }

        holder.map_img.setOnClickListener {
            val intent = Intent(context, MapsActivity::class.java)
            context.startActivity(intent)
        }
    }

}