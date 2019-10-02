package com.zkt.app.android.resumeapp.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Project(
    val num: String,
    val Name: String,
    val Description: String
) {
}