package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import androidx.annotation.CallSuper
import com.example.kode.domain.core.Base
import com.example.kode.test_task.R
import com.google.android.material.snackbar.Snackbar

sealed interface MainStatesUI {

    sealed class Success<I : UISuccessModel>(protected val workers: List<WorkerInfoUIModel>) :
        MainStatesUI, Base.Mapper<I, Unit> {

        @CallSuper
        override fun map(model: I) {
            model.adapter.submitList(workers)
        }

        class Cloud(
            workers: List<WorkerInfoUIModel>
        ) : Success<UISuccessModel>(workers)

        class Cache(
            workers: List<WorkerInfoUIModel>
        ) : Success<UICacheSuccessModel>(workers) {
            override fun map(model: UICacheSuccessModel) = with(model) {
                super.map(this)
                Snackbar.make(
                    view,
                    context.resources.getString(R.string.no_connection),
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    sealed class Fail : MainStatesUI {
        class UsualError(val errorId: Int) : Fail(), Base.Mapper<UIUsualErrorModel, Unit> {
            override fun map(model: UIUsualErrorModel) = with(model) {
                Snackbar.make(
                    view,
                    context.resources.getString(errorId),
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        class FatalError : Fail()
    }
}