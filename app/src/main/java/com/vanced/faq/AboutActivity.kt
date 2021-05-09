package com.vanced.faq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.vanced.faq.ui.layout.about.AboutLayout
import com.vanced.faq.ui.theme.VancedGuideTheme

class AboutActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VancedGuideTheme {
                AboutLayout(this)
            }
        }
    }

}