package com.justai.aimybox.assistant

import android.app.Application
import android.content.Context
import com.justai.aimybox.Aimybox
import com.justai.aimybox.dialogapi.rasa.RasaDialogApi
import com.justai.aimybox.components.AimyboxProvider
import com.justai.aimybox.core.Config
import com.justai.aimybox.speechkit.google.platform.GooglePlatformSpeechToText
import com.justai.aimybox.speechkit.google.platform.GooglePlatformTextToSpeech
import java.util.*

class AimyboxApplication : Application(), AimyboxProvider {

    companion object {
        private const val AIMYBOX_API_KEY = "AIzaSyB2xhK6Y8oK36XbX_J22OvOI-wPio9qFCE"
    }

    override val aimybox by lazy { createAimybox(this) }

    private fun createAimybox(context: Context): Aimybox {
        val unitId = UUID.randomUUID().toString()

        val textToSpeech = GooglePlatformTextToSpeech(context, Locale.ENGLISH)
//        val textToSpeech = GoogleCloudTextToSpeech(context, credentials, Locale.ENGLISH)
        val speechToText = GooglePlatformSpeechToText(context, Locale.forLanguageTag("sw-TZ"))
//        val speechToText = GoogleCloudSpeechToText(credentials, Locale.ENGLISH)

//        GoogleCloudTextToSpeech.Config()

        val dialogApi = RasaDialogApi(unitId, "https://192aaee1.ngrok.io/webhooks/rest/webhook")
//        val dialogApi = AimyboxDialogApi(AIMYBOX_API_KEY, unitId)

        return Aimybox(Config.create(speechToText, textToSpeech, dialogApi))
    }
}