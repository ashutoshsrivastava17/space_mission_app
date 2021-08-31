package assignment.leanix.ui.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import assignment.leanix.repository.mission.models.MissionInfo;

/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 10:24 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
class AsyncDiffUtils extends DiffUtil.ItemCallback<MissionInfo> {

    @Override
    public boolean areItemsTheSame(@NonNull MissionInfo oldItem, @NonNull MissionInfo newItem) {
        return newItem.compareTo(oldItem) == 0;
    }

    @Override
    public boolean areContentsTheSame(@NonNull MissionInfo oldItem, @NonNull MissionInfo newItem) {
        return newItem.compareTo(oldItem) == 0;
    }
}
