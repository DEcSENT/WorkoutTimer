package com.dvinc.workouttimer.presentation.ui.new_exercise

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.dvinc.workouttimer.R

class NewExerciseFragment : DialogFragment() {

    companion object {

        const val TAG = "NewExerciseFragment"

        fun newInstance() = NewExerciseFragment()
    }

    override fun onStart() {
        super.onStart()
        with(dialog) {
            window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_new_exercise, container, false)
    }
}
