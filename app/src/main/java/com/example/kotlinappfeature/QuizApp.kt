package com.example.kotlinappfeature

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class QuizApp : AppCompatActivity() {

    private val  questions = listOf<QuizQuestion>(
        QuizQuestion(
            "What is your nick name",
            "Jack",
            "Jakir",
            "Nabi",
            "Nuru",
            "a"
        ),
        QuizQuestion(
            "What is your gf name",
            "Rimi",
            "Riya",
            "Rimki",
            "Richi",
            "b"
        ),
        QuizQuestion(
            "What is your Real name",
            "Jack",
            "Jakir",
            "Hadi",
            "Nuru",
            "c"
        )
    )
//    val selectedAnswers = arrayOf<String>()
    private var index :Int = 0
    var right = 0
    var isOptSelected = false;

    private lateinit var tvQues :TextView
    private lateinit var tvOpt1 :TextView
    private lateinit var tvOpt2 :TextView
    private lateinit var tvOpt3 :TextView
    private lateinit var tvOpt4 :TextView
    private lateinit var tvQuesNo :TextView
    private lateinit var tvRemTime :TextView
    private lateinit var btnNext :Button

    private lateinit var llOptA :LinearLayout
    private lateinit var llOptB :LinearLayout
    private lateinit var llOptC :LinearLayout
    private lateinit var llOptD :LinearLayout
    private lateinit var ivOptA :ImageView
    private lateinit var ivOptB :ImageView
    private lateinit var ivOptC :ImageView
    private lateinit var ivOptD :ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_app)

        tvQues = findViewById(R.id.tv_ques_id)
        tvOpt1 = findViewById(R.id.tv_opt1_id)
        tvOpt2 = findViewById(R.id.tv_opt2_id)
        tvOpt3 = findViewById(R.id.tv_opt3_id)
        tvOpt4 = findViewById(R.id.tv_opt4_id)
        tvQuesNo = findViewById(R.id.tv_ques_no_id)
        tvRemTime = findViewById(R.id.tv_rem_time)
        btnNext = findViewById(R.id.btn_next_id)

        llOptA = findViewById(R.id.ll_oa_id)
        llOptB = findViewById(R.id.ll_ob_id)
        llOptC = findViewById(R.id.ll_oc_id)
        llOptD = findViewById(R.id.ll_od_id)

        ivOptA = findViewById(R.id.iv_oa_id)
        ivOptB = findViewById(R.id.iv_ob_id)
        ivOptC = findViewById(R.id.iv_oc_id)
        ivOptD = findViewById(R.id.iv_od_id)

        tvQues.text = questions[index].mQues
        tvOpt1.text = questions[index].mOpt1
        tvOpt2.text = questions[index].mOpt2
        tvOpt3.text = questions[index].mOpt3
        tvOpt4.text = questions[index].mOpt4
        tvQuesNo.text = "${index+1}/${questions.size}"

        val builder = AlertDialog.Builder(this)
        val view = LayoutInflater.from(this).inflate(R.layout.quiz_result, null)
        builder.setView(view)
        builder.setCancelable(false)
        lateinit var dialog :AlertDialog


        view.findViewById<Button>(R.id.btn_close_id).setOnClickListener {
            index = 0
            dialog.dismiss()
            startActivity(intent);
            finish();

        }

        llOptA.setOnClickListener {
            llOptA.setBackgroundColor(Color.parseColor("#000000"))
            llOptB.setBackgroundColor(Color.parseColor("#ffffff"))
            llOptC.setBackgroundColor(Color.parseColor("#ffffff"))
            llOptD.setBackgroundColor(Color.parseColor("#ffffff"))

            ivOptA.visibility = View.VISIBLE
            ivOptB.visibility = View.INVISIBLE
            ivOptC.visibility = View.INVISIBLE
            ivOptD.visibility = View.INVISIBLE

            questions[index].mSelectAns = "a"
            isOptSelected = true

        }
        llOptB.setOnClickListener {
            llOptA.setBackgroundColor(Color.parseColor("#ffffff"))
            llOptB.setBackgroundColor(Color.parseColor("#000000"))
            llOptC.setBackgroundColor(Color.parseColor("#ffffff"))
            llOptD.setBackgroundColor(Color.parseColor("#ffffff"))

            ivOptA.visibility = View.INVISIBLE
            ivOptB.visibility = View.VISIBLE
            ivOptC.visibility = View.INVISIBLE
            ivOptD.visibility = View.INVISIBLE
            isOptSelected = true
            questions[index].mSelectAns = "b"
        }
        llOptC.setOnClickListener {
            llOptA.setBackgroundColor(Color.parseColor("#ffffff"))
            llOptB.setBackgroundColor(Color.parseColor("#ffffff"))
            llOptC.setBackgroundColor(Color.parseColor("#000000"))
            llOptD.setBackgroundColor(Color.parseColor("#ffffff"))
            ivOptA.visibility = View.INVISIBLE
            ivOptB.visibility = View.INVISIBLE
            ivOptC.visibility = View.VISIBLE
            ivOptD.visibility = View.INVISIBLE
            isOptSelected = true
            questions[index].mSelectAns = "c"
        }
        llOptD.setOnClickListener {
            llOptA.setBackgroundColor(Color.parseColor("#ffffff"))
            llOptB.setBackgroundColor(Color.parseColor("#ffffff"))
            llOptC.setBackgroundColor(Color.parseColor("#ffffff"))
            llOptD.setBackgroundColor(Color.parseColor("#000000"))
            ivOptA.visibility = View.INVISIBLE
            ivOptB.visibility = View.INVISIBLE
            ivOptC.visibility = View.INVISIBLE
            ivOptD.visibility = View.VISIBLE
            isOptSelected = true
            questions[index].mSelectAns = "d"
        }
        btnNext.setOnClickListener {

            if (!isOptSelected){
                var sb = Snackbar.make(it, "Select Option", Snackbar.LENGTH_SHORT)
                    sb.setAction("Ok", View.OnClickListener {
                       sb.dismiss()
                    })
                    sb.show()
            }
            else if (index < questions.size-1){
                isOptSelected = false
                index++
                tvQues.text = questions[index].mQues
                tvOpt1.text = questions[index].mOpt1
                tvOpt2.text = questions[index].mOpt2
                tvOpt3.text = questions[index].mOpt3
                tvOpt4.text = questions[index].mOpt4

                llOptA.setBackgroundColor(Color.parseColor("#ffffff"))
                llOptB.setBackgroundColor(Color.parseColor("#ffffff"))
                llOptC.setBackgroundColor(Color.parseColor("#ffffff"))
                llOptD.setBackgroundColor(Color.parseColor("#ffffff"))
                tvQuesNo.text = "${index+1}/${questions.size}"
                if (index == questions.size-1) btnNext.text = "Submit"
            }
            else{
                questions.forEach {
                    Log.d("ans", it.mSelectAns)
                    if(it.mSelectAns==it.mAns) right++
                }
                view.findViewById<TextView>(R.id.tv_result_total_ques_id).text = "Total Question "+questions.size.toString()
                view.findViewById<TextView>(R.id.tv_result_right_ans).text = "Right Ans "+right.toString()
                dialog = builder.create()
                dialog.show()


            }
        }


    }
}