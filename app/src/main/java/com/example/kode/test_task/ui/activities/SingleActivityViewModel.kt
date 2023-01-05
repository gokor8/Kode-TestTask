package com.example.kode.test_task.ui.activities

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.core.BaseCommunication
import com.example.kode.test_task.ui.core.view_model.BaseViewModel
import javax.inject.Inject

// @params M : SingleActivityStatesUI

class SingleActivityViewModel<M : Any> @Inject constructor(
    override val communication: BaseCommunication<M>,
    private val toCommunicationMapper: Base.Mapper<String, M>,
) : BaseViewModel<BaseCommunication<M>, M>() {

    fun setSearchText(searchText: String) {
        communication.save(
            toCommunicationMapper.map(searchText)
        )
    }
}