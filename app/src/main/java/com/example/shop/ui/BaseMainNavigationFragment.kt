package com.example.shop.ui

import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

abstract class BaseMainNavigationFragment : BaseFragmentView(), Toolbar.OnMenuItemClickListener {
    var toolbar: Toolbar? = null
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return false
    }
}