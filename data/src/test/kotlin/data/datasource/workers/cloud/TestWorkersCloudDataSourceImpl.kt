package com.example.kode.data.datasource.workers.cloud

import com.example.kode.data.TestModel
import com.example.kode.data.TestReturnedModel
import com.example.kode.data.datasource.workers.cloud.service.WorkersService
import com.example.kode.data.repository.workers.models.WorkersDataModel
import com.example.kode.domain.core.Base
import org.junit.Assert
import org.junit.Test

class TestWorkersCloudDataSourceImpl {

    private val apiService: TestWorkersService = TestWorkersService()
    private val testModelToTestReturnedModelMapper = TestModelToTestReturnedModelMapper()

    @Test
    fun `test get success data from api`() {
        val workersCloudDataSource = WorkersCloudDataSourceImpl(
            apiService,
            testModelToTestReturnedModelMapper
        )

        val expected = TestReturnedModel("mapped cloud test")
        val actual = workersCloudDataSource.get()

        Assert.assertEquals(expected, actual)
    }

    class TestWorkersService : WorkersService<TestModel> {
        override fun getWorkers(): TestModel = TestModel(
            "cloud test"
        )
    }

    class TestModelToTestReturnedModelMapper : Base.Mapper<TestModel, TestReturnedModel> {

        override fun map(model: TestModel): TestReturnedModel = TestReturnedModel(
            "mapped ${model.name}"
        )
    }
}