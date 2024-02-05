package com.example.skinapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecoverPasswordScreen.route) {
        composable(route = Screen.RecoverPasswordScreen.route) {
//            RecoverPasswordActivity(navController = navController)
        }

    }
}