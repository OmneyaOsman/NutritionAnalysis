package com.devexy.core.exception

class UnhandledHttpCodeException(val httpStatusCode: Int) : Exception()