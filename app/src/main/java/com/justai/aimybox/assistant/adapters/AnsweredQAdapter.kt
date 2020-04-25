package com.justai.aimybox.assistant.adapters

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.R


class AnsweredQAdapter(context: Context) : RecyclerView.Adapter<AnsweredQAdapter.ViewHolder>() {

    var context: Context
    var expandedPosition: Int
    var previousExpandedPosition: Int

    var isThumbClicked: Boolean = false
    var isThumbUpClicked: Boolean = false
    var isThumbDownClicked: Boolean = false
    var thumb_txt_checker: Int = 0

    init {
        this.context = context
        expandedPosition = -1
        previousExpandedPosition = -1
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var user_name: TextView
        var card_post: CardView
        var comment_txt: TextView
        var comment_img: ImageView
        var comment_Llayout: LinearLayout
        var thumb_up: ImageView
        var thumb_up_txt: TextView
        var thumb_down: ImageView
        var thumb_down_txt: TextView

        init {
            super.itemView
            user_name = itemView.findViewById(R.id.user_name)
            card_post = itemView.findViewById(R.id.card_post)
            comment_txt = itemView.findViewById(R.id.comment_txt)
            comment_img = itemView.findViewById(R.id.comment_img)
            comment_Llayout = itemView.findViewById(R.id.comment_layout)
            thumb_up = itemView.findViewById(R.id.thumb_up)
            thumb_up_txt = itemView.findViewById(R.id.thumb_up_txt)
            thumb_down = itemView.findViewById(R.id.thumb_down)
            thumb_down_txt = itemView.findViewById(R.id.thumb_down_txt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.post_layout, null)
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

        if (position % 1 == 0 || position % 2 == 0 || position % 3 == 0 || position % 4 == 0 || position % 5 == 0 || position % 6 == 0 || position % 7 == 0 || position % 8 == 0 || position % 9 == 0 || position % 3 == 0) {
            holder.user_name.setText("Michael Apina posted this")
            holder.card_post.cardElevation = 8F
        }

        changeThumbColor(
            holder.thumb_up,
            holder.thumb_up_txt,
            holder.thumb_down,
            holder.thumb_down_txt
        )
        changeThumbColor(
            holder.thumb_down,
            holder.thumb_down_txt,
            holder.thumb_up,
            holder.thumb_up_txt
        )

        popUpCommentDialog(holder.comment_Llayout)
        popUpCommentDialog(holder.comment_img)
        popUpCommentDialog(holder.comment_txt)

    }

    fun changeThumbColor(
        thumbClicked: ImageView,
        thumbClicked_txt: TextView,
        thumbUnClicked: ImageView,
        thumbUnClicked_txt: TextView
    ) {

        thumbClicked.setOnClickListener {
            if (isThumbClicked == true) {
                    thumbClicked.setColorFilter(ContextCompat.getColor(context, R.color.silver))
                    thumbClicked_txt.text = (thumbClicked_txt.text.toString().toInt() - 1).toString()
                    thumb_txt_checker = 0
                    isThumbUpClicked = false
            } else {
                thumbClicked.setColorFilter(ContextCompat.getColor(context, R.color.blue))
                thumbClicked_txt.text = (thumbClicked_txt.text.toString().toInt() + 1).toString()
                thumbUnClicked.setColorFilter(ContextCompat.getColor(context, R.color.silver))
                if (thumb_txt_checker == 1) {
                    thumbUnClicked_txt.text =
                        (thumbUnClicked_txt.text.toString().toInt() - 1).toString()
                }
                thumb_txt_checker = 1
                isThumbClicked = true
            }
//            else{
//                if(isThumbDownClicked == true){
//                    thumbClicked.setColorFilter(ContextCompat.getColor(context, R.color.silver))
//                    thumbClicked_txt.text = (thumbClicked_txt.text.toString().toInt()-1).toString()
//                    thumb_txt_checker = 2
//                    isThumbDownClicked = false
//                }else{
//                    thumbClicked.setColorFilter(ContextCompat.getColor(context, R.color.red))
//                    thumbClicked_txt.text = (thumbClicked_txt.text.toString().toInt()+1).toString()
//                    thumbUnClicked.setColorFilter(ContextCompat.getColor(context, R.color.silver))
//                    if(thumb_txt_checker == 1){
//                        thumbUnClicked_txt.text = (thumbUnClicked_txt.text.toString().toInt()-1).toString()
//                    }
//                    isThumbDownClicked = true
//                }
//            }
        }
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

            comment_editText.setOnFocusChangeListener(OnFocusChangeListener { v, hasFocus ->
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
