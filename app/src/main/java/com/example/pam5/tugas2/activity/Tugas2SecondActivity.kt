package com.example.pam5.tugas2.activity

import com.example.pam5.tugas2.ui.screen.Tugas2SecondScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pam5.ui.theme.PAM5Theme

// Tugas 2 (Activity 2: menampilkan teks yang dikirim dari Activity 1 pada label)
class Tugas2SecondActivity : ComponentActivity() {

    private val mahasiswaNim = "245150401111035"
    private val mahasiswaNama = "Rafa Maritza Hanasaputri"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val receivedText =
            intent.getStringExtra(Tugas2FirstActivity.EXTRA_TEXT) ?: ""

        setContent {
            PAM5Theme {
                Tugas2SecondScreen(
                    nim = mahasiswaNim,
                    nama = mahasiswaNama,
                    label = receivedText,
                    onBackClick = { finish() } // Menutup Activity ini dan kembali ke Activity 1
                )
            }
        }
    }
}
