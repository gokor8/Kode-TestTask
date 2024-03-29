package domain.core.sort

import com.example.kode.domain.core.sort.SortableModel

open class TestSortableModel<SV : Any>(private val sortValue: SV) : SortableModel<SV> {

    override fun sortValue(): SV = sortValue
}