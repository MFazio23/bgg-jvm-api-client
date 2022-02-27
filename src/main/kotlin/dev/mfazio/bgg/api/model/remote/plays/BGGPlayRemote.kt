package dev.mfazio.bgg.api.model.remote.plays

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "play", strict = false)
data class BGGPlayRemote(
    @field:Attribute(name = "id")
    @param:Attribute(name = "id")
    val playId: Long,
    @field:Attribute(name = "date")
    @param:Attribute(name = "date")
    val playDate: String,
    @field:Attribute(name = "quantity")
    @param:Attribute(name = "quantity")
    val quantity: Int,
    @field:Attribute(name = "length")
    @param:Attribute(name = "length")
    val length: Int,
    @field:Attribute(name = "incomplete")
    @param:Attribute(name = "incomplete")
    val incompleteInt: Int,
    @field:Attribute(name = "nowinstats")
    @param:Attribute(name = "nowinstats")
    val nowInStatsInt: Int,
    @field:Attribute(name = "location")
    @param:Attribute(name = "location")
    val location: String,
    @field:Element(name = "item")
    @param:Element(name = "item")
    val item: BGGPlayItemRemote,
    @field:Element(name = "comments", required = false)
    @param:Element(name = "comments", required = false)
    val comments: String? = null,
    @field:ElementList(name = "players", entry = "player", required = false)
    @param:ElementList(name = "players", entry = "player", required = false)
    val players: List<BGGPlayPlayerRemote>? = emptyList()
) {
    val incomplete = incompleteInt == 1
    val nowInStats = nowInStatsInt == 1
}
