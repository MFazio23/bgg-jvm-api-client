package dev.mfazio.bgg.api.repositories

import dev.mfazio.bgg.api.model.remote.collection.BGGItemCollectionRemote
import dev.mfazio.bgg.api.model.remote.plays.BGGPlayListRemote
import dev.mfazio.bgg.api.model.remote.thing.BGGThingCollectionRemote
import dev.mfazio.bgg.api.model.remote.thing.BGGThingRemote

interface BGGXMLServiceRepository {
    suspend fun getCollectionForUser(userName: String, isOwned: Boolean = true, isBrief: Boolean = false, retryDelay: Long? = null): BGGItemCollectionRemote?
    suspend fun getPlaysForUser(userName: String): BGGPlayListRemote
    suspend fun getThing(id: Int, stats: Boolean = false, type: String? = null): BGGThingRemote?
    suspend fun getThingCollection(id: Int, stats: Boolean = false, type: String? = null): BGGThingCollectionRemote
    suspend fun getThingCollection(ids: List<Int>, stats: Boolean = false, type: String? = null): BGGThingCollectionRemote
    suspend fun getBoardGameCollectionWithDetails(
        userName: String,
        isOwned: Boolean = true,
        retryDelay: Long? = null
    ): BGGThingCollectionRemote?
}