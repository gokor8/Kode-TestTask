package domain.core.sort.string

class TestExceptionDomainStringSortStateSuccess(sortableList: List<TestStringSortableModel>) :
    TestDomainStringSortStateSuccess(sortableList) {

    override fun copy(model: List<TestStringSortableModel>): TestDomainStringSortStateSuccess {
        return TestExceptionDomainStringSortStateSuccess(model)
    }
}