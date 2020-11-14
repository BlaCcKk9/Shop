package com.example.shop.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
import com.aurelhubert.ahbottomnavigation.notification.AHNotification
import com.example.shop.R
import com.example.shop.main_screen_state.HomeState
import com.example.shop.main_screen_state.MainScreenState
import com.example.shop.main_screen_state.OrdersState
import com.example.shop.main_screen_state.ProfileState
import com.example.shop.presenter.MainPresenter
import com.example.shop.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.presenter.InjectPresenter

class MainActivity : BaseActivityView(), MainView {

    companion object {
        fun createIntent(context: Context, openOrders: Boolean = false): Intent =
            Intent(context, MainActivity::class.java)
    }

    @InjectPresenter
    override lateinit var presenter: MainPresenter

    private var state: MainScreenState? = null
        set(value) {
            field?.hide()
            value?.show()
            field = value
        }

    override fun getLayoutResID(): Int = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {
        setupToolbars()
        setupNavigationView()
        openHomePage()
    }

    private fun setupToolbars() {
        setupToolbar(toolbarHome, null, supportFragmentManager.findFragmentById(R.id.homeFragment) as BaseMainNavigationFragment)
        setupToolbar(toolbarOrders, null, supportFragmentManager.findFragmentById(R.id.ordersFragment) as BaseMainNavigationFragment)
        setupToolbar(toolbarProfile, null, supportFragmentManager.findFragmentById(R.id.profileFragment) as BaseMainNavigationFragment)
    }

    private fun setupToolbar(toolbar: Toolbar, menuResId: Int?, fragment: BaseMainNavigationFragment) {
        menuResId?.let { toolbar.inflateMenu(menuResId) }
        toolbar.setOnMenuItemClickListener(fragment)
        fragment.toolbar = toolbar
    }

    private fun setupNavigationView(){
        val navigationAdapter = AHBottomNavigationAdapter(this, R.menu.menu_activity_main)
            .apply { setupWithBottomNavigation(navigationView) }
        navigationView.apply {
            isBehaviorTranslationEnabled = false
            accentColor = ContextCompat.getColor(this@MainActivity, R.color.bottom_nav_color)
            for (index in 0 until itemsCount - 1)
                setNotification(AHNotification(), index)
            titleState = AHBottomNavigation.TitleState.ALWAYS_HIDE
            setOnTabSelectedListener { position, _ ->
                onNavigationItemSelected(navigationAdapter.getMenuItem(position))
            }
        }
    }

    private fun onNavigationItemSelected(menuItem: MenuItem) =
        when (menuItem.itemId) {
            R.id.navigationItemHome -> {
                presenter.onHomeSelected()
                true
            }
            R.id.navigationItemOrders -> {
                presenter.onOrdersSelected()
                true
            }
            R.id.navigationItemProfile -> {
                presenter.onProfileSelected()
                true
            }
            else -> false
        }

    override fun openHomePage() {
        state = HomeState(this)
    }

    override fun openOrdersPage() {
        state = OrdersState(this)
    }

    override fun openProfilePage() {
        state = ProfileState(this)
    }

}