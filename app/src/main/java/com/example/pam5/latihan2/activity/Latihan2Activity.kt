package com.example.pam5.latihan2.activity

import com.example.pam5.latihan2.ui.screen.Latihan2SecondScreen

import com.example.pam5.latihan2.ui.screen.Latihan2FirstScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam5.ui.theme.PAM5Theme

// ============================================================
// Latihan 2 (Membuat aplikasi menggunakan Compose Navigation)
// - 1 Activity, 2 Screen
// - NIM dan Nama tampil di semua screen
// - Screen 1: Text "Screen 1", Tombol "Ke Halaman 2"
// - Screen 2: Text "Screen 2"
// ============================================================
class Latihan2Activity : ComponentActivity() {

    private val mahasiswaNim = "245150401111035"
    private val mahasiswaNama = "Rafa Maritza Hanasaputri"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAM5Theme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "first"
                ) {
                    composable("first") {
                        Latihan2FirstScreen(
                            nim = mahasiswaNim,
                            nama = mahasiswaNama,
                            onNextClick = {
                                navController.navigate("second")
                            }
                        )
                    }
                    composable("second") {
                        Latihan2SecondScreen(
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
