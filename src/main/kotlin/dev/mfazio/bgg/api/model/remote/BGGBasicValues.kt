package dev.mfazio.bgg.api.model.remote

import org.simpleframework.xml.Attribute

data class BGGStringValue(
    @field:Attribute(name = "value")
    @param:Attribute(name = "value")
    val value: String,
)

data class BGGIntValue(
    @field:Attribute(name = "value")
    @param:Attribute(name = "value")
    val value: Int,
)