package dev.mfazio.bgg.api.model.remote.thing

import dev.mfazio.bgg.api.model.remote.BGGDoubleValue
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "ratings", strict = false)
data class BGGThingRatings(
    @field:Element(name = "averageweight")
    @param:Element(name = "averageweight")
    val averageWeight: BGGDoubleValue
)
