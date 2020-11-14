package com.example.shop.main_screen_state

import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.shop.R
import com.example.shop.ui.MainActivity

class HomeState(activity: MainActivity) : MainScreenState(activity) {

    override val container: View
        get() = activity.findViewById(R.id.homeContainer)

    override val toolbar: Toolbar
        get() = activity.findViewById(R.id.toolbarHome)
}