package dev.mfazio.bgg.api.model.remote.thing

import dev.mfazio.bgg.api.model.remote.BGGIntValue
import dev.mfazio.bgg.api.model.remote.BGGStringValue
import dev.mfazio.bgg.api.model.remote.thing.poll.BGGThingPollRemote
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class BGGThingRemote(
    @field:Attribute(name = "id")
    @param:Attribute(name = "id")
    val thingId: Long,
    @field:Attribute(name = "type")
    @param:Attribute(name = "type")
    val thingType: String,
    @field:Element(name = "thumbnail")
    @param:Element(name = "thumbnail")
    val thumbnailUrl: String,
    @field:Element(name = "image")
    @param:Element(name = "image")
    val imageUrl: String,
    @field:ElementList(inline = true, entry = "name", required = false)
    @param:ElementList(inline = true, entry = "name", required = false)
    val names: List<BGGThingNameRemote>? = emptyList(),
    @field:Element(name = "description", required = false)
    @param:Element(name = "description", required = false)
    val description: String?,
    @field:Element(name = "yearpublished", required = false)
    @param:Element(name = "yearpublished", required = false)
    val yearPublished: BGGStringValue,
    @field:Element(name = "minplayers", required = false)
    @param:Element(name = "minplayers", required = false)
    val minPlayers: BGGIntValue,
    @field:Element(name = "maxplayers", required = false)
    @param:Element(name = "maxplayers", required = false)
    val maxPlayers: BGGIntValue,
    @field:Element(name = "playingtime", required = false)
    @param:Element(name = "playingtime", required = false)
    val playTime: BGGIntValue,
    @field:Element(name = "minplaytime", required = false)
    @param:Element(name = "minplaytime", required = false)
    val minPlayTime: BGGIntValue,
    @field:Element(name = "maxplaytime", required = false)
    @param:Element(name = "maxplaytime", required = false)
    val maxPlayTime: BGGIntValue,
    @field:Element(name = "minage", required = false)
    @param:Element(name = "minage", required = false)
    val minimumAge: BGGIntValue,
    @field:ElementList(inline = true, entry = "poll", required = false)
    @param:ElementList(inline = true, entry = "poll", required = false)
    val polls: List<BGGThingPollRemote>? = emptyList(),
)

