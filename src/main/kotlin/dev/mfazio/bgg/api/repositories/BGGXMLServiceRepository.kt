package dev.mfazio.bgg.api.repositories

import dev.mfazio.bgg.api.model.remote.collection.BGGItemCollectionRemote
import dev.mfazio.bgg.api.model.remote.plays.BGGPlayListRemote
import dev.mfazio.bgg.api.model.remote.thing.BGGThingCollectionRemote
import dev.mfazio.bgg.api.model.remote.thing.BGGThingRemote

interface BGGXMLServiceRepository {
    suspend fun getCollectionForUser(userName: String, isOwned: Boolean = true, retryDelay: Long? = null): BGGItemCollectionRemote?
    suspend fun getPlaysForUser(userName: String): BGGPlayListRemote
    suspend fun getThing(id: Int, type: String? = null): BGGThingRemote?
    suspend fun getThingCollection(id: Int, type: String? = null): BGGThingCollectionRemote
}