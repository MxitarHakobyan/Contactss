package com.mino.contactss.ui.common.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

object BindingAdaptor {

    @JvmStatic
    @BindingAdapter(value = ["swipeEnabled", "onItemClickListener"], requireAll = false)
    fun setItemClickToRecyclerView(
        recyclerView: RecyclerView,
        swipeEnabled: Boolean,
        onItemClick: ClickItemHelperCallback.OnItemClickListener
    ) {

        val swipeCallback =
            ClickItemHelperCallback.Builder(0, ItemTouchHelper.DOWN)
                .setOnItemClickListener(onItemClick)
                .setSwipeEnabled(swipeEnabled)
                .build()

        val itemTouchHelper = ItemTouchHelper(swipeCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}