package com.sdu.skillcinema.navigation

import androidx.annotation.DrawableRes
import com.sdu.skillcinema.R

sealed class BottomNavItem(
    @DrawableRes val iconId: Int,
    val route: String
) {
    data object Homepage: BottomNavItem(R.drawable.ic_home, "homepage")
    data object Search: BottomNavItem(R.drawable.ic_search, "search")
    data object Profile: BottomNavItem(R.drawable.ic_profile, "profile")
}