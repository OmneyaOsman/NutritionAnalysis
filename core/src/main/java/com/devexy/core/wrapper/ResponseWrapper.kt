package com.devexy.core.wrapper

import com.devexy.core.model.ServerErrorResponseModel


sealed class ResponseWrapper {
    class Success<T>(val data: T) : ResponseWrapper()
    class SuccessList<T>(val dataList: List<T>) : ResponseWrapper()
    class ServerError(val errorModel: ServerErrorResponseModel?) : ResponseWrapper()
    object ServerDataNullError : ResponseWrapper()
    object CancelCoroutine : ResponseWrapper()
    object NetworkError : ResponseWrapper()
    object Error : ResponseWrapper()
    class UnhandledHTTPCode(val httpStatusCode: Int) : ResponseWrapper()
}