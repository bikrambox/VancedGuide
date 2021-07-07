package com.vanced.faq.ui.widgets.main

import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vanced.faq.ui.component.text.GuideText
import com.vanced.faq.ui.component.text.ToolbarTitleText
import com.vanced.faq.ui.theme.cardColor

@Composable
fun MainToolbar(
    currentDestinationRoute: String?,
    navController: NavController,
) {
    var isMenuExpanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            ToolbarTitleText(if (currentDestinationRoute == "about") "About" else "Vanced Guide")
        },
        actions = {
            if (currentDestinationRoute == "categories") {
                IconButton(
                    onClick = { isMenuExpanded = true },
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More",
                        tint = MaterialTheme.colors.onSurface
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
                            navController.navigate("about")
                        }
                    ) {
                        GuideText(
                            text = "About",
                            textStyle = MaterialTheme.typography.h6
                        )
                    }
                }
            }
        },
        navigationIcon = if (currentDestinationRoute != "categories") {{
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBackIos,
                    contentDescription = "Back"
                )
            }
        }} else null,
        elevation = 0.dp
    )
}