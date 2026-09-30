package com.example.pam5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam5.ui.screen.CatalogScreen
import com.example.pam5.ui.screen.FirstScreen
import com.example.pam5.ui.screen.SecondScreen
import com.example.pam5.ui.theme.PAM5Theme

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
                        FirstScreen(
                            nim = mahasiswaNim,
                            nama = mahasiswaNama,
                            onNextClick = {
                                navController.navigate(NavDestination.Second)
                            }
                        )
                    }
                    composable(NavDestination.Second) {
                        SecondScreen(
                            nim = mahasiswaNim,
                            nama = mahasiswaNama,
                            onBackClick = {
                                navController.popBackStack()
                            },
                            onCatalogClick = {
                                navController.navigate(NavDestination.Catalog)
                            }
                        )
                    }
                    composable(NavDestination.Catalog) {
                        CatalogScreen(
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