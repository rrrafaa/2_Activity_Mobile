package com.example.pam5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam5.ui.screen.FirstScreen
import com.example.pam5.ui.screen.SecondScreen
import com.example.pam5.ui.theme.PAM5Theme

class MainActivity : ComponentActivity() {

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
                        FirstScreen(
                            nim = mahasiswaNim,
                            nama = mahasiswaNama,
                            onNextClick = {
                                navController.navigate("second")
                            }
                        )
                    }
                    composable("second") {
                        SecondScreen(
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