package domain.core.sort

import com.example.kode.domain.core.sort.SortModel
import com.example.kode.domain.core.sort.SortableState
import domain.core.TestDomainState

class TestDomainSortStateSuccess<SM : TestSortableModel<*>>(
    private val sortableList: List<SM>,
) : TestDomainState(), SortModel, SortableState<TestDomainSortStateSuccess<SM>, SM> {

    override fun getSortableList(): List<SM> = sortableList
    override fun copy(model: List<SM>) = TestDomainSortStateSuccess(model)
}