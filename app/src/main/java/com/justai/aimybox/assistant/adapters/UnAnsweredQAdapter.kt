package com.justai.aimybox.assistant.adapters

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.R

class UnAnsweredQAdapter(context: Context): RecyclerView.Adapter<UnAnsweredQAdapter.ViewHolder>() {

    var context: Context
    var expandedPosition: Int
    var previousExpandedPosition: Int

    init {
        this.context = context
        expandedPosition = -1
        previousExpandedPosition = -1
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var user_name: TextView
        var card_post: CardView
        var comment_txt: TextView
        var comment_img: ImageView
        var comment_Llayout: LinearLayout

        init {
            super.itemView
            user_name = itemView.findViewById(R.id.user_name)
            card_post = itemView.findViewById(R.id.card_post)
            comment_txt = itemView.findViewById(R.id.comment_txt)
            comment_img = itemView.findViewById(R.id.comment_img)
            comment_Llayout = itemView.findViewById(R.id.comment_layout)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.unanswered_post_layout, null)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.user_name.setText("Michael Apina posted this")
        holder.card_post.cardElevation = 8F

        if(position%1==0 || position%2==0 || position%3==0 || position%4==0 || position%5==0 || position%6==0 || position%7==0 || position%8==0 || position%9==0 || position%3==0){
            holder.user_name.setText("Michael Apina posted this")
            holder.card_post.cardElevation = 8F
        }

        popUpCommentDialog(holder.comment_Llayout)
        popUpCommentDialog(holder.comment_img)
        popUpCommentDialog(holder.comment_txt)
    }

    fun popUpCommentDialog(view: View) {
        view.setOnClickListener {

            lateinit var cLayout: ConstraintLayout

            val dialog = Dialog(context)
            val dm = context.resources.displayMetrics
            val width = dm.widthPixels
            val height = dm.heightPixels
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.comment_layout)

            val comment_editText = dialog.findViewById<EditText>(R.id.comment_editText)
            comment_editText.layoutParams.height = (0.25 * height).toInt()

            comment_editText.setOnFocusChangeListener(View.OnFocusChangeListener { v, hasFocus ->
                comment_editText.post(Runnable {
                    val inputMethodManager: InputMethodManager =
                        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.showSoftInput(
                        comment_editText,
                        InputMethodManager.SHOW_IMPLICIT
                    )
                })
            })

            comment_editText.requestFocus()

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.attributes?.windowAnimations =
                R.style.DialogAnimation

            cLayout = dialog.findViewById(R.id.cLayout)
            val lLayout_height = cLayout.layoutParams.height

            dialog.window!!.setLayout((width * .92).toInt(), lLayout_height)
            dialog.setCancelable(true)

            dialog.show()
        }
    }
}