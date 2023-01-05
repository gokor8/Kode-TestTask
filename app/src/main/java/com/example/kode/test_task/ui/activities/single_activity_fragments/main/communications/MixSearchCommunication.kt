package com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications

import com.example.kode.domain.core.Notify
import com.example.kode.domain.core.Read
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.temp_searchable.SearchCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.temp_searchable.UISearchState
import com.example.kode.test_task.ui.core.NullableBaseCommunication

interface MixSearchCommunication<M : Any> : NullableBaseCommunication<M>,
    SearchCommunication<UISearchState>, Read.Abstract.Base<M?>, Notify