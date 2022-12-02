package domain.usecase.sort.mappers

import com.example.kode.domain.core.Base
import domain.core.TestDomainState
import domain.core.sort.TestDomainSortStateFail
import domain.core.sort.string.TestDomainStringSortStateSuccess
import domain.core.sort.string.TestExceptionDomainStringSortStateSuccess
import java.io.IOException

class TestToNormalStateMapper : Base.Mapper<TestDomainStringSortStateSuccess, TestDomainState> {
    override fun map(model: TestDomainStringSortStateSuccess): TestDomainState {
        if (model is TestExceptionDomainStringSortStateSuccess) {
            throw IOException("Was gave exception model")
        }

        return if (model.getSortableList().isNotEmpty()) {
            TestDomainStringSortStateSuccess(model.getSortableList())
        } else {
            TestDomainSortStateFail()
        }
    }
}