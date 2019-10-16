package com.mino.contactss.ui.main.adaptors

import androidx.recyclerview.widget.DiffUtil
import com.mino.contactss.di.main.PerMain
import com.mino.contactss.ui.main.viewmodel.ContactModel
import javax.inject.Inject


@PerMain
class ContactsDiffCallBack @Inject constructor() : DiffUtil.Callback() {

    private var oldItemsList: List<ContactModel> = ArrayList()
    private var newItemsList: List<ContactModel> = ArrayList()

    fun setItems(
        oldItemsList: List<ContactModel>,
        newItemsList: List<ContactModel>
    ) {

        this.oldItemsList = oldItemsList
        this.newItemsList = newItemsList
    }

    override fun getOldListSize(): Int {
        return oldItemsList.size
    }

    override fun getNewListSize(): Int {
        return newItemsList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemsList[oldItemPosition].id.get() == newItemsList[newItemPosition].id.get()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemsList[oldItemPosition] == newItemsList[newItemPosition]
    }
}