package assignment.leanix.repository.mission.remote

import assignment.leanix.repository.mission.models.MissionInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 08:40 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
interface IMissionAPI {

    @Headers("Content-Type: application/json")
    @GET("rest/launches-past/")
    fun fetchMission(
        @Query(value = "limit") limit: Int,
    ): Call<MutableList<MissionInfo>?>

}