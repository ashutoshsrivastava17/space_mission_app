package assignment.leanix.ui

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import assignment.leanix.repository.mission.MissionRepository
import assignment.leanix.repository.mission.models.MissionInfo
import assignment.leanix.ui.base.BaseViewModel
import com.backbase.assignment.repository.Result
import kotlinx.coroutines.launch


/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 9:00 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
class MainViewModel(application: Application, private val missionRepository: MissionRepository) :
    BaseViewModel<MainNavigator>(application) {

    private val missionLiveData = MutableLiveData<List<MissionInfo>?>()

    init {
        fetchMission()
    }

    private fun fetchMission() {
        viewModelScope.launch {
            showLoader()
            val fetchMission = missionRepository.fetchMission(10)
            hideLoader()
            if (fetchMission is Result.Success) {
                missionLiveData.postValue(fetchMission.data);
            } else if (fetchMission is Result.Error) {
                navigator?.onError(fetchMission.message)
            }
        }
    }

    fun observeMission(): MutableLiveData<List<MissionInfo>?> {
        return missionLiveData
    }

    fun sortByName(orderBy: String) {
        val list = missionLiveData.value
        missionLiveData.value =
            if ("ASC".equals(orderBy)) list?.sortedBy { it.missionName }
            else list?.sortedByDescending { it.missionName }
    }

    fun sortByLaunchDate(orderBy: String) {
        val list = missionLiveData.value
        missionLiveData.value =
            if ("ASC".equals(orderBy)) list?.sortedBy { it.launchDate }
            else list?.sortedByDescending { it.launchDate }
    }


}