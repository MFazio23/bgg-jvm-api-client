package dev.mfazio.bgg.api.model.remote.plays

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class BGGPlayItemRemote(
    @field:Attribute(name = "name")
    @param:Attribute(name = "name")
    val itemName: String,
    @field:Attribute(name = "objecttype")
    @param:Attribute(name = "objecttype")
    val objectType: String,
    @field:Attribute(name = "objectid")
    @param:Attribute(name = "objectid")
    val objectId: String,
)
