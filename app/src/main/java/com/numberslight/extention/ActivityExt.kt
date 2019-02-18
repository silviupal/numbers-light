package com.numberslight.extention

import android.app.Activity
import android.widget.Toast

/**
 * Created by Silviu Pal on 18/02/2019.
 */
fun Activity.showToast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}