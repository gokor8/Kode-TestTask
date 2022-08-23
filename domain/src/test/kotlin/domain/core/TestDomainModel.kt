package domain.core

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.core.usecase.UseCaseModel

sealed class TestDomainModel : UseCaseModel<TestDomainModel> {
    override fun <I : Base.Mapper<TestDomainModel, R>, R> map(model: I) = model.map(this)

    data class Success(val name: String) : TestDomainModel()

    data class Fail(val exceptions: Exceptions) : TestDomainModel()
}