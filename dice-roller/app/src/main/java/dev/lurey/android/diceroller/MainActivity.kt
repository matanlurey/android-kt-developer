package dev.lurey.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import dev.lurey.android.diceroller.databinding.ActivityMainBinding
import java.lang.IllegalStateException
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This actually wasn't in the "Connecting the Button" lesson, but is a newer feature of
        // Jetpack (https://developer.android.com/topic/libraries/view-binding#kotlin) that was
        // quite neat.
        binding = ActivityMainBinding.inflate(layoutInflater)
        diceImage = binding.diceImage

        setContentView(binding.root)

        binding.rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val drawDice = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> throw IllegalStateException("Unexpected dice value: $randomInt")
        }
        diceImage.setImageResource(drawDice)
    }
}