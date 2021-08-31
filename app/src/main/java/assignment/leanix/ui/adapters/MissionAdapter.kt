package assignment.leanix.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import assignment.leanix.databinding.ItemMissionBinding
import assignment.leanix.repository.mission.models.MissionInfo
import assignment.leanix.ui.viewHolders.MainViewHolder

/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 10:06 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
class MissionAdapter(context: Context) :
    BaseRecyclerAdapter<MissionInfo, ItemMissionBinding, MainViewHolder>(context) {

    override fun defaultListenerEnabled(): Boolean {
        return true
    }

    override fun getDiffUtils(): AsyncListDiffer<MissionInfo>? {
        return AsyncListDiffer(this, AsyncDiffUtils())
    }

    override fun getViewHolder(binding: ItemMissionBinding): MainViewHolder {
        return MainViewHolder(binding);
    }

    override fun getBinding(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int,
    ): ItemMissionBinding {
        return ItemMissionBinding.inflate(layoutInflater, parent, false)
    }
}