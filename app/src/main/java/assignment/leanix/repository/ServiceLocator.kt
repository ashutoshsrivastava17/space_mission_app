package com.backbase.assignment.repository

import assignment.leanix.repository.mission.DefaultMissionRepository
import assignment.leanix.repository.mission.MissionRepository
import assignment.leanix.repository.mission.remote.DefaultRemoteDataSource
import assignment.leanix.repository.mission.remote.IMissionAPI

/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 9:30 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
object ServiceLocator {

    private var missionRepository: MissionRepository? = null

    fun provideMissionRepository(): MissionRepository {
        synchronized(this) {
            return missionRepository ?: createMissionRepository()
        }
    }

    private fun createMissionRepository(): MissionRepository {
        val missionAPI = RetrofitFactory.getRetrofit().create(IMissionAPI::class.java)
        val defaultMovieRepository = DefaultMissionRepository(DefaultRemoteDataSource(missionAPI))
        this.missionRepository = defaultMovieRepository
        return defaultMovieRepository
    }
}