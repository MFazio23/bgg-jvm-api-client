package dev.mfazio.bgg.api.model.remote.plays

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "player", strict = false)
data class BGGPlayPlayerRemote(
    @field:Attribute(name = "username")
    @param:Attribute(name = "username")
    val userName: String,
    @field:Attribute(name = "userid", required = false)
    @param:Attribute(name = "userid", required = false)
    val userId: Int? = null,
    @field:Attribute(name = "name")
    @param:Attribute(name = "name")
    val name: String,
    @field:Attribute(name = "startposition", required = false)
    @param:Attribute(name = "startposition", required = false)
    val startPosition: String,
    @field:Attribute(name = "color", required = false)
    @param:Attribute(name = "color", required = false)
    val color: String? = null,
    @field:Attribute(name = "score")
    @param:Attribute(name = "score")
    val score: Int? = null,
    @field:Attribute(name = "new")
    @param:Attribute(name = "new")
    val new: Int,
    @field:Attribute(name = "rating")
    @param:Attribute(name = "rating")
    val rating: Int,
    @field:Attribute(name = "win")
    @param:Attribute(name = "win")
    val winInt: Int,
) {
    val isNew = new == 1
    val didWin = winInt == 1
}