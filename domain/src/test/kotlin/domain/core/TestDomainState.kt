package domain.core

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.core.usecase.UseCaseModel

abstract class TestDomainState : UseCaseModel<TestDomainState> {
    override fun <I : Base.Mapper<TestDomainState, R>, R> map(model: I) = model.map(this)

    data class Success(val name: String) : TestDomainState()

    data class Fail(val useCaseExceptions: UseCaseExceptions) : TestDomainState()
}