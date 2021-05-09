package com.vanced.faq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.vanced.faq.ui.layout.main.MainLayout
import com.vanced.faq.ui.theme.VancedGuideTheme

class MainActivity : ComponentActivity() {

    @ExperimentalUnsignedTypes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VancedGuideTheme {
                MainLayout(this)
            }
        }
    }

}