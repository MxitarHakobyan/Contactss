package com.mino.contactss.ui.main.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mino.contactss.databinding.ItemContactsBinding
import com.mino.contactss.di.main.PerMain
import com.mino.contactss.ui.main.viewmodel.ContactModel
import javax.inject.Inject

@PerMain
class ContactsAdapter @Inject constructor(private val diffCallBack: ContactsDiffCallBack) :
    RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    private var contacts = arrayListOf<ContactModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemContactsBinding.inflate(layoutInflater, parent, false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    fun updateContactList(contactsList: List<ContactModel>) {
        diffCallBack.setItems(contacts, contactsList)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        contacts.clear()
        contacts.addAll(contactsList)
        diffResult.dispatchUpdatesTo(this)
    }

    class ContactViewHolder(contactsBinding: ItemContactsBinding) :
        RecyclerView.ViewHolder(contactsBinding.root) {

        var binding: ItemContactsBinding = contactsBinding

        fun bind(contactModel: ContactModel) {
            binding.model = contactModel
        }
    }
}