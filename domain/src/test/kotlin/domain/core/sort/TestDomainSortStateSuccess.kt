package domain.core.sort

import com.example.kode.domain.core.sort.SortModel
import com.example.kode.domain.core.sort.SortableState
import domain.core.TestDomainState

class TestDomainSortStateSuccess<SV : Any>(private val sortableList: List<TestSortableModel<SV>>) :
    TestDomainState(), SortModel, SortableState<List<TestSortableModel<SV>>, TestSortableModel<SV>> {

    override fun getSortableList(): List<TestSortableModel<SV>> = sortableList
}