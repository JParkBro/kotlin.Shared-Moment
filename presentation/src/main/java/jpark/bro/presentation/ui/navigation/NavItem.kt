package jpark.bro.presentation.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import jpark.bro.presentation.R

sealed class NavItem(val route: String, @StringRes val label: Int) {
    class BottomItem(route: String, @StringRes label: Int, @DrawableRes val selectedIcon: Int, @DrawableRes val unselectedIcon: Int) : NavItem(route, label)
    class NonBottomItem(route: String, @StringRes label: Int) : NavItem(route, label)

    companion object {
        val Home = BottomItem("home", R.string.home, R.drawable.baseline_home_24, R.drawable.outline_home_24)
        val Calendar = BottomItem("calendar", R.string.calendar, R.drawable.baseline_calendar_month_24, R.drawable.outline_calendar_month_24)
        val Settings = BottomItem("settings", R.string.settings, R.drawable.baseline_settings_24, R.drawable.outline_settings_24)
    }
}