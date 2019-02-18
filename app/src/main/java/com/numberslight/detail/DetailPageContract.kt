package com.numberslight.detail

import androidx.annotation.StringRes
import com.numberslight.base.IBasePresenter
import com.numberslight.model.DetailItemModel

/**
 * Created by Silviu Pal on 18/02/2019.
 */
interface DetailPageContract {
    interface View {
        fun updateUI(item: DetailItemModel)
        fun showError(@StringRes errorRes: Int)
    }

    interface Presenter : IBasePresenter<View> {
        fun getData(name: String)
    }
}