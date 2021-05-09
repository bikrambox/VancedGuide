package com.vanced.faq.ui.layout.about

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vanced.faq.BuildConfig
import com.vanced.faq.ui.component.GuideCard
import com.vanced.faq.ui.component.HeaderCard
import com.vanced.faq.ui.model.LinkModel
import com.vanced.faq.ui.theme.vancedBlue
import com.vanced.faq.ui.theme.vancedRed

private val links = listOf(
    LinkModel(
        name = "Website",
        url = "https://vancedapp.com"
    ),
    LinkModel(
        name = "GitHub",
        url = "https://github.com/YTVanced"
    ),
    LinkModel(
        name = "Crowdin",
        url = "https://translate.vancedapp.com"
    ),
)

@Composable
fun AboutLayout(activity: ComponentActivity) {
    val scrollState = rememberScrollState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("About")
                },
                navigationIcon = {
                     IconButton(onClick = {
                         activity.finish()
                     }) {
                         Icon(
                             imageVector = Icons.Default.ArrowBackIos,
                             contentDescription = null
                         )
                     }
                },
                elevation = 0.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            GradientCard()
            Spacer(modifier = Modifier.height(12.dp))
            LinksCard(links = links)
        }
    }
}

@Composable
fun GradientCard() {
    GuideCard {
        Column(
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            vancedBlue,
                            vancedRed
                        ),
                    )
                )
        ) {
            Spacer(modifier = Modifier.size(width = 0.dp, height = 12.dp))
            Text(
                text = "Vanced Guide",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                color = Color.White
            )
            Text(
                text = BuildConfig.VERSION_NAME,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.size(width = 0.dp, height = 8.dp))
        }
    }
}

@Composable
fun LinksCard(
    links: List<LinkModel>
) {
    HeaderCard(
        headerName = "Official Links"
    ) {
        val uriHandler = LocalUriHandler.current
        links.forEach { link ->
            val annotatedString = buildAnnotatedString {
                val url = link.url
                val name = link.name
                append(name)

                addStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        textDecoration = TextDecoration.Underline,
                        color = MaterialTheme.colors.onSurface
                    ),
                    start = 0,
                    end = name.length
                )

                addStringAnnotation(
                    tag = "URL",
                    annotation = url,
                    start = 0,
                    end = name.length
                )
            }
            ClickableText(
                text = annotatedString,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                annotatedString
                    .getStringAnnotations("URL", it, it)
                    .firstOrNull()?.let { stringAnnotation ->
                        uriHandler.openUri(stringAnnotation.item)
                    }
            }
        }
    }
}