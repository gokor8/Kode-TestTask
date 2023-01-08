package com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications

import com.example.kode.domain.core.Notify
import com.example.kode.domain.core.Read
import com.example.kode.test_task.ui.core.search.SearchCommunication
import com.example.kode.test_task.ui.core.search.states.UISearchState
import com.example.kode.test_task.ui.core.communications.NullableBaseCommunication

interface MixSearchCommunication<M : Any, SM : UISearchState> : NullableBaseCommunication<M>,
    SearchCommunication<SM>, Read.Abstract.Base<M?>, Notify