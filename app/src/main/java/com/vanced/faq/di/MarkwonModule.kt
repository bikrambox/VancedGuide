package com.vanced.faq.di

import android.content.Context
import android.text.util.Linkify
import io.noties.markwon.Markwon
import io.noties.markwon.linkify.LinkifyPlugin
import org.koin.dsl.module

val markwonModule = module {
    fun provideMarkwon(context: Context): Markwon {
        return Markwon
            .builder(context)
            .usePlugin(LinkifyPlugin.create(Linkify.WEB_URLS))
            .build()
    }

    single { provideMarkwon(get()) }
}