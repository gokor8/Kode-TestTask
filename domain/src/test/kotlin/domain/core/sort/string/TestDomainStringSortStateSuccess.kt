package domain.core.sort.string

import com.example.kode.domain.entity.sort.by_string.StringSortableState
import domain.core.TestDomainState

open class TestDomainStringSortStateSuccess(private val sortableList: List<TestStringSortableModel>) :
    TestDomainState(), StringSortableState<TestDomainStringSortStateSuccess, TestStringSortableModel> {

    override fun copy(model: List<TestStringSortableModel>): TestDomainStringSortStateSuccess {
        return TestDomainStringSortStateSuccess(model)
    }

    override fun getSortableList(): List<TestStringSortableModel> = sortableList
}