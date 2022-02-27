package dev.mfazio.bgg.api.model.remote.collection

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "status", strict = false)
data class BGGItemStatusRemote(
    @field:Attribute(name = "own")
    @param:Attribute(name = "own")
    val ownInt: Int,
    @field:Attribute(name = "prevowned")
    @param:Attribute(name = "prevowned")
    val previouslyOwnedInt: Int,
    @field:Attribute(name = "fortrade")
    @param:Attribute(name = "fortrade")
    val forTradeInt: Int,
    @field:Attribute(name = "want")
    @param:Attribute(name = "want")
    val wantInt: Int,
    @field:Attribute(name = "wanttoplay")
    @param:Attribute(name = "wanttoplay")
    val wantToPlayInt: Int,
    @field:Attribute(name = "wanttobuy")
    @param:Attribute(name = "wanttobuy")
    val wantToBuyInt: Int,
    @field:Attribute(name = "wishlist")
    @param:Attribute(name = "wishlist")
    val wishlistInt: Int,
    @field:Attribute(name = "preordered")
    @param:Attribute(name = "preordered")
    val preOrderedInt: Int,
    @field:Attribute(name = "lastmodified")
    @param:Attribute(name = "lastmodified")
    val lastModified: String,
) {
    val forTrade: Boolean = forTradeInt == 1
    val own: Boolean = ownInt == 1
    val preOrdered: Boolean = preOrderedInt == 1
    val previouslyOwned: Boolean = previouslyOwnedInt == 1
    val want: Boolean = wantInt == 1
    val wantToBuy: Boolean = wantToBuyInt == 1
    val wantToPlay: Boolean = wantToPlayInt == 1
    val wishlist: Boolean = wishlistInt == 1
}