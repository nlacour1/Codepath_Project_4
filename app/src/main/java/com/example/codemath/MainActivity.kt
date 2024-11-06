package com.example.codemath

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the UI elements
        val input1 = findViewById<EditText>(R.id.input1)
        val weight1 = findViewById<EditText>(R.id.weight1)
        val input2 = findViewById<EditText>(R.id.input2)
        val weight2 = findViewById<EditText>(R.id.weight2)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val outputText = findViewById<TextView>(R.id.outputText)

        // Set the click listener for the calculate button
        calculateButton.setOnClickListener {
            // Get the entered values
            val score1 = input1.text.toString().toDoubleOrNull()
            val weightValue1 = weight1.text.toString().toDoubleOrNull()
            val score2 = input2.text.toString().toDoubleOrNull()
            val weightValue2 = weight2.text.toString().toDoubleOrNull()

            // Check if any of the inputs are invalid (null or empty)
            if (score1 != null && weightValue1 != null && score2 != null && weightValue2 != null) {
                // Check that weights are not zero to avoid division by zero
                if (weightValue1 + weightValue2 == 0.0) {
                    outputText.text = "Weights cannot be zero."
                } else {
                    // Calculate the weighted average
                    val weightedAverage = ((score1 * weightValue1) + (score2 * weightValue2)) / (weightValue1 + weightValue2)
                    // Display the result
                    outputText.text = "Final Grade: %.2f".format(weightedAverage)
                }
            } else {
                // Handle invalid inputs
                outputText.text = "Please enter valid numbers in all fields."
            }
        }
    }
}
