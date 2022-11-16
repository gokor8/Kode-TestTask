package com.example.kode.test_task.ui.core

import com.example.kode.domain.core.Base

sealed class TestEntityStates : Base.IgnorantMapper<TestEntityStates>{

    override fun <I : Base.Mapper<TestEntityStates, R>, R> map(model: I) = model.map(this)

    class Success(val id: String) : TestEntityStates()
    class Fail(val error: String) : TestEntityStates()
    class NoConnection(val id: String) : TestEntityStates()
}