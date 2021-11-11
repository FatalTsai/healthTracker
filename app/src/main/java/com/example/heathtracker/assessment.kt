package com.example.heathtracker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class assessment : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assessment)

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
        tvList[2].setTextColor(R.color.white)
        igList[2].setColorFilter(R.color.white)

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