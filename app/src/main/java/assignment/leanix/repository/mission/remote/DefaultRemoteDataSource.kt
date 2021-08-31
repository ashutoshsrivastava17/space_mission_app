package assignment.leanix.repository.mission.remote

import assignment.leanix.repository.BaseAPIResponse
import assignment.leanix.repository.mission.RemoteDataSource
import assignment.leanix.repository.mission.models.MissionInfo
import com.backbase.assignment.repository.Result

/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 9:10 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
class DefaultRemoteDataSource(private var spaceAPI: IMissionAPI) : BaseAPIResponse(), RemoteDataSource {

    override suspend fun fetchMission(limit: Int): Result<MutableList<MissionInfo>?> {
        return safeApiCall { spaceAPI.fetchMission(limit).execute() }
    }
}