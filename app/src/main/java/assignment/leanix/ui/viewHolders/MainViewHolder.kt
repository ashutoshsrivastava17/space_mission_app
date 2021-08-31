package assignment.leanix.ui.viewHolders

import assignment.leanix.DateWrapper
import assignment.leanix.databinding.ItemMissionBinding
import assignment.leanix.repository.mission.models.MissionInfo
import com.bumptech.glide.Glide


/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 10:07 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
class MainViewHolder(binding: ItemMissionBinding) :
    BaseViewHolder<MissionInfo, ItemMissionBinding>(binding) {

    override fun bindData(position: Int, data: MissionInfo) {
        binding.tvMissionName.text = data.missionName
        binding.tvLaunchDate.text =
            DateWrapper.getStringFromFormat(DateWrapper.MMM_d_yyyy_hh_mm_a, data.launchDate)
        Glide.with(binding.ivImage.context).load(data.links?.missionPatchSmall)
            .into(binding.ivImage)
    }
}