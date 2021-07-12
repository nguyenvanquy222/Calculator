package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var op ="*"
    var oldNum=""
    var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumberEvent(view: View){
        if(isNewOperation){
            et_current.setText("")
        }
        isNewOperation=false
        val btnSelect = view as Button
        var btnValue : String = et_current.text.toString()
        when(btnSelect.id){
            num0.id ->{
                btnValue+="0"
            }
            num1.id ->{
                btnValue+="1"
            }
            num2.id ->{
                btnValue+="2"
            }
            num3.id ->{
                btnValue+="3"
            }
            num4.id ->{
                btnValue+="4"
            }
            num5.id ->{
                btnValue+="5"
            }
            num6.id ->{
                btnValue+="6"
            }
            num7.id ->{
                btnValue+="7"
            }
            num8.id ->{
                btnValue+="8"
            }
            num9.id ->{
                btnValue+="9"
            }
            dot.id ->{
                btnValue+="."
            }
        }
        et_current.setText(btnValue)
    }

    fun btnOperationEvent(view: View){

        val btnSelect = view as Button
        when(btnSelect.id) {
            opPlus.id -> {
                op = "+"
            }
            opMinus.id -> {
                op = "-"
            }
            opMultiply.id -> {
                op = "*"
            }
            opDivide.id -> {
                op = "/"
            }
        }
        oldNum=et_current.text.toString()
        isNewOperation=true
    }

    fun  btnEqualEvent(view: View){
        val newNum = et_current.text.toString()
        var finalNum:Double? = null
        when(op){
            "+"->{
                finalNum= oldNum.toDouble() + newNum.toDouble()
            }
            "-"->{
                finalNum= oldNum.toDouble() - newNum.toDouble()
            }
            "*" ->{
                finalNum= oldNum.toDouble() * newNum.toDouble()
            }
            "/"->{
                finalNum= oldNum.toDouble() / newNum.toDouble()
            }
        }
        et_current.setText(finalNum.toString())
        isNewOperation=true
    }

    fun btnCE(view: View){
        et_current.setText("0")
        isNewOperation=true
    }
}