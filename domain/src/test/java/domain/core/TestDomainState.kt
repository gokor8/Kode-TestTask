package domain.core

import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.core.usecase.UseCaseModel

abstract class TestDomainState : UseCaseModel {
    data class Success(val name: String) : TestDomainState()

    data class Fail(val useCaseExceptions: UseCaseExceptions) : TestDomainState()
}