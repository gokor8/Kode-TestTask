package domain.core

import com.example.kode.domain.core.Base
import org.junit.Test

@Deprecated("Хз че за тест, но выглядит прикольное, оставлю")
class SuperTest {

    @Test
    fun test() {
        val dataMainInfoToStringMapper = DataMainInfoToStringMapper()
        val dataSecondInfoToStringMapper = DataSecondInfoToStringMapper()
        val dataModelToStringMapper = DataModelToStringMapper()

        val infoModelToDataMainInfoMapper = MainInfoModelToDataMainInfoMapper()
        val secondInfoModelToDataSecondInfoMapper = SecondInfoModelToDataSecondInfoMapper()
        val infoModelToDataModel = InfoModelToDataModel()
        val infoModel =
            InfoModel(
                MainInfoModel(1, "a", "b"),
                SecondInfoModel(true, "aboba", "not bio yet")
            )

        val dataModel = infoModel.map(
            infoModelToDataModel,
            infoModelToDataMainInfoMapper,
            secondInfoModelToDataSecondInfoMapper
        )

        val actual = dataModel.map(dataModelToStringMapper, dataMainInfoToStringMapper, dataSecondInfoToStringMapper)

        //Assert.assertEquals("1 a b true aboba not bio yet", actual)
        println("expected 1 a b true aboba not bio yet")
        println(actual)
    }


    class MainInfoModelToDataMainInfoMapper {
        fun map(id: Int, name: String, secondName: String) = DataMainInfoModel(id, name, secondName)
    }

    class SecondInfoModelToDataSecondInfoMapper {
        fun map(sex: Boolean, description: String, bio: String) =
            DataSecondInfo(sex, description, bio)
    }

    class InfoModelToDataModel {
        fun map(
            mainInfoModelToDataMainInfoMapper: MainInfoModelToDataMainInfoMapper,
            mainRetrofitModel: MainInfoModel,
            secondInfoModelToDataSecondInfoMapper: SecondInfoModelToDataSecondInfoMapper,
            secondInfoModel: SecondInfoModel
        ): DataModel = DataModel(
            mainRetrofitModel.map(mainInfoModelToDataMainInfoMapper),
            secondInfoModel.map(secondInfoModelToDataSecondInfoMapper)
        )
    }

    class InfoModel(
        private val mainRetrofitModel: MainInfoModel,
        private val secondInfoModel: SecondInfoModel
    ) {
        fun map(
            model: InfoModelToDataModel,
            mainInfoModelToDataMainInfoMapper: MainInfoModelToDataMainInfoMapper,
            secondInfoModelToDataSecondInfoMapper: SecondInfoModelToDataSecondInfoMapper
        ) = model.map(
            mainInfoModelToDataMainInfoMapper,
            mainRetrofitModel,
            secondInfoModelToDataSecondInfoMapper,
            secondInfoModel
        )
    }

    class MainInfoModel(
        private val id: Int,
        private val name: String,
        private val secondName: String
    ) : Base.Mapper<MainInfoModelToDataMainInfoMapper, DataMainInfoModel> {
        override fun map(model: MainInfoModelToDataMainInfoMapper): DataMainInfoModel =
            model.map(id, name, secondName)
    }

    class SecondInfoModel(
        private val sex: Boolean,
        private val description: String,
        private val bio: String
    ) : Base.Mapper<SecondInfoModelToDataSecondInfoMapper, DataSecondInfo> {
        override fun map(model: SecondInfoModelToDataSecondInfoMapper): DataSecondInfo =
            model.map(sex, description, bio)
    }

    class DataMainInfoToStringMapper {
        fun map(id: Int, name: String, secondName: String) = "$id $name $secondName"
    }

    class DataSecondInfoToStringMapper {
        fun map(sex: Boolean, description: String, bio: String) = "$sex $description $bio"
    }

    class DataModelToStringMapper {
        fun map(
            dataMainInfoModel: DataMainInfoModel,
            dataMainInfoMapper: DataMainInfoToStringMapper,
            dataSecondInfo: DataSecondInfo,
            dataSecondInfoMapper: DataSecondInfoToStringMapper
        ) =
            "${dataMainInfoModel.map(dataMainInfoMapper)} ${dataSecondInfo.map(dataSecondInfoMapper)}"
    }

    class DataMainInfoModel(
        private val id: Int,
        private val name: String,
        private val secondName: String
    ) {
        fun map(mapper: DataMainInfoToStringMapper) = mapper.map(id, name, secondName)
    }

    class DataSecondInfo(
        private val sex: Boolean,
        private val description: String,
        private val bio: String
    ) {
        fun map(mapper: DataSecondInfoToStringMapper) = mapper.map(sex, description, bio)
    }

    class DataModel(
        private val dataMainInfoModel: DataMainInfoModel,
        private val dataSecondInfo: DataSecondInfo
    ) {
        fun map(
            dataModelToStringMapper: DataModelToStringMapper,
            dataMainInfoMapper: DataMainInfoToStringMapper,
            dataSecondInfoMapper: DataSecondInfoToStringMapper
        ) = dataModelToStringMapper.map(
            dataMainInfoModel,
            dataMainInfoMapper,
            dataSecondInfo,
            dataSecondInfoMapper
        )
    }

}