package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {
        // Crea un dado de 6 caras
        val dice = Dice(6)

        //Lanza el dado
        var diceRoll = dice.roll()

        // Busca el ID de ImageView a utilizar
        var diceImage: ImageView = findViewById(R.id.imageView)
        //Llama a función para asignar imagen
        changeDrawableResource(diceRoll,diceImage)

        // Vuelve a lanzar el dado
        diceRoll = dice.roll()
        //Busca el ID de la segunda ImageView
        diceImage = findViewById(R.id.imageView2)
        //Asigna la imagen correspondiente
        changeDrawableResource(diceRoll,diceImage)
    }

    //Determina imagen a usar según diceRoll y la asigna a view diceImage
    private fun changeDrawableResource(diceRoll: Int, diceImage: ImageView) {
        val drawableResource = when (diceRoll) {

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}