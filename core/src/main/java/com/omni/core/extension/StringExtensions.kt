package com.omni.core.extension


fun String.isValidText() = this.filter { it.isLetter() }.length >= 3
