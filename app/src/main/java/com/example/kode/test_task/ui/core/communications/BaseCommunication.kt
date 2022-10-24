package com.example.kode.test_task.ui.core.communications

import com.example.kode.domain.core.Read
import com.example.kode.domain.core.Save
import com.example.kode.test_task.ui.core.BaseObserver

interface BaseCommunication<M> : BaseObserver<M>, Save.Base<M, Unit>, Read.Abstract.Base<M>