package com.omni.home.domain.validation

import com.omni.core.extension.isValidText

class TextValidationRule {
    fun validate(ingredients: String): TextValidation =
        when {
            ingredients.isBlank() -> TextValidation.EMPTY
            ingredients.isValidText() -> TextValidation.PASSED
            else -> TextValidation.IN_VALID
        }
}