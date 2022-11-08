package com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.communications

import com.example.kode.test_task.ui.core.communications.BaseCommunication

interface SearchableCommunication<M> : BaseCommunication<M>, SearchableObserver<M> {

    fun saveSearch(saveModel: M)
}