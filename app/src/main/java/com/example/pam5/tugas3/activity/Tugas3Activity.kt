package com.example.pam5.tugas3.activity

import com.example.pam5.tugas3.ui.screen.CatalogScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pam5.ui.theme.PAM5Theme

// ============================================================
// Tugas 3 (Membuat aplikasi Android dengan LazyLayout)
// - NIM dan Nama ditampilkan dalam stickyHeader
// - Image lokal (resource drawable) ditampilkan di dalam list
// ============================================================
class Tugas3Activity : ComponentActivity() {

    private val mahasiswaNim = "245150401111035"
    private val mahasiswaNama = "Rafa Maritza Hanasaputri"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PAM5Theme {
                CatalogScreen(
                    nim = mahasiswaNim,
                    nama = mahasiswaNama,
                    onBackClick = { finish() }
                )
            }
        }
    }
}
