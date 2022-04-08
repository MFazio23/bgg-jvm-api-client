package dev.mfazio.bgg.api.services

import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.strategy.VisitorStrategy
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

const val defaultJSONBaseUrl = "https://boardgamegeek.com/"
const val defaultXMLBaseUrl = "https://api.geekdo.com/xmlapi2/"

fun getDefaultBGGJSONService(baseUrl: String = defaultJSONBaseUrl): BGGJsonService =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
        .create(BGGJsonService::class.java)

fun getDefaultBGGXMLService(baseUrl: String = defaultXMLBaseUrl): BGGXMLService =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(SimpleXmlConverterFactory.create(bggXMLSerializer))
        .build()
        .create(BGGXMLService::class.java)

val bggXMLSerializer = Persister(
    VisitorStrategy(BGGThingPollVisitor())
)

