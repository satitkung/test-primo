package com.example.testprimo.di

import com.example.testprimo.service.FeedApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.io.IOException


@Module
@InstallIn(SingletonComponent::class)
object ServiceModules {

    @Provides
    fun provideClient(): OkHttpClient {
        class XmlInterceptor : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Chain): Response {
                val response: Response = chain.proceed(chain.request())
                val body: ResponseBody? = response.body()
                val wrappedBody = body?.string()?.replace("content:encoded", "content")
                return response.newBuilder()
                    .body(ResponseBody.create(body?.contentType(), wrappedBody))
                    .build()
            }
        }
        return OkHttpClient.Builder()
            .addInterceptor(XmlInterceptor())
            .build();
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://medium.com/")
            .client(client)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }

    @Provides
    fun provideFeedApi(retrofit: Retrofit): FeedApi {
        return retrofit.create(FeedApi::class.java)
    }
}
