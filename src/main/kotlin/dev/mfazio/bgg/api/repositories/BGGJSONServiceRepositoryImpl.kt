/*
package dev.mfazio.bgg.api.repositories

class BGGJSONServiceRepositoryImpl : BGGJSONServiceRepository {

    override suspend fun getTags(objectId: Int, objectType: String, userName: String?, password: String?, passwordHeader: String?) : List<String> {
        val header = passwordHeader ?: login(userName, password) ?: emptyList()
    }

    override suspend fun login(userName: String?, password: String?): String? {
        if (userName == null || password == null) return null

        return null
    }
}*/
