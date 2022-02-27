package dev.mfazio.bgg.api.model.remote.thing.poll

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "results", strict = false)
data class BGGThingPollNumberOfPlayersResultsRemote(
    @field:Attribute(name = "numplayers")
    @param:Attribute(name = "numplayers")
    val numberOfPlayers: String,
    @field:ElementList(inline = true, entry = "result", required = false)
    @param:ElementList(inline = true, entry = "result", required = false)
    override val pollResults: List<BGGThingPollResultRemote>? = emptyList()
) : BGGThingPollResultsRemote