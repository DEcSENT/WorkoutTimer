/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.main

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.common.adapter.main.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main_refactored.activity_main_bottom_navigation as bottomNavigation
import kotlinx.android.synthetic.main.activity_main_refactored.activity_main_view_pager as viewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_refactored)

        setupViewPager()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_timer -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.action_exercise -> {
                    viewPager.currentItem = 1
                    true
                }
                R.id.action_workout -> {
                    viewPager.currentItem = 2
                    true
                }
                R.id.action_settings -> {
                    viewPager.currentItem = 3
                    true
                }
                else -> true

            }
        }
    }

    private fun setupViewPager() {
        viewPager.adapter = MainPagerAdapter(supportFragmentManager)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                bottomNavigation.menu.getItem(position).isChecked = true
            }
        })
    }
}
