package data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.mappers.LWorkerInfoDataModelToRealmMapper
import com.example.kode.data.datasource.workers.cache.mappers.WorkerInfoDataModelToRealmMapper
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import org.junit.Test

class TestLWorkerInfoDataModelToRealmMapper {

    @Test
    fun`test mapper`() {
        val mapper = WorkerInfoDataModelToRealmMapper()
        val listMapper = LWorkerInfoDataModelToRealmMapper(mapper)
    }
}