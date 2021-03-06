package com.numberslight.main

import androidx.annotation.StringRes
import com.numberslight.base.IBasePresenter
import com.numberslight.model.ItemModel

/**
 * Created by Silviu Pal on 18/02/2019.
 */
interface MainContract {
    interface View {
        fun updateList(list: List<ItemModel>)
        fun showError(@StringRes errorRes: Int)
    }

    interface Presenter : IBasePresenter<View> {
        fun getData()
    }
}