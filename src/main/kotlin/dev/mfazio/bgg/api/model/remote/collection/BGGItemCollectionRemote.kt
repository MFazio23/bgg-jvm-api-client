package dev.mfazio.bgg.api.model.remote.collection

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "items", strict = false)
data class BGGItemCollectionRemote(
    @field:Attribute(name = "totalitems", required = false)
    @param:Attribute(name = "totalitems", required = false)
    val totalItems: Int? = null,
    @field:Attribute(name = "pubdate", required = false)
    @param:Attribute(name = "pubdate", required = false)
    val publishDate: String? = null,
    @field:ElementList(inline = true, entry = "item", required = false)
    @param:ElementList(inline = true, entry = "item", required = false)
    val items: List<BGGItemRemote>? = emptyList(),
)