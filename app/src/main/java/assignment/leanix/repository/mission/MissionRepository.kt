package assignment.leanix.repository.mission

import assignment.leanix.repository.mission.models.MissionInfo
import com.backbase.assignment.repository.Result


/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 08:10 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
interface MissionRepository {

    suspend fun fetchMission(limit: Int?): Result<MutableList<MissionInfo>?>
}