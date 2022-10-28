package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //固定變數與畫面元件
        val tvRiddle = findViewById<TextView>(R.id.tv_riddle)
        val edAnswer = findViewById<EditText>(R.id.ed_answer)
        val btnRiddle = findViewById<Button>(R.id.btn_riddle)
        val btnAnswer = findViewById<Button>(R.id.btn_answer)
        val btnReAnswer = findViewById<Button>(R.id.btn_reAnswer)
        val btnShowAnswer = findViewById<Button>(R.id.btn_showAnswer)
        val tvResult = findViewById<TextView>(R.id.tv_result)

        btnRiddle.setOnClickListener{
            //用 list 儲存謎題及答案
            var index = (Math.random()*5).toInt()
            val riddleList = mutableListOf("0000，猜一句成語。:四大皆空","人有他大，天沒他大。猜一個字:一","台灣女孩，猜一個字。:始","九十九，猜一個字。:白","0+0=1，猜一成語:無中生有")

            //按出題鍵
            edAnswer.text = null
            tvResult.text = null
            btnRiddle.setOnClickListener{
                val countRiddle = riddleList.count()
                val (riddle,answer) = riddleList[index].split(":")
                tvRiddle.text = "謎題:"+riddle
                index++
                if (index >= countRiddle)
                    index = 0

                //按答題鍵
                btnAnswer.setOnClickListener{
                    val ans = edAnswer.text
                    if (ans.toString() == answer){
                        tvResult.text = "你好棒，您答對了!"
                        Toast.makeText(this,edAnswer.text, Toast.LENGTH_SHORT).show()
                    }
                    else{
                        tvResult.text = "沒猜中，再試一次吧!"
                    }
                }

                //按重答
                btnReAnswer.setOnClickListener{
                    edAnswer.text = null
                    tvResult.text = null
                }

                //按看謎底
                btnShowAnswer.setOnClickListener{
                    tvResult.text = "謎底是:"+answer
                }
            }
        }
    }
}