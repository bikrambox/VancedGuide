package com.vanced.faq.ui.layout.main

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vanced.faq.AboutActivity
import com.vanced.faq.ui.theme.cardColor

@ExperimentalUnsignedTypes
@Composable
fun MainLayout(activity: ComponentActivity) {
    val navController = rememberNavController()
    var isMenuExpanded by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Vanced Guide")
                },
                actions = {
                    IconButton(
                        onClick = {
                            isMenuExpanded = !isMenuExpanded
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    DropdownMenu(
                        expanded = isMenuExpanded,
                        onDismissRequest = {
                            isMenuExpanded = false
                        },
                        modifier = Modifier.background(MaterialTheme.colors.cardColor)
                    ) {
                        DropdownMenuItem(
                            onClick = {
                                isMenuExpanded = false
                                activity.startActivity(
                                    Intent(activity, AboutActivity::class.java)
                                )
                            }
                        ) {
                            Text("About")
                        }
                    }
                },
                elevation = 0.dp
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = "categories"
        ) {
            composable("categories") { CategoriesLayout(navController) }
            composable("category") {
                val backStackEntry = navController.previousBackStackEntry
                CategoryLayout(navController, backStackEntry?.arguments?.getParcelable("category"))
            }
            composable("guide") {
                val backStackEntry = navController.previousBackStackEntry
                GuideLayout(backStackEntry?.arguments?.getParcelable("text"))
            }
        }
    }

}