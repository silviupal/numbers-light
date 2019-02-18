package com.numberslight.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Silviu Pal on 18/02/2019.
 */
data class ItemModel(val name: String, val image: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(image)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ItemModel> {
        override fun createFromParcel(parcel: Parcel): ItemModel = ItemModel(parcel)

        override fun newArray(size: Int): Array<ItemModel?> = arrayOfNulls(size)
    }
}