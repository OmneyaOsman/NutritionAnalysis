package com.devexy.core

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor  @Inject constructor() : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        var original = chain.request()
//        val url =
//            original.url().newBuilder().addQueryParameter("app_id", BuildConfig.APP_ID)
//                .addQueryParameter("app_key", BuildConfig.API_KEY).build()
//        original = original.newBuilder().url(url).build()
//        return chain.proceed(original)
//    }

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.request().let {
             it.url().newBuilder().addQueryParameter("app_id", BuildConfig.APP_ID)
                .addQueryParameter("app_key", BuildConfig.API_KEY).build().let { url->
                    it.newBuilder().url(url).build()
                 }
        }.run {
            chain.proceed(this)
        }

}