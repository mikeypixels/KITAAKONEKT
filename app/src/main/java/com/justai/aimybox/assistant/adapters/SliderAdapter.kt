package com.justai.aimybox.assistant.adapters

import android.animation.ValueAnimator
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.justai.aimybox.assistant.MainActivity
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.fragments.DashboardFragment
import com.justai.aimybox.assistant.fragments.HivAndStiFragment
import com.justai.aimybox.assistant.fragments.KnowYourselfFragment
import com.justai.aimybox.assistant.fragments.RelationshipsFragment
import com.justai.aimybox.assistant.utils.AppUtils
import com.justai.aimybox.assistant.utils.findLocationOfCenterOnTheScreen
import com.justai.aimybox.assistant.utils.open


class SliderAdapter(val context: Context) : PagerAdapter() {

    var pageChecker = 0

    companion object {
        lateinit var v_btn: CardView
    }

    lateinit var sharedImageView: ImageView

    var slide_images = arrayOf(
        R.drawable.manwoman1,
        R.drawable.relationship3,
        R.drawable.family3,
        R.drawable.stds
    )

    var slide_headings = arrayOf("Jifahamu Mwenyewe", "Mahusiano", "Uzazi wa Mpango", "VVU na Maambukizi ya Zinaa")

    var slide_desc = arrayOf(
        context.getString(R.string.know_yourself),
        context.getString(R.string.relationship),
        context.getString(R.string.family_planning),
        context.getString(R.string.hiv_and_stis)
    )

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as FrameLayout
    }

    override fun getCount(): Int {
        return slide_headings.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflator: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View

        if (MainActivity.screenData < 5) {
            view = layoutInflator.inflate(R.layout.slide_layout_below_normal, container, false)
        } else {
            view = layoutInflator.inflate(R.layout.slide_layout, container, false)
        }

        val slideImageView: ImageView = view.findViewById(R.id.imageView)
        val slideHeading: TextView = view.findViewById(R.id.heading)
        val slideDescription: TextView = view.findViewById(R.id.desc)
        val view_btn: CardView = view.findViewById(R.id.view_btn)

        System.out.println("This is in the SliderAdapter method")

//        v_btn = view_btn

        if (pageChecker == 0) {
            val animation_imageView: Animation = AnimationUtils.loadAnimation(
                context,
                R.anim.scaling_alpha
            )
            slideImageView.startAnimation(animation_imageView)
            val animation_heading: Animation = AnimationUtils.loadAnimation(
                context,
                R.anim.down_to_up_fade
            )
            slideHeading.startAnimation(animation_heading)
            val animation_desc: Animation = AnimationUtils.loadAnimation(
                context,
                R.anim.down_to_up_fade
            )
            slideDescription.startAnimation(animation_desc)
            val animation_btn: Animation = AnimationUtils.loadAnimation(
                context,
                R.anim.btn_down_to_up_fade
            )
            view_btn.startAnimation(animation_btn)
        }

        pageChecker = 1

        slideImageView.setImageResource(slide_images[position])
        slideHeading.setText(slide_headings[position])
        slideDescription.setText(slide_desc[position])
        view_btn.background = context.resources.getDrawable(R.drawable.button_bg)

//        view_btn.visibility = View.INVISIBLE

        val marginLayoutParams: ViewGroup.MarginLayoutParams = slideImageView.layoutParams as ViewGroup.MarginLayoutParams

        System.out.println("This is the layout margin top of image before: " + marginLayoutParams.topMargin)

        DashboardFragment.bsb.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                if(slideOffset >= 0.0){
                    slideImageView.scaleX = 1F - 0.25F*slideOffset
                    slideImageView.scaleY = 1F - 0.25F*slideOffset
                    slideHeading.scaleX = 1F - 0.2F*slideOffset
                    slideHeading.scaleY = 1F - 0.2F*slideOffset
                    slideDescription.scaleX = 1F - 0.2F*slideOffset
                    slideDescription.scaleY = 1F - 0.2F*slideOffset
                    view_btn.scaleX = 1F - 0.2F*slideOffset
                    view_btn.scaleY = 1F - 0.2F*slideOffset
                }
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {

            }

        })

//        val anim: ValueAnimator =
//            ValueAnimator.ofInt(viewToIncreaseHeight.getMeasuredHeight(), -100)
//        anim.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener {
//            override fun onAnimationUpdate(valueAnimator: ValueAnimator) {
//                val `val` = valueAnimator.getAnimatedValue() as Int
//                val layoutParams: ViewGroup.LayoutParams = viewToIncreaseHeight.getLayoutParams()
//                layoutParams.height = `val`
//                viewToIncreaseHeight.setLayoutParams(layoutParams)
//            }
//        })
//        anim.setDuration(300)
//        anim.start()

        view_btn.setOnClickListener {
//            presentActivity(view_btn)

            val positions: IntArray = it.findLocationOfCenterOnTheScreen()

//            fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
//                val fragmentTransaction = beginTransaction()
//                fragmentTransaction.func()
//                fragmentTransaction.commit()
//            }

            if(position == 0){
                (context as AppCompatActivity).supportFragmentManager.open {
                    add(R.id.container_layout, KnowYourselfFragment.newInstance(positions)).addToBackStack(null)
                }
            }else if(position == 1){

//                sharedImageView = slideImageView
//                (context as AppCompatActivity).supportFragmentManager.beginTransaction()
//                    .add(R.id.container_layout, RelationshipsFragment.newInstance(positions)).addToBackStack(null)
//                    .addSharedElement(sharedImageView, sharedImageView.transitionName)
//                    .commitAllowingStateLoss()
//
//                sharedImageView = ImageView(context)
                (context as AppCompatActivity).supportFragmentManager.open {
                    add(R.id.container_layout, RelationshipsFragment.newInstance(positions)).addToBackStack(null)
                }
            }else if(position == 2){
                (context as AppCompatActivity).supportFragmentManager.open {
                    add(R.id.container_layout, KnowYourselfFragment.newInstance(positions)).addToBackStack(null)
                }
            }else{
                (context as AppCompatActivity).supportFragmentManager.open {
                    add(R.id.container_layout, HivAndStiFragment.newInstance(positions)).addToBackStack(null)
                }
            }

        }

        container.addView(view)

        return view
    }



//    public fun presentActivity(view: View) {
//        val options =
//            ActivityOptionsCompat.makeSceneTransitionAnimation(context as MainActivity, view, "transition")
//        val revealX = (view.x + view.width / 2).toInt()
//        val revealY = (view.y + view.height / 2).toInt()
//        val intent = Intent(context, KnowYourself::class.java)
//        intent.putExtra(KnowYourself.EXTRA_CIRCULAR_REVEAL_X, revealX)
//        intent.putExtra(KnowYourself.EXTRA_CIRCULAR_REVEAL_Y, revealY)
//        ActivityCompat.startActivity(context, intent, options.toBundle())
//    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as FrameLayout)
    }
}
