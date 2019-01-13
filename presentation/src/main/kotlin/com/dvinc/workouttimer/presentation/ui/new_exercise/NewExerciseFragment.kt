package com.dvinc.workouttimer.presentation.ui.new_exercise

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.common.extension.obtainViewModel
import com.dvinc.workouttimer.presentation.common.viewmodel.ViewModelFactory
import com.dvinc.workouttimer.presentation.di.provider.DiProvider
import com.dvinc.workouttimer.presentation.ui.base.BaseDialogFragment
import javax.inject.Inject
import kotlinx.android.synthetic.main.dialog_new_exercise.dialog_new_exercise_background as dialogBackground
import kotlinx.android.synthetic.main.dialog_new_exercise.dialog_new_exercise_cancel_button as cancelButton

class NewExerciseFragment : BaseDialogFragment() {

    companion object {

        const val TAG = "NewExerciseFragment"

        fun newInstance() = NewExerciseFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var newExerciseViewModel: NewExerciseViewModel

    override fun getFragmentLayoutId() = R.layout.dialog_new_exercise

    override fun onStart() {
        super.onStart()
        with(dialog) {
            window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setupBackground()
        setupCancelButton()
    }

    override fun initViewModel() {
        newExerciseViewModel = obtainViewModel(viewModelFactory)
    }

    override fun injectDependencies() {
        context?.let {
            DiProvider.getNewExerciseComponent()?.inject(this)
        }
    }

    override fun clearDependencies() {
        DiProvider.clearNewExerciseComponent()
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
