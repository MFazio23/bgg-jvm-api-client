package dev.mfazio.bgg.api.model.remote.thing

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "items", strict = false)
data class BGGThingCollectionRemote(
    @field:Attribute(name = "termsofuse", required = false)
    @param:Attribute(name = "termsofuse", required = false)
    val termsOfUseUrl: String,
    @field:ElementList(name = "items", inline = true, entry = "item", required = false)
    @param:ElementList(name = "items", inline = true, entry = "item", required = false)
    val things: List<BGGThingRemote>
)
