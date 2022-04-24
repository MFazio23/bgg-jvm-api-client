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
    @field:Element(name = "yearpublished", required = false)
    @param:Element(name = "yearpublished", required = false)
    val yearPublished: Int? = null,
    @field:Element(name = "image", required = false)
    @param:Element(name = "image", required = false)
    val imageUrl: String? = null,
    @field:Element(name = "thumbnail", required = false)
    @param:Element(name = "thumbnail", required = false)
    val thumbnailUrl: String? = null,
    @field:Element(name = "numplays", required = false)
    @param:Element(name = "numplays", required = false)
    val numberOfPlays: Int? = null,
    @field:Element(name = "status")
    @param:Element(name = "status")
    val itemStatus: BGGItemStatusRemote,
)
