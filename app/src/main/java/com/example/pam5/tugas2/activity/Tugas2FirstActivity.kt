package com.example.pam5.tugas2.activity

import com.example.pam5.tugas2.ui.screen.Tugas2FirstScreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pam5.ui.theme.PAM5Theme

// ============================================================
// Tugas 2 (Membuat aplikasi 2 Activity)
// Activity 1: 1 TextField dan 1 Tombol
// Activity 2: 1 Label yang menampilkan teks dari Activity 1
// NIM dan Nama ditampilkan di kedua activity
// ============================================================
class Tugas2FirstActivity : ComponentActivity() {

    companion object {
        const val EXTRA_TEXT = "EXTRA_TEXT"
    }

    private val mahasiswaNim = "245150401111035"
    private val mahasiswaNama = "Rafa Maritza Hanasaputri"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAM5Theme {
                Tugas2FirstScreen(
                    nim = mahasiswaNim,
                    nama = mahasiswaNama,
                    onNextClick = { inputText ->
                        val intent = Intent(this, Tugas2SecondActivity::class.java)
                        intent.putExtra(EXTRA_TEXT, inputText)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}
