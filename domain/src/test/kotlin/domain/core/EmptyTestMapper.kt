package domain.core

import com.example.kode.domain.core.Base

open class EmptyTestMapper<I> : Base.Mapper<I, I> {
    override fun map(model: I): I = model
}