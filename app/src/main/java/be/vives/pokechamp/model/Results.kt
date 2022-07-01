package be.vives.pokechamp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results (
  var name: String,
  var url: String,
): Parcelable
