package com.omni.total_nutrition.presentation.viewmodel

import app.cash.turbine.test
import com.omni.analysis_shared_data.data.model.response.CustomNutritionDataModel
import com.omni.analysis_shared_data.data.model.response.NutritionAnalyzeResponse
import com.omni.analysis_shared_data.data.model.response.TotalDaily
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TotalNutritionViewModelTest {
    private val _result: MutableStateFlow<NutritionAnalyzeResponse?> = MutableStateFlow(null)
    private val result = _result.asStateFlow()
    private lateinit var response: NutritionAnalyzeResponse


    @Before
    fun setUp() {
        val totalDaily = TotalDaily(
            eNERCKCAL = CustomNutritionDataModel("Energy", 2.0, "%"),
            fE = CustomNutritionDataModel("Iron", 2.0, "%")
        )
        response =
            NutritionAnalyzeResponse(calories = 148, totalWeight = 244, totalDaily = totalDaily)
    }

    @Test
    fun `should emit default value`() = runBlockingTest {
        _result.emit(null)
        result
            .test {
                assertNull(expectItem())
            }
    }

    @Test
    fun `should emit new value And not emit default value`() =
        runBlockingTest {
            _result.emit(response)
            result
                .test {
                    assertNotNull(
                        expectItem()
                    )
                }
        }

    @Test
    fun `should emit new value in result when _result  emit  value`() =
        runBlockingTest {
            _result.emit(response)
            result
                .test {
                    assertEquals(
                        response,
                        expectItem()
                    )
                }
        }
}