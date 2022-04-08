package dev.mfazio.bgg.api.model.remote.login

data class BGGLoginRequestRemote(
    val credentials: BGGLoginCredentialsRemote
) {
    companion object {
        fun fromUsernameAndPassword(username: String, password: String) =
            BGGLoginRequestRemote(BGGLoginCredentialsRemote(username, password))
    }
}

data class BGGLoginCredentialsRemote(
    val username: String,
    val password: String,
)
