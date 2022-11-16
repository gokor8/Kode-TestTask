package com.example.kode.test_task.ui.core

import com.example.kode.domain.core.Save

interface BaseCommunication<M : Any> : BaseObserver<M>, Save.Base<M, Unit>