package dev.mfazio.bgg.api.services

import dev.mfazio.bgg.api.model.remote.collection.BGGItemCollectionRemote
import dev.mfazio.bgg.api.model.remote.plays.BGGPlayListRemote
import dev.mfazio.bgg.api.model.remote.thing.BGGThingCollectionRemote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BGGXMLService {

    object Routes {
        const val collection = "collection"
        const val plays = "plays"
        const val thing = "thing"
    }

    @GET(Routes.thing)
    suspend fun getThing(
        @Query("id") thingId: String,
        @Query("stats") statsNumeric: Int,
        @Query("type") thingType: String? = defaultThingType,
    ): BGGThingCollectionRemote

    @GET(Routes.collection)
    suspend fun getItemCollection(
        @Query("username") userName: String,
        @Query("own") isOwnedNumeric: Int = 1,
    ): BGGItemCollectionRemote

    @GET(Routes.collection)
    fun getItemCollectionCall(
        @Query("username") userName: String,
        @Query("own") isOwnedNumeric: Int = 1,
        @Query("brief") isBriefNumeric: Int = 0,
    ): Call<String?>

    @GET(Routes.plays)
    suspend fun getPlaysForUser(
        @Query("username") userName: String,
    ): BGGPlayListRemote

    companion object {
        private const val defaultThingType = "boardgame"
    }
}