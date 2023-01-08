package com.example.kode.test_task.ui.core

import com.example.kode.domain.core.Base

class TestFailMapper<M>(private val error: String = "fail") : Base.Mapper<Exception, TestEntityStates<M>> {
    override fun map(model: Exception): TestEntityStates<M> = TestEntityStates.Fail(error)
}