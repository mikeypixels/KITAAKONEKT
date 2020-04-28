package com.justai.aimybox.assistant.fragments

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.util.DisplayMetrics
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.alpha
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.card.MaterialCardView
import com.hanks.htextview.rainbow.RainbowTextView
import com.justai.aimybox.assistant.DispatchTouchEvent
import com.justai.aimybox.assistant.MainActivity
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.TopQFragment
import com.justai.aimybox.assistant.activities.ForumActivity
import com.justai.aimybox.assistant.adapters.SliderAdapter
import com.justai.aimybox.assistant.utils.findLocationOfCenterOnTheScreen
import com.justai.aimybox.assistant.utils.open

/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : Fragment(), DispatchTouchEvent.onDispatchEvent {

    lateinit var bottomSheet: View
    lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    lateinit var linearContainer: LinearLayout
    lateinit var constraint_layout: ConstraintLayout

    lateinit var coordinator: CoordinatorLayout
    lateinit var rDimLayout: View

    lateinit var fullname: EditText
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var conf_password: EditText

//    lateinit var animation_quiz: Animation
    lateinit var animation_fact: Animation
//    lateinit var animation_stories: Animation
    lateinit var animation_help: Animation
    lateinit var animation_topq: Animation
    lateinit var animation_forum: Animation

    var bsChecker = 0

    var txt_swipeup_checker = 0

    lateinit var dotsLayout: LinearLayout

    lateinit var dots: Array<TextView>

    companion object {
        //        var screenData: Double = 0.0
        lateinit var bsb: BottomSheetBehavior<View>
        lateinit var bs: View
        var statusbarHeight = 0

        @JvmStatic
        fun newInstance(): DashboardFragment = DashboardFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val top_layout = view.findViewById<RelativeLayout>(R.id.top_layout)

        statusbarHeight = getStatusBarHeight()
//        val rectangle = Rect()
//        val window: Window = (context as Activity).getWindow()
//        window.getDecorView().getWindowVisibleDisplayFrame(rectangle)
//        val statusBarHeight: Int = rectangle.top
//        val contentViewTop: Int = window.findViewById(Window.ID_ANDROID_CONTENT).getTop()
//        val titleBarHeight = contentViewTop - statusBarHeight

//        animation_quiz =
//            AnimationUtils.loadAnimation(
//                context,
//                R.anim.quiz_card_anim
//            )
        animation_fact =
            AnimationUtils.loadAnimation(
                context,
                R.anim.fact_card_anim
            )
//        animation_stories =
//            AnimationUtils.loadAnimation(
//                context,
//                R.anim.stories_card_anim
//            )
        animation_help =
            AnimationUtils.loadAnimation(
                context,
                R.anim.help_card_anim
            )
        animation_topq =
            AnimationUtils.loadAnimation(
                context,
                R.anim.topq_card_anim
            )
        animation_forum =
            AnimationUtils.loadAnimation(
                context,
                R.anim.forum_card_anim
            )

//        val dm = DisplayMetrics()
//        (context as Activity).getWindowManager().getDefaultDisplay().getMetrics(dm)
//        val width = dm.widthPixels
//        val height = dm.heightPixels

        val slideViewPager = view.findViewById<ViewPager>(R.id.slideViewPager)
        dotsLayout = view.findViewById(R.id.dotsLayout)
        val imageView: ImageView = view.findViewById(R.id.expand_image)

        val sliderAdapter: SliderAdapter? =
            context?.let { SliderAdapter(it) }

        slideViewPager.adapter = sliderAdapter

//        btn = SliderAdapter.v_btn

        addDotsIndicator(0)
        dots[0].scaleX = 1.2F
        dots[0].scaleY = 1.2F

        System.out.println("This is in the onCreateView method")

        slideViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                addDotsIndicator(position)
                dots[position].scaleX = 1.2F
                dots[position].scaleY = 1.2F
            }

        })

        coordinator = view.findViewById(R.id.coordinator_layout)
        constraint_layout = view.findViewById(R.id.constraint_layout)
        rDimLayout = view.findViewById(R.id.relative_dim_screen)

        linearContainer = view.findViewById(R.id.linear_container)
        val swipe_txt = view.findViewById<RainbowTextView>(R.id.swipe_txt)
//        val quiz_card = view.findViewById<CardView>(R.id.quiz_card)
        val fact_card = view.findViewById<CardView>(R.id.fact_card)
//        val stories_card = view.findViewById<CardView>(R.id.stories_card)
        val help_card = view.findViewById<CardView>(R.id.help_card)
        val topQ_card = view.findViewById<CardView>(R.id.topQ_card)
        val forum_card = view.findViewById<CardView>(R.id.forum_card)

        swipe_txt.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

            if(txt_swipeup_checker == 0){
//                quiz_card.startAnimation(animation_quiz)
                fact_card.startAnimation(animation_fact)
//                stories_card.startAnimation(animation_stories)
                help_card.startAnimation(animation_help)
                topQ_card.startAnimation(animation_topq)
                forum_card.startAnimation(animation_forum)

                txt_swipeup_checker = 1
            }

//            quiz_card.visibility = View.VISIBLE
            fact_card.visibility = View.VISIBLE
//            stories_card.visibility = View.VISIBLE
            help_card.visibility = View.VISIBLE
            topQ_card.visibility = View.VISIBLE
            forum_card.visibility = View.VISIBLE
        }

//        val blurView: BlurView = findViewById(R.id.blurView)
        coordinator.setBackgroundColor(Color.parseColor("#ffffff"))
//        quiz_card.background = getDrawable(R.drawable.card_round_bg)
//        fact_card.background = getDrawable(R.drawable.card_round_bg)
//        stories_card.background = getDrawable(R.drawable.card_round_bg)
//        help_card.background = getDrawable(R.drawable.card_round_bg)
//        topQ_card.background = getDrawable(R.drawable.card_round_bg)
//        forum_card.background = getDrawable(R.drawable.card_round_bg)

        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)

        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels

        bottomSheet = view.findViewById(R.id.bottom_sheet)

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheet.layoutParams.height = (0.53 * height).toInt()
//        bottomSheet.layoutParams.height = (0.5 * height).toInt()
//        constraint_layout.layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT

        bsb = bottomSheetBehavior
        bs = bottomSheet

        rDimLayout.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        imageView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

//                quiz_card.startAnimation(animation_quiz)
                fact_card.startAnimation(animation_fact)
//                stories_card.startAnimation(animation_stories)
                help_card.startAnimation(animation_help)
                topQ_card.startAnimation(animation_topq)
                forum_card.startAnimation(animation_forum)

//                quiz_card.visibility = View.VISIBLE
                fact_card.visibility = View.VISIBLE
//                stories_card.visibility = View.VISIBLE
                help_card.visibility = View.VISIBLE
                topQ_card.visibility = View.VISIBLE
                forum_card.visibility = View.VISIBLE

            }
        })

        lateinit var back_arrow: ImageView
        var arrow_check = 0

        var forumChecker = 0

        fact_card.setOnClickListener {
            val positions: IntArray = it.findLocationOfCenterOnTheScreen()

            (context as AppCompatActivity).supportFragmentManager.open {
                add(R.id.container_layout, FactsFragment.newInstance(positions)).addToBackStack(null)
            }
        }

        help_card.setOnClickListener {

            val positions: IntArray = it.findLocationOfCenterOnTheScreen()

            (context as AppCompatActivity).supportFragmentManager.open {
                add(R.id.container_layout, HelpCentersFragment.newInstance(positions)).addToBackStack(null)
            }
        }

        topQ_card.setOnClickListener {
            val positions: IntArray = it.findLocationOfCenterOnTheScreen()

            (context as AppCompatActivity).supportFragmentManager.open {
                add(R.id.container_layout, TopQFragment.newInstance(positions)).addToBackStack(null)
            }
        }

        forum_card.setOnClickListener { 
            val intent = Intent(context, ForumActivity::class.java)
            startActivity(intent)
        }

//        forum_card.setOnClickListener {
//
////            val animation =
////                ObjectAnimator.ofFloat(forum_card, "rotationY", 0.0f, 360f)
////            animation.duration = 800
//////            animation.repeatCount = ObjectAnimator.INFINITE
////            animation.interpolator = AccelerateDecelerateInterpolator()
////            animation.start()
//
//            if (forumChecker == 0) {
//
//                arrow_check = 1
//
//                val reg_cLayout = ConstraintLayout(context)
//                reg_cLayout.layoutParams = ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT
//                )
//                reg_cLayout.layoutParams.height = bottomSheet.layoutParams.height - 90
//
//                val quiz_exit_anim: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.quiz_right_to_left
//                    )
//                val fact_exit_anim: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.fact_right_to_left
//                    )
//                val stories_exit_anim: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.stories_right_to_left
//                    )
//                val help_exit_anim: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.help_right_to_left
//                    )
//                val topq_exit_anim: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.topq_right_to_left
//                    )
//                val forum_exit_anim: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.forum_right_to_left
//                    )
//
////                quiz_card.startAnimation(quiz_exit_anim)
//                fact_card.startAnimation(fact_exit_anim)
////                stories_card.startAnimation(stories_exit_anim)
//                help_card.startAnimation(help_exit_anim)
//                topQ_card.startAnimation(topq_exit_anim)
//                forum_card.startAnimation(forum_exit_anim)
//
////                quiz_card.visibility = View.INVISIBLE
//                fact_card.visibility = View.INVISIBLE
////                stories_card.visibility = View.INVISIBLE
//                help_card.visibility = View.INVISIBLE
//                topQ_card.visibility = View.INVISIBLE
//                forum_card.visibility = View.INVISIBLE
//
//                val view_reg: View =
//                    LayoutInflater.from(context).inflate(R.layout.forum_registration_layout, null)
//                val f_name_card: MaterialCardView = view_reg.findViewById(R.id.full_name_card)
//                val user_name_card: MaterialCardView = view_reg.findViewById(R.id.user_name_card)
//                val pass_card: MaterialCardView = view_reg.findViewById(R.id.pass_card)
//                val conf_pass_card: MaterialCardView = view_reg.findViewById(R.id.conf_pass_card)
//                val card_btn: MaterialCardView = view_reg.findViewById(R.id.card_btn)
//                fullname = view_reg.findViewById(R.id.fullname)
//                username = view_reg.findViewById(R.id.username)
//                password = view_reg.findViewById(R.id.password)
//                conf_password = view_reg.findViewById(R.id.conf_password)
//                val reg_head: TextView = view_reg.findViewById(R.id.reg_head)
//                val reg_head_below: TextView = view_reg.findViewById(R.id.reg_head_below)
//                val login_txt1: TextView = view_reg.findViewById(R.id.login_txt1)
//                val login_txt2: TextView = view_reg.findViewById(R.id.login_txt2)
//                back_arrow = view_reg.findViewById(R.id.back_arrow)
//
//                onFocusedEditText(fullname, f_name_card, user_name_card, pass_card, conf_pass_card)
//                onFocusedEditText(username, user_name_card, f_name_card, pass_card, conf_pass_card)
//                onFocusedEditText(password, pass_card, user_name_card, f_name_card, conf_pass_card)
//                onFocusedEditText(
//                    conf_password,
//                    conf_pass_card,
//                    user_name_card,
//                    pass_card,
//                    f_name_card
//                )
//
//                card_btn.setOnClickListener {
//                    val intent = Intent(context, ForumActivity::class.java)
//                    startActivity(intent)
////                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
//                }
//
//                val animation_fullname: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.right_to_left
//                    )
//                val animation_username: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.right_to_left_username
//                    )
//                val animation_password: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.right_to_left_password
//                    )
//                val animation_conf_password: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.right_to_left_conf_pass
//                    )
//
////            val objectAnimator: ObjectAnimator =
////                AnimatorInflator.loadAnimator(this, R.animator.objectanimator) as ObjectAnimator
////            objectAnimator.setTarget(card_btn)
////            objectAnimator.start()
//
//                val animation_reg_head: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.up_to_down_fade
//                    )
//                val animation_back_arrow: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.fade_in
//                    )
//                val animation_login_txt: Animation =
//                    AnimationUtils.loadAnimation(
//                        context,
//                        R.anim.quiz_card_anim
//                    )
//
//                f_name_card.startAnimation(animation_fullname)
//                user_name_card.startAnimation(animation_username)
//                pass_card.startAnimation(animation_password)
//                conf_pass_card.startAnimation(animation_conf_password)
////            card_btn.startAnimation(animation_btn)
//                val buttonAnimator =
//                    ObjectAnimator.ofFloat(card_btn, "translationX", -1000f, -400f)
//                buttonAnimator.duration = 2200
//                buttonAnimator.interpolator = BounceInterpolator()
//                buttonAnimator.start()
//                reg_head.startAnimation(animation_reg_head)
//                reg_head_below.startAnimation(animation_reg_head)
//                login_txt1.startAnimation(animation_login_txt)
//                login_txt2.startAnimation(animation_login_txt)
//                back_arrow.startAnimation(animation_back_arrow)
//
//
//
//                back_arrow.setOnClickListener {
//
////                val buttonAnimatorQuiz =
////                    ObjectAnimator.ofFloat(quiz_card, "translationX", -400f, 0f)
////                buttonAnimatorQuiz.duration = 1000
////                buttonAnimatorQuiz.startDelay = 150
////                buttonAnimatorQuiz.interpolator = BounceInterpolator()
////                buttonAnimatorQuiz.start()
////
////                val buttonAnimatorFact =
////                    ObjectAnimator.ofFloat(fact_card, "translationX", -400f, 0f)
////                buttonAnimatorFact.duration = 1000
////                buttonAnimatorFact.startDelay = 50
////                buttonAnimatorFact.interpolator = BounceInterpolator()
////                buttonAnimatorFact.start()
////
////                val buttonAnimatorStories =
////                    ObjectAnimator.ofFloat(stories_card, "translationX", -400f, 0f)
////                buttonAnimatorStories.duration = 1000
////                buttonAnimatorStories.startDelay = 350
////                buttonAnimatorStories.interpolator = BounceInterpolator()
////                buttonAnimatorStories.start()
////
////                val buttonAnimatorHelp =
////                    ObjectAnimator.ofFloat(help_card, "translationX", -400f, 0f)
////                buttonAnimatorHelp.duration = 1000
////                buttonAnimatorHelp.startDelay = 250
////                buttonAnimatorHelp.interpolator = BounceInterpolator()
////                buttonAnimatorHelp.start()
////
////                val buttonAnimatorTopQ =
////                    ObjectAnimator.ofFloat(topQ_card, "translationX", -400f, 0f)
////                buttonAnimatorTopQ.duration = 1000
////                buttonAnimatorTopQ.startDelay = 550
////                buttonAnimatorTopQ.interpolator = BounceInterpolator()
////                buttonAnimatorTopQ.start()
////
////                val buttonAnimatorForum =
////                    ObjectAnimator.ofFloat(forum_card, "translationX", -400f, 0f)
////                buttonAnimatorForum.duration = 1000
////                buttonAnimatorForum.startDelay = 450
////                buttonAnimatorForum.interpolator = BounceInterpolator()
////                buttonAnimatorForum.start()
//
//                    linearContainer.removeView(reg_cLayout)
//                    linearContainer.addView(constraint_layout)
//
////                    quiz_card.visibility = View.VISIBLE
//                    fact_card.visibility = View.VISIBLE
////                    stories_card.visibility = View.VISIBLE
//                    help_card.visibility = View.VISIBLE
//                    topQ_card.visibility = View.VISIBLE
//                    forum_card.visibility = View.VISIBLE
//
//                    forumChecker = 0
//                }
//
////            quiz_card.layoutParams = initial_quiz
////            fact_card.layoutParams = initial_fact
////            stories_card.layoutParams = initial_stories
////            help_card.layoutParams = initial_help
////            topQ_card.layoutParams = initial_topq
////            forum_card.layoutParams = initial_forum
//
//                reg_cLayout.addView(view_reg)
//
//                Handler().run {
//
//                    postDelayed({
//                        linearContainer.removeView(constraint_layout)
//                        linearContainer.addView(reg_cLayout)
//                    }, 1000)
//                }
//            }
//
//            forumChecker = 1
//        }
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

                swipe_txt.colorSpeed = 2.5F

                rDimLayout.visibility = View.VISIBLE
//                top_layout.visibility = View.VISIBLE
                rDimLayout.alpha = slideOffset
//                top_layout.alpha = slideOffset
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {

                var checker = 0

                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {

                        swipe_txt.text = "Vuta juu..."
                        swipe_txt.colorSpeed = 2.5F

//                        val animationOut: Animation =
//                            AnimationUtils.loadAnimation(
//                                context,
//                                R.anim.fadeout
//                            )
//                        rDimLayout.startAnimation(animationOut)

//                        quiz_card.visibility = View.GONE
                        fact_card.visibility = View.GONE
//                        stories_card.visibility = View.GONE
                        help_card.visibility = View.GONE
                        topQ_card.visibility = View.GONE
                        forum_card.visibility = View.GONE

                        bsChecker = 0

                        if (arrow_check == 1) {
                            back_arrow.visibility = View.INVISIBLE
                        }

                        rDimLayout.visibility = View.GONE

//                        (context as Activity).getWindow().setStatusBarColor(ContextCompat.getColor(
//                            context as Activity, R.color.white))
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {

                        swipe_txt.text = "Vuta chini..."
                        swipe_txt.colorSpeed = 2.5F

                        rDimLayout.visibility = View.VISIBLE

//                        (context as Activity).getWindow().setStatusBarColor(ContextCompat.getColor(
//                            context as Activity, R.color.dim_light)) // set status background white

                        txt_swipeup_checker = 1

//                        if(checker == 1) {
//
//                            quiz_card.startAnimation(animation_quiz)
//                            fact_card.startAnimation(animation_fact)
//                            stories_card.startAnimation(animation_stories)
//                            help_card.startAnimation(animation_help)
//                            topQ_card.startAnimation(animation_topq)
//                            forum_card.startAnimation(animation_forum)
//
//                            quiz_card.visibility = View.VISIBLE
//                            fact_card.visibility = View.VISIBLE
//                            stories_card.visibility = View.VISIBLE
//                            help_card.visibility = View.VISIBLE
//                            topQ_card.visibility = View.VISIBLE
//                            forum_card.visibility = View.VISIBLE
//
//                            Toast.makeText(context, "It gets here and checker is: " + checker, Toast.LENGTH_SHORT).show()
//
//                            checker = 0
//
//                        }

                        if (arrow_check == 1) {
                            back_arrow.visibility = View.VISIBLE
                        }

                        bsChecker = 1
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {

                        swipe_txt.text = "Inavutwa..."
                        swipe_txt.colorSpeed = 2.5F

                        if (bsChecker == 0) {

                            val animationIn: Animation =
                                AnimationUtils.loadAnimation(
                                    context,
                                    R.anim.fadein
                                )
                            rDimLayout.startAnimation(animationIn)

                            rDimLayout.visibility = View.VISIBLE
                            if (arrow_check == 1) {
                                back_arrow.visibility = View.VISIBLE
                            }

//                            quiz_card.startAnimation(animation_quiz)
                            fact_card.startAnimation(animation_fact)
//                            stories_card.startAnimation(animation_stories)
                            help_card.startAnimation(animation_help)
                            topQ_card.startAnimation(animation_topq)
                            forum_card.startAnimation(animation_forum)

//                            quiz_card.visibility = View.VISIBLE
                            fact_card.visibility = View.VISIBLE
//                            stories_card.visibility = View.VISIBLE
                            help_card.visibility = View.VISIBLE
                            topQ_card.visibility = View.VISIBLE
                            forum_card.visibility = View.VISIBLE
                        }

//                        animation_quiz.cancel()
                        animation_fact.cancel()
//                        animation_stories.cancel()
                        animation_help.cancel()
                        animation_topq.cancel()
                        animation_forum.cancel()

                        bsChecker = 1
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {

                        swipe_txt.text = "Vuta juu..."
                        swipe_txt.colorSpeed = 2.5F

                        rDimLayout.visibility = View.GONE
                        if (arrow_check == 1) {
                            back_arrow.visibility = View.VISIBLE
                        }

                        val animationOut: Animation =
                            AnimationUtils.loadAnimation(
                                context,
                                R.anim.fadeout
                            )
                        rDimLayout.startAnimation(animationOut)

//                        (context as Activity).getWindow().setStatusBarColor(ContextCompat.getColor(
//                            context as Activity, R.color.white))

//                        quiz_card.visibility = View.GONE
                        fact_card.visibility = View.GONE
//                        stories_card.visibility = View.GONE
                        help_card.visibility = View.GONE
                        topQ_card.visibility = View.GONE
                        forum_card.visibility = View.GONE

                        checker = 1

                        bsChecker = 0
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {

                        swipe_txt.text = "Inatulia..."
                        swipe_txt.colorSpeed = 2.5F
                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {

                    }
                }
            }

        })

        return view
    }

    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

//    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
//        if (event.action == MotionEvent.ACTION_DOWN) {
//            if (bottomSheetBehavior.getState() === BottomSheetBehavior.STATE_EXPANDED) {
//                val outRect = Rect()
//                bottomSheet.getGlobalVisibleRect(outRect)
//                if (!outRect.contains(
//                        event.rawX.toInt(),
//                        event.rawY.toInt()
//                    )
//                ) bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
//            }
//        }
//        return super.dispatchTouchEvent(event)
//    }

    fun onFocusedEditText(
        focEditText: EditText,
        focEditTextCard: MaterialCardView,
        editText1Card: MaterialCardView,
        editText2Card: MaterialCardView,
        editText3Card: MaterialCardView
    ) {
        focEditText.setOnFocusChangeListener { v, hasFocus ->
            focEditTextCard.setStrokeColor(Color.BLUE)
            focEditTextCard.scaleY = 1.05f
            focEditTextCard.scaleX = 1.05f
            focEditText.setPadding(35, 0, 35, 0)
            editText1Card.setStrokeColor(Color.WHITE)
            editText1Card.scaleX = 1f
            editText1Card.scaleY = 1f
            editText2Card.setStrokeColor(Color.WHITE)
            editText2Card.scaleX = 1f
            editText2Card.scaleY = 1f
            editText3Card.setStrokeColor(Color.WHITE)
            editText3Card.scaleX = 1f
            editText3Card.scaleY = 1f
        }
    }

    fun addDotsIndicator(pos: Int) {
        dots = arrayOfNulls<TextView>(4) as Array<TextView>
        dotsLayout.removeAllViews()

        for (i in 0 until 4) {
            dots[i] = TextView(context)
            dots[i].text = Html.fromHtml("&#8226;")
            dots[i].textSize = 35F
            dots[i].setTextColor(resources.getColor(R.color.TransparentWhite))

            dotsLayout.addView(dots[i])
        }

        if (dots.size > 0) {
            dots[pos].setTextColor(resources.getColor(R.color.primary))
        }
    }

    override fun dispatchEvent(e: MotionEvent?) {
        if (e != null) {
            if (e.getAction() == MotionEvent.ACTION_DOWN) {
                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {

                    val outRect = Rect()
                    bottomSheet.getGlobalVisibleRect(outRect);

                    if (!outRect.contains(
                            e.getRawX().toInt(),
                            e.getRawY().toInt()
                        )
                    ) bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
                }
            }
        }

    }
}


