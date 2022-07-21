package data.core

import com.example.kode.domain.core.Base

data class TestReturnedModel(val name: String) : Base.IgnorantMapper<TestReturnedModel> {
    override fun <I : Base.Mapper<TestReturnedModel, R>, R> map(model: I) = model.map(this)
}