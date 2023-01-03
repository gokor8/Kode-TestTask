package domain.core

import com.example.kode.domain.core.Base

open class EmptyTestMapper<I : IR, IR> : Base.Mapper<I, IR> {
    override fun map(model: I): IR = model
}