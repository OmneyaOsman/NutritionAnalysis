package com.omni.home.presentation.viewmodel

import app.cash.turbine.test
import com.omni.analysis_shared_data.domain.entity.IngredientEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test

class HomeViewModelTest {
    private val _result: MutableStateFlow<Pair<List<IngredientEntity>, List<String>>> =
        MutableStateFlow(Pair(emptyList(), emptyList()))

    private val result = _result.asStateFlow()

    @Test
    fun `should emit default value`() = runBlockingTest {
        _result.emit(Pair(emptyList(), emptyList()))
        result
            .test {
                assertEquals(Pair(emptyList<IngredientEntity>(), emptyList<String>()), expectItem())
            }
    }

    @Test
    fun `should emit new value And not emit default value`() =
        runBlockingTest {
            val list = listOf(
                IngredientEntity(
                    quantity = "2",
                    unit = "cup",
                    food = "rice",
                    calories = "142",
                    weight = "200"
                ),
                IngredientEntity(
                    quantity = "1",
                    unit = "cup",
                    food = "milk",
                    calories = "0",
                    weight = "20"
                ),
            )

            val ingredientRequest = listOf(
                "2 cup rice",
                "1 cup milk",
            )
            _result.emit(Pair(list, ingredientRequest))
            result
                .test {
                    assertNotEquals(
                        Pair(emptyList<IngredientEntity>(), emptyList<String>()),
                        expectItem()
                    )
                }
        }

    @Test
    fun `should emit new value in result when _result  emit  value`() =
        runBlockingTest {
            val list = listOf(
                IngredientEntity(
                    quantity = "2",
                    unit = "cup",
                    food = "rice",
                    calories = "142",
                    weight = "200"
                ),
                IngredientEntity(
                    quantity = "1",
                    unit = "cup",
                    food = "milk",
                    calories = "0",
                    weight = "20"
                ),
            )

            val ingredientRequest = listOf(
                "2 cup rice",
                "1 cup milk",
            )
            _result.emit(Pair(list, ingredientRequest))
            result
                .test {
                    assertEquals(
                        Pair(list, ingredientRequest),
                        expectItem()
                    )
                }
        }
}