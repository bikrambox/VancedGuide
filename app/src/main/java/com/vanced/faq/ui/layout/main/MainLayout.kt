package com.vanced.faq.ui.layout.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vanced.faq.ui.layout.about.AboutLayout
import com.vanced.faq.ui.widgets.main.MainToolbar

@Composable
fun MainLayout() {
    val navController = rememberNavController()
    val currentDestinationRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MainToolbar(
                currentDestinationRoute = currentDestinationRoute,
                navController = navController
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    ) {
        NavHost(
            navController = navController,
            startDestination = "categories"
        ) {
            composable("categories") { CategoriesLayout(navController) }
            composable("category") {
                val backStackEntry = navController.previousBackStackEntry
                GuideCategoryLayout(navController, backStackEntry?.arguments?.getParcelable("category"))
            }
            composable("guide") {
                val backStackEntry = navController.previousBackStackEntry
                GuideLayout(backStackEntry?.arguments?.getParcelable("text"))
            }
            composable("about") { AboutLayout() }
        }
    }

}