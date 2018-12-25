/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import com.dvinc.workouttimer.R
import kotlinx.android.synthetic.main.activity_main.activity_main_bottom_navigation as bottomNavigation
import kotlinx.android.synthetic.main.activity_main.activity_main_fragment_container as fragmentContainer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            //TODO: Prevent fragment duplicate
            when (it.itemId) {
                R.id.action_timer -> {
                    findNavController(this@MainActivity, R.id.navigation_host_fragment)
                            .navigate(R.id.action_global_timerFragment)
                    true
                }
                R.id.action_exercise -> {
                    findNavController(this@MainActivity, R.id.navigation_host_fragment)
                            .navigate(R.id.action_global_exerciseFragment)
                    //replaceFragment(ExerciseFragment(), ExerciseFragment.TAG)
                    true
                }
                R.id.action_workout -> {
                    findNavController(this@MainActivity, R.id.navigation_host_fragment)
                            .navigate(R.id.action_global_workoutFragment)
                    true
                }
                R.id.action_settings -> {
                    findNavController(this@MainActivity, R.id.navigation_host_fragment)
                            .navigate(R.id.action_global_settingsFragment)
                    true
                }
                else -> true

            }
        }
    }
}
