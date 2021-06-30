package com.omni.summary.presentation.viewModel

import app.cash.turbine.test
import com.omni.analysis_shared_data.domain.entity.IngredientEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test

class SummaryViewModelTest {
    private val _ingredientEntities = MutableStateFlow<List<IngredientEntity>>(emptyList())
    private val ingredientEntities = _ingredientEntities.asStateFlow()


    @Test
    fun `should emit default value`() = runBlockingTest {
        _ingredientEntities.emit(emptyList())
        ingredientEntities
            .test {
                assertEquals(emptyList<IngredientEntity>(), expectItem())
            }
    }

    @Test
    fun `should emit value And not emit default value`() =
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
            _ingredientEntities.emit(list)
            ingredientEntities
                .test {
                    assertNotEquals(emptyList<IngredientEntity>(), expectItem())
                }
        }

    @Test
    fun `should emit value in ingredientEntities when change _ingredientEntities value`() =
        runBlockingTest {
            val list = listOf(
                IngredientEntity(
                    quantity = "2",
                    unit = "cup",
                    food = "rice",
                    calories = "142",
                    weight = "200"
                ),
            )
            _ingredientEntities.emit(list)
            ingredientEntities
                .test {
                    assertEquals(list, expectItem())
                }
        }
}