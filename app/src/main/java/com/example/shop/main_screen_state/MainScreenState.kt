package com.example.shop.main_screen_state

import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.shop.ui.MainActivity

abstract class MainScreenState(protected val activity: MainActivity) {
    abstract val container: View
    abstract val toolbar: Toolbar

    open fun show() {
        container.visibility = View.VISIBLE
        toolbar.visibility = View.VISIBLE
//        activity.fabAdapter.prepareFromMenu(toolbar.menu)
    }

    open fun hide() {
        container.visibility = View.INVISIBLE
        toolbar.visibility = View.GONE
    }
}