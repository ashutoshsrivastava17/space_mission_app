package assignment.leanix.ui.viewHolders

import assignment.leanix.databinding.ItemImageBinding
import com.bumptech.glide.Glide


/**
 * Created by Ashutosh Srivastava on 31-Aug-2021 4:23 AM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
class ImageViewHolder(binding: ItemImageBinding) :
    BaseViewHolder<String, ItemImageBinding>(binding) {
    override fun bindData(position: Int, data: String) {
        Glide.with(binding.ivImage.context).load(data)
            .into(binding.ivImage)
    }
}