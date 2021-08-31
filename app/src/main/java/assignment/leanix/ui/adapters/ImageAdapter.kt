package assignment.leanix.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import assignment.leanix.databinding.ItemImageBinding
import assignment.leanix.ui.viewHolders.ImageViewHolder


/**
 * Created by Ashutosh Srivastava on 31-Aug-2021 4:20 AM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
class ImageAdapter(context: Context) :
    BaseRecyclerAdapter<String, ItemImageBinding, ImageViewHolder>(context) {
    override fun getViewHolder(binding: ItemImageBinding): ImageViewHolder {
        return ImageViewHolder(binding)
    }

    override fun getBinding(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int,
    ): ItemImageBinding {
        return ItemImageBinding.inflate(layoutInflater, parent, false)
    }
}