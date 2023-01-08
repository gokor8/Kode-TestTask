package com.example.kode.test_task.ui.core

import com.example.kode.domain.core.usecase.UseCaseModel

sealed interface TestEntityStates<SM> : UseCaseModel {

    abstract class Success<SM>(val model: SM) : TestEntityStates<SM>

    class WithConnection<SM>(id: SM) : Success<SM>(id)
    class NoConnection<SM>(id: SM) : Success<SM>(id)
    class Fail<SM>(val error: String) : TestEntityStates<SM>
}