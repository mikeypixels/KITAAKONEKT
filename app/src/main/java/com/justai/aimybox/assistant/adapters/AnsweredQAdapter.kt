package com.justai.aimybox.assistant.adapters

import android.R.color
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.AnsweredQ
import com.justai.aimybox.assistant.R


class AnsweredQAdapter(context: Context, post_array: ArrayList<AnsweredQ>, checker: Int) :
    RecyclerView.Adapter<AnsweredQAdapter.ViewHolder>() {

    var context: Context
    var expandedPosition: Int
    var previousExpandedPosition: Int

    val post_array: ArrayList<AnsweredQ>

    var isThumbClicked: Boolean = false
    var isThumbUpClicked: Boolean = false
    var isThumbDownClicked: Boolean = false
    var thumb_txt_checker: Int = 0

    var checker: Int

    init {
        this.context = context
        expandedPosition = -1
        previousExpandedPosition = -1
        this.post_array = post_array
        this.checker = checker
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var user_name: TextView
        var card_post: CardView
        var duration: TextView
        var question: TextView
        var answer: TextView
        var ans_no: TextView
        var view_more: TextView
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
            duration = itemView.findViewById(R.id.duration)
            question = itemView.findViewById(R.id.question)
            answer = itemView.findViewById(R.id.answer)
            ans_no = itemView.findViewById(R.id.ans_no)
            view_more = itemView.findViewById(R.id.view_more)
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
        return post_array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.user_name.setText(post_array.get(position).post_user + " aliuliza")
        holder.duration.setText(post_array.get(position).duration)
        holder.question.setText(post_array.get(position).question)
        holder.answer.setText(post_array.get(position).answer)
        holder.ans_no.setText(post_array.get(position).ans_no)
        holder.thumb_up_txt.setText(post_array.get(position).liked_no)
        holder.thumb_down_txt.setText(post_array.get(position).disliked_no)
        holder.card_post.cardElevation = 8F

        if (position % 1 == 0 || position % 2 == 0 || position % 3 == 0 || position % 4 == 0 || position % 5 == 0 || position % 6 == 0 || position % 7 == 0 || position % 8 == 0 || position % 9 == 0 || position % 3 == 0) {
            holder.user_name.setText(post_array.get(position).post_user + " aliuliza")
            holder.duration.setText(post_array.get(position).duration)
            holder.question.setText(post_array.get(position).question)
            holder.answer.setText(post_array.get(position).answer)
            holder.thumb_up_txt.setText(post_array.get(position).liked_no)
            holder.thumb_down_txt.setText(post_array.get(position).disliked_no)
            holder.card_post.cardElevation = 8F
        }

        if (position == 0 && checker == 2) {
            val topMargin: ViewGroup.MarginLayoutParams =
                holder.card_post.layoutParams as ViewGroup.MarginLayoutParams
            topMargin.topMargin = 115

            holder.card_post.layoutParams = topMargin

        } else {
            val topMargin: ViewGroup.MarginLayoutParams =
                holder.card_post.layoutParams as ViewGroup.MarginLayoutParams
            topMargin.topMargin = 20

            holder.card_post.layoutParams = topMargin
        }

        if ((position == 1 || position == 2 || position == 5 || position == 7) && checker == 1) {
            holder.thumb_up.setColorFilter(ContextCompat.getColor(context, R.color.blue))
        } else {
            holder.thumb_up.setColorFilter(ContextCompat.getColor(context, R.color.silver))
        }

        if (checker == 2) {
            holder.thumb_up.setColorFilter(ContextCompat.getColor(context, R.color.blue))
        }

//        val wrappedDrawable: Drawable? = context.getDrawable(R.drawable.ic_thumb_up_black_24dp)
//        DrawableCompat.setTint(wrappedDrawable, color)

        holder.thumb_up.setOnClickListener {
            if (holder.thumb_up.getColorFilter().equals(ContextCompat.getColor(context, R.color.blue))) {
                holder.thumb_up.setColorFilter(ContextCompat.getColor(context, R.color.silver))
                holder.thumb_up_txt.setText(holder.thumb_up_txt.text.toString().toInt() - 1)
            } else {
                if (holder.thumb_down.getColorFilter().equals(
                        ContextCompat.getColor(
                            context,
                            R.color.red
                        )
                    )
                ) {
                    holder.thumb_down.setColorFilter(
                        ContextCompat.getColor(
                            context,
                            R.color.silver
                        )
                    )
                    holder.thumb_down_txt.setText(holder.thumb_down_txt.text.toString().toInt() - 1)
                }else{
                    holder.thumb_up.setColorFilter(ContextCompat.getColor(context, R.color.blue))
                    holder.thumb_up_txt.setText(holder.thumb_up_txt.text.toString().toInt() + 1)
                }
            }
        }

        holder.thumb_down.setOnClickListener {
            if (holder.thumb_down.colorFilter.equals(ContextCompat.getColor(context, R.color.red))) {
                holder.thumb_down.setColorFilter(ContextCompat.getColor(context, R.color.silver))
                holder.thumb_down_txt.setText(holder.thumb_down_txt.text.toString().toInt() - 1)
            } else {
                if (holder.thumb_up.colorFilter.equals(
                        ContextCompat.getColor(
                            context,
                            R.color.red
                        )
                    )
                ) {
                    holder.thumb_up.setColorFilter(
                        ContextCompat.getColor(
                            context,
                            R.color.silver
                        )
                    )
                    holder.thumb_up_txt.setText(holder.thumb_up_txt.text.toString().toInt() - 1)
                }else{
                    holder.thumb_down.setColorFilter(ContextCompat.getColor(context, R.color.red))
                    holder.thumb_down_txt.setText(holder.thumb_down_txt.text.toString().toInt() + 1)
                }
            }
        }

        popUpCommentDialog(holder.comment_Llayout)
        popUpCommentDialog(holder.comment_img)
        popUpCommentDialog(holder.comment_txt)

        holder.card_post.setOnClickListener{
            popUpMoreDialog(
                holder.card_post,
                holder.question.text.toString(),
                holder.answer.text.toString()
            )
        }
    }

    fun popUpMoreDialog(view: View, qn: String, ans: String) {
        view.setOnClickListener {

            lateinit var cLayout: ConstraintLayout

            val dialog = Dialog(context)
            val dm = context.resources.displayMetrics
            val width = dm.widthPixels
            val height = dm.heightPixels
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.view_more_layout)

            val question = dialog.findViewById<TextView>(R.id.question)
            val answer = dialog.findViewById<TextView>(R.id.answer)
            val cancel = dialog.findViewById<ImageView>(R.id.cancel)

            question.text = qn
            answer.text = ans

            cancel.setOnClickListener {
                dialog.cancel()
            }

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.attributes?.windowAnimations =
                R.style.DialogAnimation

            cLayout = dialog.findViewById(R.id.cLayout)
            cLayout.layoutParams.height = (0.85 * height).toInt()
            val lLayout_height = cLayout.layoutParams.height

            dialog.window!!.setLayout((width * .93).toInt(), lLayout_height)
            dialog.setCancelable(true)

            dialog.show()
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
            val cancel = dialog.findViewById<ImageView>(R.id.cancel)

            cancel.setOnClickListener {
                dialog.cancel()
            }

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
