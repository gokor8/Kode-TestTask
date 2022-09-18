package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.ui.core.BaseCommunication
import com.example.kode.test_task.ui.core.BaseViewModelFactory
import javax.inject.Inject

class MainViewModelFactory<M : Any, EM : UseCaseModel<EM>> @Inject constructor(
    private val communication: BaseCommunication<M>,
    private val mapper: Base.Mapper<EM, M>,
    private val useCase: GetWorkersUseCase<EM>,
) : BaseViewModelFactory<MainViewModel<*, *>> {

    override val modelClass = MainViewModel::class.java

    override fun createViewModel() = MainViewModel(communication, mapper, useCase)
}