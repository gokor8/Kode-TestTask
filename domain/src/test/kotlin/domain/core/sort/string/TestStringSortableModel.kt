package domain.core.sort.string

import com.example.kode.domain.entity.sort.by_string.StringSortableModel
import domain.core.sort.TestSortableModel

class TestStringSortableModel(sortValue: String) : TestSortableModel<String>(sortValue), StringSortableModel