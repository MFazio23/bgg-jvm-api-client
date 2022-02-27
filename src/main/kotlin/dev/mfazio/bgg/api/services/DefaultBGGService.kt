package dev.mfazio.bgg.api.services

import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.strategy.VisitorStrategy
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

const val defaultBaseUrl = "https://api.geekdo.com/xmlapi2/"

fun getDefaultBGGService(baseUrl: String = defaultBaseUrl): BGGXMLService =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(SimpleXmlConverterFactory.create(bggXMLSerializer))
        .build()
        .create(BGGXMLService::class.java)

val bggXMLSerializer = Persister(
    VisitorStrategy(BGGThingPollVisitor())
)

