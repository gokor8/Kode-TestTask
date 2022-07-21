package data.core

import com.example.kode.domain.core.Base

data class TestModel(val name: String) : Base.IgnorantMapper<TestModel> {
    override fun <I : Base.Mapper<TestModel, R>, R> map(model: I) = model.map(this)
}