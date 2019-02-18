package com.numberslight.main

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.numberslight.App
import com.numberslight.Constants
import com.numberslight.R
import com.numberslight.base.BaseActivity
import com.numberslight.detail.DetailPageActivity
import com.numberslight.extention.showToast
import com.numberslight.listener.ItemClickListener
import com.numberslight.model.ItemModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View, ItemClickListener {
    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var adapter: RvAdapter
    private lateinit var list: List<ItemModel>

    init {
        App.instance.apiComponent.inject(this)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        initRecyclerView()

        if (savedInstanceState != null) {
            val array = savedInstanceState.getParcelableArrayList<ItemModel>(Constants.SAVED_LIST_ITEMS)
            array?.let {
                updateList(it.toList())
            }
        } else {
            presenter.attachPresenter(this)
            presenter.getData()
        }
    }

    private fun initAdapter() {
        adapter = RvAdapter(this)
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun updateList(list: List<ItemModel>) {
        this.list = list
        adapter.setList(list)
        adapter.notifyDataSetChanged()
    }

    override fun onItemClick(item: ItemModel) {
        val intent = Intent(this, DetailPageActivity::class.java)
        intent.putExtra(Constants.EXTRA_ITEM, item)
        startActivity(intent)
    }

    override fun showError(errorRes: Int) {
        showToast(getString(errorRes))
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (::list.isInitialized) {
            outState?.putParcelableArrayList(Constants.SAVED_LIST_ITEMS, ArrayList(list))
        }
    }
}
