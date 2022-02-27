package dev.mfazio.bgg.api.model.remote.thing.poll

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "results", strict = false)
data class BGGThingPollBasicResultsRemote(
    @field:ElementList(inline = true, entry = "result", required = false)
    @param:ElementList(inline = true, entry = "result", required = false)
    override val pollResults: List<BGGThingPollResultRemote>? = emptyList()
) : BGGThingPollResultsRemote