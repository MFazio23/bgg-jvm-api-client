package dev.mfazio.bgg.api.repositories

interface BGGJSONServiceRepository {
    suspend fun getTags(
        objectId: Int,
        objectType: String = "thing",
        userName: String? = null,
        password: String? = null,
        passwordHeader: String? = null,
    ): List<String>
    suspend fun login(userName: String?, password: String?): String?
}