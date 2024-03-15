package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private var textViewOne: TextView? = null
    private var textViewTwo: TextView? = null


    private lateinit var handler: Handler
    private lateinit var handlerOne: Handler

    private lateinit var runnable: Runnable
    private lateinit var runnableOne: Runnable

    private var counter = 1
    private var counterOne = 1


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewOne = findViewById(R.id.tv_TimerOne)
        textViewTwo = findViewById(R.id.tv_TimerTwo)

        handler = Handler(Looper.getMainLooper())
        handlerOne = Handler(Looper.getMainLooper())

        runnable = object : Runnable {
            override fun run() {
                runOnUiThread {
                    if (counter <= 100) {
                        textViewOne?.text = " $counter"
                        counter++
                    } else {
                        counter = 1
                        textViewOne?.text = " $counter"

                    }
                    handler.postDelayed(this, 1000) // 1000 milliseconds = 1 second
                }
            }

        }
        handler.post(runnable)




        runnableOne = object : Runnable {
            override fun run() {
                runOnUiThread {
                    if (counterOne <= 100) {
                        textViewTwo?.text = " $counterOne"
                        counterOne++
                    } else {
                        counterOne = 1
                        textViewTwo?.text = " $counterOne"

                    }
                    handlerOne.postDelayed(this, 1500) // 1500L milliseconds = 1.5 second
                }
            }
        }

        handlerOne.post(runnableOne)


    }


    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
        handlerOne.removeCallbacks(runnableOne)
    }

}