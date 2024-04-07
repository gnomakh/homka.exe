package com.practicum.homkaclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var hamsterCount = 0
        var textCount = findViewById<TextView>(R.id.hamsterCount)

        var pushValue = 1
        var textPushValue = findViewById<TextView>(R.id.pushValue)

        var powerCost = 100
        var powerValue = 1
        var textPowerValue = findViewById<TextView>(R.id.powerCount)

        var botnetCost = 1000

        val plusHamster = findViewById<pl.droidsonroids.gif.GifImageButton>(R.id.plusHamster)

        plusHamster.setOnClickListener {

            plusHamster.animate().apply {
                duration = 5
                scaleX(0.95F)
                scaleY(0.95F)
            }.withEndAction {
                plusHamster.animate().apply {
                    scaleX(1F)
                    scaleY(1F)
                }
            }

            if (hamsterCount == 2147483647) {
                animate(plusHamster as Button)
            }

            hamsterCount += pushValue
            textCount.text = hamsterCount.toString()

        }

        var buyPower = findViewById<Button>(R.id.buyPower)
        var textBuyPower = findViewById<TextView>(R.id.buyPower)
        var textPowerCount = findViewById<TextView>(R.id.powerCount)

        buyPower.setOnClickListener {

            animate(buyPower)

            if (hamsterCount >= powerCost) {
                hamsterCount -= powerCost
                pushValue += powerValue
                powerCost = (powerCost * 1.1).toInt()
                textCount.text = hamsterCount.toString()
                textBuyPower.text = ">купить_за\n$powerCost"
                textPushValue.text = "$pushValue за_клик"
            }
        }

        var buyBotnet = findViewById<Button>(R.id.buyBotnet)
        var textBuyBotnet = findViewById<TextView>(R.id.buyBotnet)

        buyBotnet.setOnClickListener {

            animate(buyBotnet)

            if (botnetCost <= hamsterCount) {
                hamsterCount -= botnetCost
                textCount.text = hamsterCount.toString()
                powerValue++
                botnetCost = (botnetCost * 1.01).toInt()
                textBuyBotnet.text = ">купить_за\n$botnetCost"
                textPowerCount.text = "// вычислительные мощности: +$powerValue"
            }
        }

        var rulesButton = findViewById<Button>(R.id.buttonRules)

        rulesButton.setOnClickListener {
            animate(rulesButton)
            rules()
        }

    }

    fun animate(button: Button) {
        button.animate().apply {
            duration = 5
            scaleX(0.95F)
            scaleY(0.95F)
        }.withEndAction {
            button.animate().apply {
                scaleX(1F)
                scaleY(1F)
            }
        }
    }

    fun rules() {
        val builder = AlertDialog.Builder(this, R.style.alertDialog)
        builder.setMessage(R.string.rules)
        builder.show()
    }
}