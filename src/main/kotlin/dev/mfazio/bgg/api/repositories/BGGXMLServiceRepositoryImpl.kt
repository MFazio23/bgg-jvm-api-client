package dev.mfazio.bgg.api.repositories

import dev.mfazio.bgg.api.model.remote.collection.BGGItemCollectionRemote
import dev.mfazio.bgg.api.model.remote.plays.BGGPlayListRemote
import dev.mfazio.bgg.api.model.remote.thing.BGGThingCollectionRemote
import dev.mfazio.bgg.api.model.remote.thing.BGGThingRemote
import dev.mfazio.bgg.api.services.BGGThingPollVisitor
import dev.mfazio.bgg.api.services.BGGXMLService
import dev.mfazio.bgg.api.services.getDefaultBGGXMLService
import kotlinx.coroutines.delay
import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.strategy.VisitorStrategy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class BGGXMLServiceRepositoryImpl(
    private val bggService: BGGXMLService = getDefaultBGGXMLService()
) : BGGXMLServiceRepository {
    override suspend fun getCollectionForUser(userName: String, isOwned: Boolean, isBrief: Boolean, retryDelay: Long?): BGGItemCollectionRemote? {
        println("Attempting to load collection for $userName")

        var tries = 1

        while (tries < COLLECTION_ATTEMPTS) {
            println("Collection call attempt #${tries}")
            getCollectionForUserFromString(userName, isOwned, isBrief)?.let { collection ->
                println("Collection found for $userName! ${"${(collection.items?.size ?: -1)} items"}")
                return collection
            }

            delay(retryDelay ?: DELAY_MS)

            tries++
        }

        println("Could not obtain collection for $userName ")

        return null
    }

    private suspend fun getCollectionForUserFromString(userName: String, isOwned: Boolean, isBrief: Boolean): BGGItemCollectionRemote? =
        suspendCoroutine { continuation ->
            bggService.getItemCollectionCall(
                userName = userName,
                isOwnedNumeric = if (isOwned) 1 else 0,
                isBriefNumeric = if (isBrief) 1 else 0,
            ).enqueue(
                object : Callback<String?> {
                    override fun onResponse(call: Call<String?>, response: Response<String?>) {
                        val result = if (response.code() == 202) {
                            null
                        } else {
                            xmlSerializer.read(BGGItemCollectionRemote::class.java, response.body())
                        }

                        continuation.resume(result)
                    }

                    override fun onFailure(call: Call<String?>, t: Throwable) {
                        continuation.resume(null)
                    }
                }
            )
        }

    override suspend fun getBoardGameCollectionWithDetails(userName: String, isOwned: Boolean, retryDelay: Long?): BGGThingCollectionRemote? {
        val collection = getCollectionForUser(
            userName = userName,
            isOwned = isOwned,
            isBrief = true,
            retryDelay = retryDelay
        )

        val boardGames = collection?.items?.mapNotNull { item -> item.objectId.toIntOrNull() }?.let { boardGameIds ->
            getThingCollection(boardGameIds, BOARD_GAME_THING_TYPE)
        }

        return boardGames
    }

    override suspend fun getPlaysForUser(userName: String): BGGPlayListRemote = bggService.getPlaysForUser(userName)

    override suspend fun getThing(id: Int, type: String?): BGGThingRemote? = getThingCollection(id, type).things?.firstOrNull()

    override suspend fun getThingCollection(id: Int, type: String?): BGGThingCollectionRemote = bggService.getThing(thingId = id.toString(), thingType = type)

    override suspend fun getThingCollection(ids: List<Int>, type: String?): BGGThingCollectionRemote =
        bggService.getThing(thingId = ids.joinToString(","), thingType = type)

    companion object {
        private const val DELAY_MS = 3000L
        private const val GAME_DELAY_MS = 1000L
        private const val COLLECTION_ATTEMPTS = 5
        private const val BOARD_GAME_THING_TYPE = "boardgame"

        private val xmlSerializer = Persister(VisitorStrategy(BGGThingPollVisitor()))
    }
}