package domain.usecase.sort.mappers

import com.example.kode.domain.core.Base
import domain.core.TestDomainState
import domain.usecase.sort.TestFailSortException

class TestFailMapper : Base.Mapper<Exception, TestDomainState> {
    override fun map(model: Exception): TestDomainState =
        TestDomainState.Fail(TestFailSortException())
}