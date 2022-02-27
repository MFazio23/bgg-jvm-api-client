package dev.mfazio.bgg.api.model.remote.plays

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "items", strict = false)
data class BGGPlayListRemote(
    @field:Attribute(name = "username", required = false)
    @param:Attribute(name = "username", required = false)
    val userName: String,
    @field:Attribute(name = "userid", required = false)
    @param:Attribute(name = "userid", required = false)
    val userId: Int,
    @field:Attribute(name = "total", required = false)
    @param:Attribute(name = "total", required = false)
    val total: Int,
    @field:Attribute(name = "page", required = false)
    @param:Attribute(name = "page", required = false)
    val page: Int,
    @field:ElementList(name = "plays", inline = true, entry = "play", required = false)
    @param:ElementList(name = "plays", inline = true, entry = "play", required = false)
    val plays: List<BGGPlayRemote>
)