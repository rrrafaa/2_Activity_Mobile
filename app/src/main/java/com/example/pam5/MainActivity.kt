package com.example.pam5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam5.tugas4.navigation.NavDestination
import com.example.pam5.tugas4.ui.screen.Tugas4CounterScreen
import com.example.pam5.tugas4.ui.screen.Tugas4SecondScreen
import com.example.pam5.ui.theme.PAM5Theme

// ============================================================
// Tugas 4 (Membuat aplikasi counter dengan tombol Up, Down, Reset
//          menggunakan ViewModel, serta menampilkan NIM dan Nama)
//
// Activity tugas sebelumnya tetap ada di package masing-masing:
//  - Tugas 2   -> com.example.pam5.tugas2   (activity/, ui/screen/)
//  - Latihan 2 -> com.example.pam5.latihan2 (activity/, ui/screen/)
//  - Tugas 3   -> com.example.pam5.tugas3   (activity/, model/, ui/)
// ============================================================

class MainActivity : ComponentActivity() {

    private val mahasiswaNim = "245150401111035"
    private val mahasiswaNama = "Rafa Maritza Hanasaputri"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PAM5Theme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = NavDestination.First
                ) {
                    composable(NavDestination.First) {
                        Tugas4CounterScreen(
                            nim = mahasiswaNim,
                            nama = mahasiswaNama,
                            onNextClick = {
                                navController.navigate(NavDestination.Second)
                            }
                        )
                    }
                    composable(NavDestination.Second) {
                        Tugas4SecondScreen(
                            nim = mahasiswaNim,
                            nama = mahasiswaNama,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}
