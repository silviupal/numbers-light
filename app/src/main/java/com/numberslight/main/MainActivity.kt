package com.numberslight.main

import com.numberslight.R
import com.numberslight.base.BaseActivity

class MainActivity : BaseActivity(), MainContract.View {
    override fun getLayoutId(): Int = R.layout.activity_main
}
