package com.dvinc.workouttimer.presentation.ui.new_exercise

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.common.application.WorkoutApp
import javax.inject.Inject
import kotlinx.android.synthetic.main.dialog_new_exercise.dialog_new_exercise_background as dialogBackground
import kotlinx.android.synthetic.main.dialog_new_exercise.dialog_new_exercise_cancel_button as cancelButton

class NewExerciseFragment : DialogFragment(), NewExerciseView {

    companion object {

        const val TAG = "NewExerciseFragment"

        fun newInstance() = NewExerciseFragment()
    }

    @Inject
    internal lateinit var presenter: NewExercisePresenter

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
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        injectPresenter()
        setupBackground()
        setupCancelButton()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        clearDependencies()
    }

    private fun injectPresenter() {
        context?.let {
            WorkoutApp.get(it).getNewExerciseComponent()?.inject(this)
        }
    }

    private fun clearDependencies() {
        context?.let {
            WorkoutApp.get(it).clearNewExerciseComponent()
        }
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
