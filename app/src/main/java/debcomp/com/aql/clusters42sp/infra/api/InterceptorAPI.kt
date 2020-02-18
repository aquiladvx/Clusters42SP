package debcomp.com.aql.clusters42sp.infra.api

import okhttp3.Interceptor
import okhttp3.Response


/*
 * Davi Áquila
 *
 * 15/02/2020
 *
 */

class InterceptorAPI(public var TOKEN: String): Interceptor {

    val AUTHORIZATION = "Authorization"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain!!.request().newBuilder()
            .addHeader(AUTHORIZATION, TOKEN)
            .build()
        return chain.proceed(request)
    }
}