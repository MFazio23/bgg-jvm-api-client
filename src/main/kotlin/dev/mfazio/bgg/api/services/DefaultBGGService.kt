package dev.mfazio.bgg.api.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.strategy.VisitorStrategy
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

const val defaultJSONBaseUrl = "https://boardgamegeek.com/"
const val defaultXMLBaseUrl = "https://api.geekdo.com/xmlapi2/"

val interceptor = HttpLoggingInterceptor().apply {
    setLevel(HttpLoggingInterceptor.Level.BODY)
}

fun getDefaultBGGJSONService(baseUrl: String = defaultJSONBaseUrl): BGGJsonService =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
        .create(BGGJsonService::class.java)

fun getDefaultBGGXMLService(baseUrl: String = defaultXMLBaseUrl, logRequest: Boolean = false): BGGXMLService =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(SimpleXmlConverterFactory.create(bggXMLSerializer))
        .let {
            if (logRequest) {
                it.client(
                    OkHttpClient.Builder().addInterceptor(interceptor).build()
                )
            } else it
        }
        .build()
        .create(BGGXMLService::class.java)

val bggXMLSerializer = Persister(
    VisitorStrategy(BGGThingPollVisitor())
)

