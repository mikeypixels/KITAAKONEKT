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
import com.justai.aimybox.assistant.YourQuestion


class YourQAdapter(context: Context, yourQuestion: ArrayList<YourQuestion>) : RecyclerView.Adapter<YourQAdapter.ViewHolder>() {

    var context: Context
    var yourQuestion = ArrayList<YourQuestion>()

    init {
        this.context = context
        this.yourQuestion = yourQuestion
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var user_name: TextView
        var question: TextView
        var answer: TextView
        var duration: TextView
        var ans_no: TextView
        var view_more: TextView
        var card_post: CardView
        var comment_Llayout: LinearLayout
        var comment_txt: TextView
        var comment_img: ImageView

        init {
            user_name = itemView.findViewById(R.id.user_name)
            question = itemView.findViewById(R.id.question)
            answer = itemView.findViewById(R.id.answer)
            duration = itemView.findViewById(R.id.duration)
            ans_no = itemView.findViewById(R.id.ans_no)
            view_more = itemView.findViewById(R.id.view_more)
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
        return yourQuestion.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.user_name.setText(yourQuestion.get(position).username + " aliuliza")
        holder.question.setText(yourQuestion.get(position).question)
        holder.answer.setText(yourQuestion.get(position).answer)
        holder.duration.setText(yourQuestion.get(position).duration)
        holder.ans_no.setText(yourQuestion.get(position).ans_no)
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

        if(holder.answer.text.equals("")){
            holder.answer.visibility = View.GONE
        }

        if (position % 1 == 0 || position % 2 == 0 || position % 3 == 0 || position % 4 == 0 || position % 5 == 0 || position % 6 == 0 || position % 7 == 0 || position % 8 == 0 || position % 9 == 0 || position % 3 == 0) {
            holder.user_name.setText(yourQuestion.get(position).username + " uliuliza")
            holder.question.setText(yourQuestion.get(position).question)
            holder.answer.setText(yourQuestion.get(position).answer)
            holder.duration.setText(yourQuestion.get(position).duration)
            holder.ans_no.setText(yourQuestion.get(position).ans_no)
            holder.card_post.cardElevation = 8F
        }

        popUpCommentDialog(holder.comment_Llayout)
        popUpCommentDialog(holder.comment_img)
        popUpCommentDialog(holder.comment_txt)

        holder.card_post.setOnClickListener {
            if(holder.answer.text.equals("")){
                popUpMoreDialog(holder.card_post, holder.question.text.toString(), "Hili swali bado halijajibiwa!")
            }else{
                popUpMoreDialog(holder.card_post, holder.question.text.toString(), holder.answer.text.toString())
            }
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