package com.example.visitsacompose

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.preference.PreferenceManager
import com.example.visitsacompose.common.navigation.AppNavigation
import com.example.visitsacompose.common.navigation.Screen
import com.example.visitsacompose.ui.component.BottomNavigationBar
import com.example.visitsacompose.ui.theme.VisitSAComposeTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
        setContent {
            VisitSAComposeTheme {
                VisitSaApp(sharedPreferences = sharedPrefs)
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun VisitSaApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberAnimatedNavController(),
    sharedPreferences: SharedPreferences
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Onboarding.route && currentRoute != Screen.Login.route && currentRoute != Screen.Register.route) {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        AppNavigation(navController, modifier.padding(innerPadding), sharedPreferences)
    }
}