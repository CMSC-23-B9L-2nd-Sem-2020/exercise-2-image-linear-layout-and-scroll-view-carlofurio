package com.android.example.exer2_madi_b9l

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var currentImg : ImageView
    lateinit var currentText : TextView
    lateinit var currentCharacter : TextView
    lateinit var currentDescription : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //sets the content in the interface
        setContentView(R.layout.activity_main)

        currentImg = findViewById(R.id.character_image)
        currentText = findViewById(R.id.header)
        currentCharacter = findViewById(R.id.character_name)
        currentDescription = findViewById(R.id.description)

        //calls the proper functions every time a button is clicked
        val startButton: Button = findViewById(R.id.start_button)
        startButton.setOnClickListener { startGame() }

        val retryButton: Button = findViewById(R.id.retry_button)
        retryButton.setOnClickListener { resetGame() }
    }

    private fun startGame() {
        currentText.setText(R.string.start_header)
        val randomInt = (1..11).random()

        //draws the proper image depending on the random character chosen
        val drawableResource = when (randomInt) {
            1 -> R.drawable.gary
            2 -> R.drawable.larry_the_lobster
            3 -> R.drawable.spongebob
            4 -> R.drawable.mr_crab
            5 -> R.drawable.mrs_puff
            6 -> R.drawable.patrick
            7 -> R.drawable.pearl
            8 -> R.drawable.plankton
            9 -> R.drawable.sandy
            10 -> R.drawable.squidward
            else -> R.drawable.spongebob
        }

        //displays the image
        currentImg.setImageResource(drawableResource)

        //gets the proper character name depending on the random character chosen
        val charResource = when (randomInt) {
            1 -> R.string.gary
            2 -> R.string.larry_the_lobster
            3 -> R.string.spongebob
            4 -> R.string.mr_crab
            5 -> R.string.mrs_puff
            6 -> R.string.patrick
            7 -> R.string.pearl
            8 -> R.string.plankton
            9 -> R.string.sandy
            10 -> R.string.squidward
            else -> R.string.spongebob
        }

        //displays the name of the character chosen
        currentCharacter.setText(charResource)

        //gets the proper description of the chosen random character
        val stringResource = when (randomInt) {
            1 -> R.string.gary_des
            2 -> R.string.larry_des
            3 -> R.string.spongebob_des
            4 -> R.string.mr_crab_des
            5 -> R.string.mrs_puff_des
            6 -> R.string.patrick_des
            7 -> R.string.pearl_des
            8 -> R.string.plankton_des
            9 -> R.string.sandy_des
            10 -> R.string.squidward_des
            else -> R.string.spongebob_des
        }
        //displays the description of the character
        currentDescription.setText(stringResource)
    }

    //resets the displayed text and image
    private fun resetGame() {
        currentText.setText(R.string.app_header)
        currentImg.setImageResource(R.drawable.spongebob_squarepants)
        currentCharacter.setText(null)
        currentDescription.setText(R.string.scroll_view)
    }
}