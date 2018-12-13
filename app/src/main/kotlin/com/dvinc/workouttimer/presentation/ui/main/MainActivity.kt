/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.dvinc.workouttimer.R
import kotlinx.android.synthetic.main.activity_main.activity_main_bottom_navigation as bottomNavigation
import kotlinx.android.synthetic.main.activity_main.activity_main_fragment_container as fragmentContainer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()

        //TODO: Replace DummyFragments
        replaceFragment(DummyFragment(), "Replace me")
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            //TODO: Prevent fragment duplicate
            when (it.itemId) {
                R.id.action_timer -> {
                    replaceFragment(DummyFragment(), "Replace me")
                    true
                }
                R.id.action_exercise -> {
                    findNavController(this@MainActivity, R.id.navigation_host_fragment)
                            .navigate(R.id.action_global_exerciseFragment)
                    //replaceFragment(ExerciseFragment(), ExerciseFragment.TAG)
                    true
                }
                R.id.action_workout -> {
                    //replaceFragment(WorkoutFragment(), WorkoutFragment.TAG)
                    findNavController(this@MainActivity, R.id.navigation_host_fragment)
                            .navigate(R.id.action_global_workoutFragment)
                    true
                }
                R.id.action_settings -> {
                    replaceFragment(DummyFragment(), "Replace me 2")
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
