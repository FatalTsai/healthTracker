package com.example.heathtracker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.MotionEventCompat
import com.example.myapplication.OnSwipeTouchListener

class Setting : AppCompatActivity() {
    private lateinit var constr: ConstraintLayout


//    override fun onTouchEvent(event: MotionEvent): Boolean {
//
//        val action: Int = MotionEventCompat.getActionMasked(event)
//
//        return when (action) {
//            MotionEvent.ACTION_DOWN -> {
//                Log.d("DEBUG_TAG", "Action was DOWN")
//                true
//            }
//            MotionEvent.ACTION_MOVE -> {
//                Log.d("DEBUG_TAG", "Action was MOVE")
//                true
//            }
//            MotionEvent.ACTION_UP -> {
//                Log.d("DEBUG_TAG", "Action was UP")
//                true
//            }
//            MotionEvent.ACTION_CANCEL -> {
//                Log.d("DEBUG_TAG", "Action was CANCEL")
//                true
//            }
//            MotionEvent.ACTION_OUTSIDE -> {
//                Log.d("DEBUG_TAG", "Movement occurred outside bounds of current screen element")
//                true
//            }
//            else -> super.onTouchEvent(event)
//        }
//    }

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)


        constr = findViewById(R.id.constr)
        constr.setOnTouchListener(object : OnSwipeTouchListener(this@Setting) {
            override fun onSwipeLeft() {
                super.onSwipeLeft()
                Toast.makeText(this@Setting, "Swipe Left gesture detected",
                    Toast.LENGTH_SHORT)
                    .show()
            }
            override fun onSwipeRight() {
                super.onSwipeRight()
                Toast.makeText(
                    this@Setting,
                    "Swipe Right gesture detected",
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onSwipeUp() {
                super.onSwipeUp()
                Toast.makeText(this@Setting, "Swipe up gesture detected", Toast.LENGTH_SHORT)
                    .show()
            }
            override fun onSwipeDown() {
                super.onSwipeDown()
                Toast.makeText(this@Setting, "Swipe down gesture detected", Toast.LENGTH_SHORT)
                    .show()
            }
        })




        val ctLayout: List<ConstraintLayout> = listOf(
            findViewById(R.id.firstnav),
            findViewById(R.id.secondnav),
            findViewById(R.id.thirdnav),
            findViewById(R.id.fourthnav)
        )
        val tvList: List<TextView> = listOf(
            findViewById(R.id.firsttv),
            findViewById(R.id.secondtv),
            findViewById(R.id.thirdtv),
            findViewById(R.id.fourthtv)
        )
        val igList: List<ImageView> = listOf(
            findViewById(R.id.firstiv),
            findViewById(R.id.secondiv),
            findViewById(R.id.thirdiv),
            findViewById(R.id.fourthiv)
        )
        val actList =
            listOf(Setting::class.java, log::class.java, assessment::class.java, trend::class.java)


        fun initNav(i: Int) {
            for (j in 0..3) {
                if (j != i) {

                    tvList[j].setTextColor(R.color.darkblue)
                    igList[j].setColorFilter(R.color.darkblue)
                }
            }
        }

        initNav(-1)
        tvList[0].setTextColor(R.color.white)
        igList[0].setColorFilter(R.color.white)

        for (i in 0..3) {
            ctLayout[i].setOnClickListener {
//                Log.i("tag",i.toString()+" is touching")

                Log.i("tag", "tag,${actList[i]}" + " is touching")

                var it = Intent(this, actList[i])
                startActivity(it);
                overridePendingTransition(0, 0);
                finish()

//                Log.i("tag","${log::class.java::class.qualifiedName}")    // "Int"

//                Log.i("tag","${log::class.java}")
//                Log.i("tag","${21}")

                tvList[i].setTextColor(R.color.white);
                igList[i].setColorFilter(R.color.white)

                initNav(i)


            }

        }
    }
}