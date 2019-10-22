package com.thefuntasty.androidprojecttemplate.data.remote

import retrofit2.http.GET

interface ApiService {

    @GET("/api/user/2")
    suspend fun user(): String
}
