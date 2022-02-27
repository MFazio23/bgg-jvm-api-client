package dev.mfazio.bgg.api.model.remote.thing

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "name", strict = false)
data class BGGThingNameRemote(
    @field:Attribute(name = "type")
    @param:Attribute(name = "type")
    val nameType: String,
    @field:Attribute(name = "value")
    @param:Attribute(name = "value")
    val name: String,
    @field:Attribute(name = "sortindex")
    @param:Attribute(name = "sortindex")
    val sortIndex: Int,
)