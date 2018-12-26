/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.dvinc.workouttimer.R
import kotlinx.android.synthetic.main.activity_main.activity_main_bottom_navigation as bottomNavigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navController = findNavController(R.id.activity_main_navigation_host_fragment)
        bottomNavigation.setupWithNavController(navController)
    }
}
