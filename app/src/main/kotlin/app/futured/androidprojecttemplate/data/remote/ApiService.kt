package app.futured.androidprojecttemplate.data.remote

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.threeten.bp.ZonedDateTime
import retrofit2.http.GET

interface ApiService {

    @GET("/api/user/2")
    suspend fun user(): SampleApiModel

    @Serializable
    data class SampleApiModel(
        val id: String,
        @Contextual val dateTime: ZonedDateTime
    )
}
