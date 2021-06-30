package com.omni.home.domain.validation

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TextValidationRuleTest {

    private lateinit var textValidationRule: TextValidationRule

    @Before
    fun setUp() {
        textValidationRule = TextValidationRule()
    }

    @Test
    fun `when text isBlank then return EMPTY`() {
        val text = " "

        val result = textValidationRule.validate(text)

        assertEquals(TextValidation.EMPTY, result)

    }

    @Test
    fun `when text isLetter and length is bigger then three  return PASSED`() {
        val text = "1 cup Milk"

        val result = textValidationRule.validate(text)

        assertEquals(TextValidation.PASSED, result)

    }

    @Test
    fun `when text is Not Letter then return INVALID`() {
        val text = "000..."

        val result = textValidationRule.validate(text)

        assertEquals(TextValidation.IN_VALID, result)

    }
}