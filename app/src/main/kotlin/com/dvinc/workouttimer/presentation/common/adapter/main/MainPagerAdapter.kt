/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.common.adapter.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.dvinc.workouttimer.presentation.ui.exercise.ExerciseFragment
import com.dvinc.workouttimer.presentation.ui.main.DummyFragment
import com.dvinc.workouttimer.presentation.ui.workout.WorkoutFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    companion object {
        private const val PAGES_COUNT = 4
    }

    override fun getItem(position: Int): Fragment {
        //TODO: Replace dummy fragments
        return when(position) {
            0 -> DummyFragment()
            1 -> ExerciseFragment()
            2 -> WorkoutFragment()
            3 -> DummyFragment()
            else -> DummyFragment()
        }
    }

    override fun getCount(): Int  = PAGES_COUNT
}
