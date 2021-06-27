package com.devexy.core.extension

import com.devexy.core.R
import com.devexy.core.base.BaseViewModel
import com.devexy.core.wrapper.ResponseWrapper

suspend fun ResponseWrapper.handleCommonResponses(
    viewModel: BaseViewModel
) {
    when (this) {
        is ResponseWrapper.ServerError -> {
            val errorResponse = this.errorModel
            errorResponse?.let {
                viewModel.snackBarMessageEvent.emit(it.error ?: "")
            }
        }


        is ResponseWrapper.UnhandledHTTPCode -> {
            viewModel.toastMessageEvent.emit(this.httpStatusCode.toString())
        }

        is ResponseWrapper.NetworkError -> {
            viewModel.toastResourceMessageEvent.emit(R.string.general_error_network)
        }

        is ResponseWrapper.ServerDataNullError -> {
            viewModel.toastResourceMessageEvent.emit(R.string.general_server_data_null)
        }

        is ResponseWrapper.Error -> {
            viewModel.toastResourceMessageEvent.emit(R.string.general_error_server)
        }
    }
}