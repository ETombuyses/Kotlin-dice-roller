package com.example.test_kotlin_2_dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice("imageView") }

        val rollButton2: Button = findViewById(R.id.button3)
        rollButton2.setOnClickListener { rollDice("imageView2") }

        rollDice("imageView")
        rollDice("imageView2")
    }


    private fun rollDice(targetId: String) {
        val luckyNumber: Number = 4
        val myDice: Dice = Dice(6)
        val result: Int = myDice.roll()
        val imageTargetId: Int = resources.getIdentifier(targetId, "id", packageName)
        val diceImage: ImageView = findViewById(imageTargetId)
        val imageName: String = "dice_${result}"
        val imageId: Int = resources.getIdentifier(imageName, "drawable", packageName)
        // diceImage.setImageResource(R.drawable.dice_2)
        diceImage.setImageResource(imageId)

        /* Old code used to display text in a textView
        // resources.getIdentifier is usefull only if the id is dynamic, otherwhise use findViewById
        // directly
        val target = resources.getIdentifier(targetId, "id", packageName)

        val resultTextView: TextView = findViewById(target)
        resultTextView.text = result.toString()

        when (result) {
            luckyNumber -> {
                val toast = Toast.makeText(this, "Lucky you !", Toast.LENGTH_SHORT)
                toast.show()
            }
            6 -> println("666 years of malediction")
            else -> {
                println("this is amazing !")
            }
        }*/
    }
}

class Dice(private val sidesCount: Int) {
    fun roll(): Int {
        return (1..sidesCount).random()
    }
}