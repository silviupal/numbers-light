package com.numberslight.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Silviu Pal on 18/02/2019.
 */
data class DetailItemModel(val name: String, val text: String, val image: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(text)
        dest.writeString(image)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<DetailItemModel> {
        override fun createFromParcel(parcel: Parcel): DetailItemModel = DetailItemModel(parcel)

        override fun newArray(size: Int): Array<DetailItemModel?> = arrayOfNulls(size)
    }
}