package dev.mfazio.bgg.api.model.remote.collection

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class BGGItemRemote(
    @field:Attribute(name = "objecttype")
    @param:Attribute(name = "objecttype")
    val objectType: String,
    @field:Attribute(name = "objectid")
    @param:Attribute(name = "objectid")
    val objectId: String,
    @field:Attribute(name = "subtype")
    @param:Attribute(name = "subtype")
    val subType: String,
    @field:Attribute(name = "collid")
    @param:Attribute(name = "collid")
    val collectionId: Long,
    @field:Element(name = "name")
    @param:Element(name = "name")
    val name: String,
    @field:Element(name = "yearpublished")
    @param:Element(name = "yearpublished")
    val yearPublished: Int,
    @field:Element(name = "image")
    @param:Element(name = "image")
    val imageUrl: String,
    @field:Element(name = "thumbnail")
    @param:Element(name = "thumbnail")
    val thumbnailUrl: String,
    @field:Element(name = "numplays")
    @param:Element(name = "numplays")
    val numberOfPlays: Int,
    @field:Element(name = "status")
    @param:Element(name = "status")
    val itemStatus: BGGItemStatusRemote,
)
