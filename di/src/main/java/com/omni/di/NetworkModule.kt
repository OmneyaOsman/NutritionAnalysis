package com.omni.di

import com.omni.di.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.omni.core.AuthorizationInterceptor
import okhttp3.OkHttpClient
import timber.log.Timber
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    single { provideHttpLoggingInterceptor() }
    single { AuthorizationInterceptor() }
    single { provideOkHttpClient(get(),get()) }
    single { provideGson() }
    single { provideRetrofit(get(), get()) }
}
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { logMessage ->
            Timber.e(logMessage)
        }.apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }

    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor,
        authorizationInterceptor : AuthorizationInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(authorizationInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
        builder.addNetworkInterceptor(interceptor)
        return builder.build()
    }

    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .setPrettyPrinting()
        return gsonBuilder.create()
    }

    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
//            .addConverterFactory(NullOnEmptyConverterFactory())
            .addConverterFactory(ScalarsConverterFactory.create()) //the ordering is importing, we must but ScalersConverter before Gson
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
