package dev.mfazio.bgg.api.services

import dev.mfazio.bgg.api.model.remote.login.BGGLoginRequestRemote
import dev.mfazio.bgg.api.model.remote.tag.BGGTagResponseRemote
import retrofit2.Response
import retrofit2.http.*

interface BGGJsonService {
    object Routes {
        const val login = "login/api/v1"
        const val tags = "api/tags"
    }

    @POST(Routes.login)
    suspend fun login(
        @Body loginRequest: BGGLoginRequestRemote
    ): Response<Unit>
    
    @GET(Routes.tags)
    suspend fun getTags(
        @Header("Cookie") userNameCookieHeader: String,
        @Query("objectid") objectId: Int,
        @Query("objecttype") objectType: String = "thing"
    ): BGGTagResponseRemote
}