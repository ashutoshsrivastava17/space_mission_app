package assignment.leanix.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import assignment.leanix.ui.viewHolders.BaseViewHolder
import java.util.*


/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 9:38 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
abstract class BaseRecyclerAdapter<BEAN, VB : ViewBinding?, VH : BaseViewHolder<BEAN, *>?>(var context: Context) :
    RecyclerView.Adapter<VH>() {

    private var listener: OnItemClickListener<BEAN>? = null
    private var items: MutableList<BEAN> = ArrayList()
    private var mDiffer: AsyncListDiffer<BEAN>? = getDiffUtils()

    open fun getDiffUtils(): AsyncListDiffer<BEAN>? {
        return null
    }

    abstract fun getViewHolder(binding: VB): VH

    abstract fun getBinding(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): VB

//    protected abstract fun getLayoutId(viewType: Int): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding: VB = getBinding(LayoutInflater.from(parent.context), parent, viewType);
        return getViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val bean = getItemAtPosition(position)
        holder!!.bindData(position, bean)
        if (defaultListenerEnabled())
            holder.itemView.setOnClickListener { listener?.onItemClicked(position, bean) }
    }

    open fun getItemAtPosition(position: Int): BEAN {
        return if (mDiffer == null) items[position] else mDiffer!!.currentList[position]
    }

    open fun defaultListenerEnabled(): Boolean {
        return false
    }

    override fun getItemCount(): Int {
        return if (mDiffer == null) items.size else mDiffer!!.currentList.size
    }

    open fun getItems(): MutableList<BEAN> {
        return if (mDiffer == null) items else mDiffer!!.currentList
    }

    fun addItems(newItems: Collection<BEAN>?) {
        addItems(newItems, false)
    }

    fun addItems(newItems: Collection<BEAN>?, refresh: Boolean) {
        if (refresh) this.items.clear()
        if (newItems != null) {
            for (newItem: BEAN in newItems) {
                addItem(newItem)
            }
        }
    }

    fun addItem(newItem: BEAN?) {
        if (newItem != null) {
            items.add(newItem)
            notifyItemInserted(items.size - 1)
        }
    }

    fun removeItemAtPosition(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }

    fun publishResults(newItems: Collection<BEAN>?) {
        mDiffer?.submitList(newItems as MutableList<BEAN>?)
    }

    fun setOnItemClickListener(listener: OnItemClickListener<BEAN>) {
        this.listener = listener
    }

    interface OnItemClickListener<BEAN> {
        fun onItemClicked(position: Int, bean: BEAN?)
    }
}