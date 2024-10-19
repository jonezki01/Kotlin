package com.example.bmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    val bmi: Double
        get() {
            val height = heightInput.toFloatOrNull()?.toDouble() ?: 0.0
            val weight = weightInput.toIntOrNull()?.toDouble() ?: 0.0
            return if (weight > 0 && height > 0) weight / (height * height) else 0.0
        }

    fun updateHeightInput(newHeight: String) {
        heightInput = newHeight.replace(',', '.')
    }

    fun updateWeightInput(newWeight: String) {
        weightInput = newWeight.replace(',', '.')
    }
}