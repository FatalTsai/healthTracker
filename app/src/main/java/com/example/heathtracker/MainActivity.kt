package com.example.heathtracker

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val wv =findViewById<WebView>(R.id.wv)
//        wv.loadData("<button class=\"btn draw-border\">Draw Border</button>","text/html", "UTF-8")


        val ctLayout : List<ConstraintLayout>  = listOf(findViewById(R.id.firstnav),findViewById(R.id.secondnav),findViewById(R.id.thirdnav),findViewById(R.id.fourthnav))
        val tvList  : List<TextView>  = listOf(findViewById(R.id.firsttv),findViewById(R.id.secondtv),findViewById(R.id.thirdtv),findViewById(R.id.fourthtv))
        val igList  : List<ImageView>  = listOf(findViewById(R.id.firstiv),findViewById(R.id.secondiv),findViewById(R.id.thirdiv),findViewById(R.id.fourthiv))


//            for(i in 0..3){
//
//                tvList[i]!!.setTextColor(R.color.gray);
//                igList[i]!!.setColorFilter(R.color.gray)
//            }


        fun initNav( i: Int){
            for(j in 0..3){
                if(j != i ) {

                    tvList[j].setTextColor(R.color.darkblue)
                    igList[j].setColorFilter(R.color.darkblue)
                }
            }
        }

        initNav(-1)
        for(i in 0..3) {
            ctLayout[i].setOnClickListener {
                Log.i("tag",i.toString()+" is touching")

                tvList[i].setTextColor(R.color.white);
                igList[i].setColorFilter(R.color.white)


//                var it = Intent(this,log::class.java)
//                startActivity(it);
//                overridePendingTransition(0,0);


                initNav(i)


            }


        }




    }

}


