package com.mino.contactss.ui.common.binding

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class ClickItemHelperCallback private constructor(
    dragDirs: Int,
    swipeDirs: Int
) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

    private lateinit var onItemClickListener: OnItemClickListener
    private var swipeEnabled: Boolean = false

    private constructor(builder: Builder) : this(builder.dragDirs, builder.swipeDirs) {
        onItemClickListener = builder.onItemClickListener!!
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return swipeEnabled
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        if (direction == ItemTouchHelper.DOWN) {
            onItemClickListener.onItemSwiped(position)
        }
    }

    interface OnItemClickListener {
        fun onItemSwiped(position: Int)
    }

    class Builder(val dragDirs: Int, val swipeDirs: Int) {
        var onItemClickListener: OnItemClickListener? = null
        var swipeEnabled: Boolean = false


        fun setOnItemClickListener(`val`: OnItemClickListener): Builder {
            onItemClickListener = `val`
            return this
        }

        fun setSwipeEnabled(`val`: Boolean): Builder {
            swipeEnabled = `val`
            return this
        }

        fun build(): ClickItemHelperCallback {
            return ClickItemHelperCallback(this)
        }
    }

}