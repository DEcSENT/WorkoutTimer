/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.ui.exercise.ExerciseFragment
import com.dvinc.workouttimer.presentation.ui.settings.SettingsFragment
import com.dvinc.workouttimer.presentation.ui.timer.TimerFragment
import com.dvinc.workouttimer.presentation.ui.workout.WorkoutFragment
import kotlinx.android.synthetic.main.activity_main.activity_main_bottom_navigation as bottomNavigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()

        //Initial fragment
        replaceFragment(TimerFragment(), TimerFragment.TAG)
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            //TODO: Prevent fragment duplicate
            when (it.itemId) {
                R.id.action_timer -> {
                    replaceFragment(TimerFragment(), TimerFragment.TAG)
                    true
                }
                R.id.action_exercise -> {
                    replaceFragment(ExerciseFragment(), ExerciseFragment.TAG)
                    true
                }
                R.id.action_workout -> {
                    replaceFragment(WorkoutFragment(), WorkoutFragment.TAG)
                    true
                }
                R.id.action_settings -> {
                    replaceFragment(SettingsFragment(), SettingsFragment.TAG)
                    true
                }
                else -> true

            }
        }
    }

    private fun replaceFragment(fragment: Fragment, tag: String) {
        with(this.supportFragmentManager) {
            beginTransaction()
                    .apply {
                        setCustomAnimations(
                                R.anim.animation_fade_in,
                                R.anim.animation_fade_out,
                                R.anim.animation_fade_in,
                                R.anim.animation_fade_out
                        )
                    }
                    .replace(R.id.activity_main_fragment_container, fragment, tag)
                    .commit()
        }
    }
}
