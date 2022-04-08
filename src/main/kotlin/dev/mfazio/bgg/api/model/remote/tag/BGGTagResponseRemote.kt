package dev.mfazio.bgg.api.model.remote.tag

data class BGGTagResponseRemote(
    val config: BGGTagConfigRemote? = null,
    val globalTags: List<BGGTagRemote>? = emptyList(),
    val myTags: List<BGGTagRemote>? = emptyList(),
)

data class BGGTagConfigRemote(
    val username: String,
)

data class BGGTagRemote(
    val rawTag: String,
    val pinId: String? = null,
    val href: String? = null,
)