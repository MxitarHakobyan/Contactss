package com.mino.contactss.ui.main

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mino.contactss.R
import com.mino.contactss.databinding.ActivityMainBinding
import com.mino.contactss.ui.common.binding.OnItemClickedListener
import com.mino.contactss.ui.common.viewmodels_factory.ViewModelsProviderFactory
import com.mino.contactss.ui.main.adaptors.ContactsAdapter
import com.mino.contactss.ui.main.viewmodel.ContactsViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), OnItemClickedListener {
    @Inject
    lateinit var viewModelFactory: ViewModelsProviderFactory

    @Inject
    lateinit var adapter: ContactsAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)


        val viewModel: ContactsViewModel =
            ViewModelProvider(this, viewModelFactory).get(ContactsViewModel::class.java)


        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setUpRecyclerView()

        viewModel.getContacts().observe(this, Observer {
            adapter.updateContactList(it)
        })
    }

    private fun setUpRecyclerView() {
        recyclerView = findViewById(R.id.rv)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun itemClicked(position: Int) {
        Log.d("abc", "abc")
    }
}
