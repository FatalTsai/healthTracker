package com.example.heathtracker

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.MotionEventCompat
import com.example.myapplication.OnSwipeTouchListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Setting : AppCompatActivity() {
    private lateinit var constr: ConstraintLayout
    private companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    private lateinit var auth: FirebaseAuth


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.miLogout) {
            Log.i(TAG, "Logout")
            auth.signOut()
            val logoutIntent = Intent(this, Login::class.java)
            logoutIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(logoutIntent)}
//        } else if (item.itemId == R.id.miEdit) {
//            showAlertDialog()
//        }
        return super.onOptionsItemSelected(item)
    }


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
        auth = Firebase.auth




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

        val etHeight : EditText = findViewById(R.id.etHeight)
        val etWeight : EditText = findViewById(R.id.etweight)
        val rbMale : RadioButton =findViewById(R.id.rbMale)
        val rgroup : RadioGroup =findViewById(R.id.rgroup)

         fun readData() {
             val mPrefs = getPreferences(MODE_PRIVATE)
             val info : TextView = findViewById(R.id.info)
             var msg = ""
             msg += "height : "+mPrefs.getString("height","")+"\n"
             msg += "weight : "+mPrefs.getString("weight","")+"\n"
             msg += "sex : "+mPrefs.getString("sex","")+"\n"

             info.text = msg

         }
        readData()
        val button : Button = findViewById(R.id.button)
//        val sexstr = rbMale.isChecked() ? "M":"F"
        button.setOnClickListener(View.OnClickListener {
            val mPrefs = getPreferences(MODE_PRIVATE)
            mPrefs.edit()
                .putString("height", etHeight.text.toString())
                .putString("weight", etWeight.text.toString())
                .putString("sex", if (rbMale.isChecked() ) "Male" else "Female")
                .apply()
            readData()
        })



        constr = findViewById(R.id.constr)
        constr.setOnTouchListener(object : OnSwipeTouchListener(this@Setting) {
            @SuppressLint("ClickableViewAccessibility")
            override fun onSwipeLeft() {
                super.onSwipeLeft()


                Log.i("tag", "tag,${actList[3]}" + " is touching")

                var it = Intent(this@Setting, actList[3])
                startActivity(it);
//                overridePendingTransition(0, 0);
                overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
                finish()


//                Log.i("tag","${log::class.java::class.qualifiedName}")    // "Int"

//                Log.i("tag","${log::class.java}")
//                Log.i("tag","${21}")

                tvList[3].setTextColor(R.color.white);
                igList[3].setColorFilter(R.color.white)

                initNav(3)

//
//                Toast.makeText(this@Setting, "Swipe Left gesture detected",
//                    Toast.LENGTH_SHORT)
//                    .show()
            }
            override fun onSwipeRight() {
                super.onSwipeRight()


                Log.i("tag", "tag,${actList[1]}" + " is touching")

                var it = Intent(this@Setting, actList[1])
                startActivity(it);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish()

//                Log.i("tag","${log::class.java::class.qualifiedName}")    // "Int"

//                Log.i("tag","${log::class.java}")
//                Log.i("tag","${21}")

                tvList[1].setTextColor(R.color.white);
                igList[1].setColorFilter(R.color.white)

                initNav(1)


//                Toast.makeText(
//                    this@Setting,
//                    "Swipe Right gesture detected",
//                    Toast.LENGTH_SHORT
//                ).show()
            }
            override fun onSwipeUp() {
                super.onSwipeUp()
//                Toast.makeText(this@Setting, "Swipe up gesture detected", Toast.LENGTH_SHORT)
//                    .show()
            }
            override fun onSwipeDown() {
                super.onSwipeDown()
//                Toast.makeText(this@Setting, "Swipe down gesture detected", Toast.LENGTH_SHORT)
//                    .show()
            }
        })



    }

    override fun onPause() {
        super.onPause()
        val mPrefs = getPreferences(MODE_PRIVATE)
        val prefsEditor: SharedPreferences.Editor = mPrefs.edit()


    }
}