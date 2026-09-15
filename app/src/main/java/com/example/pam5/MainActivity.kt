package com.example.pam5

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pam5.ui.screen.FirstScreen
import com.example.pam5.ui.theme.PAM5Theme

class MainActivity : ComponentActivity() {

    private val mahasiswaNim = "245150401111035"
    private val mahasiswaNama = "Rafa Maritza Hanasaputri"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAM5Theme {
                FirstScreen(
                    nim = mahasiswaNim,
                    nama = mahasiswaNama,
                    onNextClick = { inputText ->
                        val intent = Intent(this, SecondActivity::class.java)
                        intent.putExtra("EXTRA_TEXT", inputText)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}