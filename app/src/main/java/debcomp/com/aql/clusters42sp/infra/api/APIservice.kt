package debcomp.com.aql.clusters42sp.infra.api

import debcomp.com.aql.clusters42sp.infra.api.endpoints.CoalitionEndPoint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*
 * Davi Áquila
 *
 * 15/02/2020
 *
 */

class APIservice {

    val BASE_URL = "https://api.intra.42.fr/"

    private lateinit var retrofit: Retrofit
    private lateinit var interceptorAPI: InterceptorAPI

    lateinit var coalitionEndPoint: CoalitionEndPoint

    constructor(Token: String){
        interceptorAPI = InterceptorAPI("token $Token")

        val builderCoalition = OkHttpClient.Builder()
        builderCoalition.addInterceptor(interceptorAPI)
        val coalition = builderCoalition.build()

        val builderRetrofit = Retrofit.Builder()
        retrofit = builderRetrofit
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(coalition)
            .build()

        coalitionEndPoint = this.retrofit.create(CoalitionEndPoint::class.java)


    }
}