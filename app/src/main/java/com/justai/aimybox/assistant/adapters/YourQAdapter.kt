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
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.R


class YourQAdapter(context: Context) : RecyclerView.Adapter<YourQAdapter.ViewHolder>() {

    var context: Context

    init {
        this.context = context
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var user_name: TextView
        var card_post: CardView
        var comment_Llayout: LinearLayout
        var comment_txt: TextView
        var comment_img: ImageView

        init {
            user_name = itemView.findViewById(R.id.user_name)
            card_post = itemView.findViewById(R.id.card_post)
            comment_Llayout = itemView.findViewById(R.id.comment_layout)
            comment_txt = itemView.findViewById(R.id.comment_txt)
            comment_img = itemView.findViewById(R.id.comment_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.questions_layout, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.user_name.setText("You posted this")
        holder.card_post.cardElevation = 8F

        lateinit var cLayout: ConstraintLayout

        if (position == 0) {
            val topMargin: ViewGroup.MarginLayoutParams =
                holder.card_post.layoutParams as ViewGroup.MarginLayoutParams
            topMargin.topMargin = 115

            holder.card_post.layoutParams = topMargin

//            val layoutParams =
//                holder.card_post.getLayoutParams() as LinearLayout.LayoutParams
//            layoutParams.topMargin = 100
//            holder.card_post.setLayoutParams(layoutParams)
        }else{
            val topMargin: ViewGroup.MarginLayoutParams =
                holder.card_post.layoutParams as ViewGroup.MarginLayoutParams
            topMargin.topMargin = 20

            holder.card_post.layoutParams = topMargin
        }

        if (position % 1 == 0 || position % 2 == 0 || position % 3 == 0 || position % 4 == 0 || position % 5 == 0 || position % 6 == 0 || position % 7 == 0 || position % 8 == 0 || position % 9 == 0 || position % 3 == 0) {
            holder.user_name.setText("You posted this")
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

    fun View.setMargins(
        left: Int? = null,
        top: Int? = null,
        right: Int? = null,
        bottom: Int? = null
    ) {
        val lp = layoutParams as? ViewGroup.MarginLayoutParams
            ?: return

        lp.setMargins(
            left ?: lp.leftMargin,
            top ?: lp.topMargin,
            right ?: lp.rightMargin,
            bottom ?: lp.rightMargin
        )

        layoutParams = lp
    }
}