package assignment.leanix.repository.mission

import assignment.leanix.repository.mission.models.MissionInfo
import com.backbase.assignment.repository.Result

/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 10:50 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
interface RemoteDataSource {

    suspend fun fetchMission(limit: Int): Result<MutableList<MissionInfo>?>
}