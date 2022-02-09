package io.atreydos.keitaroadmin

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.concurrent.CompletableFuture


class KeitaroCallAdapter : CallAdapter.Factory() {

    override fun get(returnType: Type, annotations: Array<out Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if (getRawType(returnType) != KeitaroCall::class.java) {
            return null
        }
        if (returnType !is ParameterizedType) {
            throw IllegalStateException(
                "KeitaroCall return type must be parameterized as KeitaroCall<Foo> or KeitaroCall<? extends Foo>"
            )
        }
        val innerType = getParameterUpperBound(0, returnType as ParameterizedType)

    }

    class KeitaroBodyCallAdapter<R> (private val responseType: Type) :  CallAdapter<R, KeitaroCall<R> > {

        override fun responseType(): Type {
            return responseType
        }

        override fun adapt(call: Call<R>): KeitaroCall<R> {
            return KeitaroCall(call = call)
        }
    }

}