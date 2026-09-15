package com.example.pam5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pam5.ui.screen.SecondScreen
import com.example.pam5.ui.theme.PAM5Theme

class SecondActivity : ComponentActivity() {

    private val mahasiswaNim = "245150401111035"
    private val mahasiswaNama = "Rafa Maritza Hanasaputri"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val receivedText = intent.getStringExtra("EXTRA_TEXT") ?: ""

        setContent {
            PAM5Theme {
                SecondScreen(
                    nim = mahasiswaNim,
                    nama = mahasiswaNama,
                    label = receivedText,
                    onBackClick = { finish() } // Menutup Activity ini dan kembali ke MainActivity
                )
            }
        }
    }
}