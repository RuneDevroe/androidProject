package be.vives.pokechamp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User(var username: String, var name: String, var password: String):Parcelable {
}