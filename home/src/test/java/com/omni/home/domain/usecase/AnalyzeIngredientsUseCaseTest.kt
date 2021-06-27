package com.omni.home.domain.usecase

import com.omni.core.model.ServerErrorResponseModel
import com.omni.core.wrapper.ResponseWrapper
import com.omni.home.data.model.request.IngredientRequestModel
import com.omni.home.data.model.response.NutritionAnalyzeResponse
import com.omni.home.data.repository.HomeRepositoryImp
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Response


class AnalyzeIngredientsUseCaseTest {

    private lateinit var useCase: AnalyzeIngredientsUseCase
    private val mockRepo = Mockito.mock(HomeRepositoryImp::class.java)
    private val mockResponseEntity = Mockito.mock(NutritionAnalyzeResponse::class.java)
    private val mockErrorResponseEntity = Mockito.mock(ServerErrorResponseModel::class.java)

    @Before
    fun setUp() {
        useCase = AnalyzeIngredientsUseCase(mockRepo)
    }

    @Test
    fun `test AnalyzeIngredientsUseCase returns code Success`() {

        val response = ResponseWrapper.Success(mockResponseEntity)
        val ingredientModel =
            IngredientRequestModel(ingr = listOf("150 g Wheat", "120 g Mushroom"))

        runBlockingTest {
            Mockito.`when`(mockRepo.analyzeFood(ingredientModel)).thenReturn(response)
            val result = useCase.invoke(ingredientModel)
            Assert.assertEquals(result, response)
        }
    }

    @Test
    fun `test AnalyzeIngredientsUseCase returns code ServerError`() {

        val response = ResponseWrapper.ServerError(mockErrorResponseEntity)
        val ingredientModel =
            IngredientRequestModel(ingr = listOf("MILK"))

        runBlockingTest {
            Mockito.`when`(mockRepo.analyzeFood(ingredientModel)).thenReturn(response)
            val result = useCase.invoke(ingredientModel)
            Assert.assertEquals(result, response)
        }
    }

    @Test
    fun `test AnalyzeIngredientsUseCase returns code UnhandledHTTPCode`() {

        val response = ResponseWrapper.UnhandledHTTPCode(532)
        val ingredientModel =
            IngredientRequestModel(ingr = listOf("string"))

        runBlockingTest {
            Mockito.`when`(mockRepo.analyzeFood(ingredientModel)).thenReturn(response)
            val result = useCase.invoke(ingredientModel)
            Assert.assertEquals(result, response)
        }
    }
}