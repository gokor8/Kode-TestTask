package domain.core.sort.string

class TestExceptionDomainStringSortStateSuccess(sortableList: List<TestStringSortableModel>) :
    TestDomainStringSortStateSuccess(sortableList) {

    override fun copyByModel(model: List<TestStringSortableModel>): TestDomainStringSortStateSuccess {
        return TestExceptionDomainStringSortStateSuccess(model)
    }
}