package dev.mfazio.bgg.api.model.remote.thing.poll

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "result", strict = false)
data class BGGThingPollResultRemote(
    @field:Attribute(name = "level", required = false)
    @param:Attribute(name = "level", required = false)
    val level: Int? = null,
    @field:Attribute(name = "value", required = false)
    @param:Attribute(name = "value", required = false)
    val value: String?,
    @field:Attribute(name = "numvotes", required = false)
    @param:Attribute(name = "numvotes", required = false)
    val numberOfVotes: Int?,
)