package com.example.kode.test_task.ui.core.search

import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MixSearchCommunication
import com.example.kode.test_task.ui.core.view_model.BaseViewModel

abstract class SearchViewModel<C : MixSearchCommunication<M>, M : Any, IM : Any> :
    BaseViewModel<C, M>(), UISearch<IM>