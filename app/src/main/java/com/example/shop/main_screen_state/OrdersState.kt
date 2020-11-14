package com.example.shop.main_screen_state

import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.shop.R
import com.example.shop.ui.MainActivity
import com.google.android.material.tabs.TabLayout

class OrdersState(activity: MainActivity) : MainScreenState(activity) {

    private val ordersTab = activity.findViewById<TabLayout>(R.id.ordersTabs)

    override val container: View
        get() = activity.findViewById(R.id.ordersContainer)

    override val toolbar: Toolbar
        get() = activity.findViewById(R.id.toolbarOrders)

    override fun show() {
        super.show()
        ordersTab.visibility = View.VISIBLE
    }

    override fun hide() {
        super.hide()
        ordersTab.visibility = View.GONE
    }
}