package dev.mfazio.bgg.api.model.remote.thing

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "statistics", strict = false)
data class BGGThingStatistics(
    @field:Attribute(name = "page")
    @param:Attribute(name = "page")
    val page: Int? = null,
    @field:Element(name = "ratings")
    @param:Element(name = "ratings")
    val ratings: BGGThingRatings,
)
