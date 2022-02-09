package io.atreydos.keitaroadmin.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import kotlin.jvm.Throws

class KeitaroAuthInterceptor(private val keitaroAdminApiKey: String) : Interceptor {

    companion object {
        const val HEADER_API_KEY = "Api-Key"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()

        builder.addHeader("Cookie", cookie)

        return chain.proceed(builder.build())
    }

}