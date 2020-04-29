package com.justai.aimybox.assistant.adapters

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.text.TextUtils
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


class HelpCentersAdapter(context: Context, helpCenters: ArrayList<HelpCenter>) :
    RecyclerView.Adapter<HelpCentersAdapter.ViewHolder>() {

    var context: Context

    var helpCenters: ArrayList<HelpCenter>

    private val REQUEST_PERMISSION_PHONE_STATE = 1

    private val MAKE_CALL_PERMISSION_REQUEST_CODE = 1

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
        if (helpCenters.get(position).phone_no == "Unk") {
            holder.phone_no.setTextColor(context.resources.getColor(R.color.red))
        } else {
            holder.phone_no.setTextColor(context.resources.getColor(R.color.blue))
        }

        holder.phone_no.setOnClickListener {
            if (checkPermission(Manifest.permission.CALL_PHONE)) {
                holder.phone_no.setEnabled(true)
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + holder.phone_no.text.toString()))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            } else {
                holder.phone_no.setEnabled(false)
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    MAKE_CALL_PERMISSION_REQUEST_CODE
                )
            }
        }

        holder.map_img.setOnClickListener {
            val intent = Intent(context, MapsActivity::class.java)
            context.startActivity(intent)
        }
    }

    private fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

//    private fun callPhone(phone: String) {
//        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone))
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        if (ActivityCompat.checkSelfPermission(
//                context,
//                Manifest.permission.CALL_PHONE
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            ActivityCompat.requestPermissions(context as Activity, String[]{Manifest.permission.CALL_PHONE}, MAKE_CALL_PERMISSION_REQUEST_CODE);
//            return
//        }
//        context.startActivity(intent)

//    }


//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String?>?,
//        grantResults: IntArray
//    ) {
//        when (requestCode) {
//            REQUEST_PERMISSION_PHONE_STATE -> if (grantResults.size > 0
//                && grantResults[0] == PackageManager.PERMISSION_GRANTED
//            ) {
//                Toast.makeText(context, "Permission Granted!", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(context, "Permission Denied!", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

}