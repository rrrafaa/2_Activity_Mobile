package com.example.pam5.model

import androidx.annotation.DrawableRes

data class Fruit (
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val imageRes: Int
)