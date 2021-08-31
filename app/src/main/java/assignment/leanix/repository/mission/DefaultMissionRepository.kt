package assignment.leanix.repository.mission

import assignment.leanix.repository.mission.models.MissionInfo
import com.backbase.assignment.repository.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 08:50 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
class DefaultMissionRepository(
    private var remoteDataSource: RemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : MissionRepository {

    override suspend fun fetchMission(limit: Int?): Result<MutableList<MissionInfo>?> =
        withContext(ioDispatcher) {
            return@withContext remoteDataSource.fetchMission(limit ?: 10)
        }
}