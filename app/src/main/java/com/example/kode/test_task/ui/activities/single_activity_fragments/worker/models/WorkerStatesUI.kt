package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models

import com.example.kode.domain.core.Base

sealed interface WorkerStatesUI {

    class Success(
        val avatarUrl: String,
        val firstName: String,
        val lastName: String,
        val userTag: String,
        val department: String,
        val position: String,
        val birthday: List<String>,
        val phone: String,
    ) : WorkerStatesUI

    // TODO нарушение dry, поудмтаь как вынести
    sealed class Fail : WorkerStatesUI {
        class UsualError(val errorId: Int) : Fail(), Base.IgnorantMapper<Int> {
            override fun <I : Base.Mapper<Int, R>, R> map(model: I): R = model.map(errorId)
        }

        class FatalError : Fail()
    }
}