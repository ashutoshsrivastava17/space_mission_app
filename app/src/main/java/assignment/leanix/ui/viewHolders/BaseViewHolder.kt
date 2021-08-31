package assignment.leanix.ui.viewHolders

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 9:41 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
abstract class BaseViewHolder<BEAN, VDB : ViewBinding>(var binding: VDB) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bindData(position: Int, data: BEAN)

}
