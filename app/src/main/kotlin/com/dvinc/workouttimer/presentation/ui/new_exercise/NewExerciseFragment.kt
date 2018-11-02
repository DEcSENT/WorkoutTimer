package com.dvinc.workouttimer.presentation.ui.new_exercise

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.dvinc.workouttimer.R
import kotlinx.android.synthetic.main.dialog_new_exercise.dialog_new_exercise_background as dialogBackground
import kotlinx.android.synthetic.main.dialog_new_exercise.dialog_new_exercise_cancel_button as cancelButton

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBackground()
        setupCancelButton()
    }

    private fun setupCancelButton() {
        cancelButton.setOnClickListener {
            dismiss()
        }
    }

    private fun setupBackground() {
        dialogBackground.setOnClickListener {
            dismiss()
        }
    }
}
