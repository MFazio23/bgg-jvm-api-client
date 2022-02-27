package dev.mfazio.bgg.api.model.remote.thing.poll

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "poll", strict = false)
data class BGGThingPollRemote(
    @field:Attribute(name = "name")
    @param:Attribute(name = "name")
    val name: String,
    @field:Attribute(name = "title")
    @param:Attribute(name = "title")
    val title: String,
    @field:Attribute(name = "totalvotes")
    @param:Attribute(name = "totalvotes")
    val totalVotes: Int,
    @field:ElementList(inline = true, entry = "results", required = false)
    @param:ElementList(inline = true, entry = "results", required = false)
    val pollResults: List<BGGThingPollResultsRemote>
)

