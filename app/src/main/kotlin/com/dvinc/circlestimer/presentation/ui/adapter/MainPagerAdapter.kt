/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.dvinc.circlestimer.presentation.ui.main.DummyFragment
import com.dvinc.circlestimer.ui.laps.LapsFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    companion object {
        private const val PAGES_COUNT = 4
    }

    override fun getItem(position: Int): Fragment {
        //TODO: Replace dummy fragments
        return when(position) {
            0 -> DummyFragment()
            1 -> DummyFragment()
            2 -> DummyFragment()
            3 -> DummyFragment()
            else -> LapsFragment()
        }
    }

    override fun getCount(): Int  = PAGES_COUNT
}
