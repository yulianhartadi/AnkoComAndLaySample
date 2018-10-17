package com.rawzadigital.www.ankocomandlaysample

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import com.rawzadigital.www.ankocomandlaysample.R.color.colorAccent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>)  = with(ui){
            verticalLayout{
                padding = dip(16)


                //edit text
                val name = editText{
                    hint =   "What's your name?"
                }

                //Button show toast
                button("Say Hello"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick { toast("Hello,   ${name.text}!")}
                }.lparams(width  =  matchParent){
                    topMargin = dip(5)
                }

                //Button show alert
                button("Show Alert"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick{
                        alert("Happy Coding!", "Hello, ${name.text}!") {
                            yesButton {toast("oh...")}
                            noButton {  }
                        }.show()
                    }
                }.lparams(width =  matchParent){
                    topMargin = dip(5)
                }

                //Button show selector
                button("Show Selector"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        val  club = listOf("Barcelona", "Real Madrid", "Bayern Muenchen", "Liverpool")
                        selector ("Hello, ${name.text}!  What's football  club do you love?", club){
                            _, i -> toast("so you love ${club[i]}, right?")
                        }
                    }
                }.lparams(width  = matchParent){
                    topMargin = dip(5)
                }

                //Button Show Progress Bar
                button("Show Progress Bar"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick{
                         indeterminateProgressDialog("Hello,  ${name.text}! PelaseWait...").show()
                    }
                }.lparams(width  = matchParent){
                    topMargin = dip(5)
                }

                //Button Go to Second Activity
                button("Go to Second Activity"){
                    backgroundColor = ContextCompat.getColor(context,  colorAccent)
                    textColor =  Color.WHITE
                    onClick{
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width  = matchParent){
                    topMargin = dip(5)
                }

            }
        }
    }
}
