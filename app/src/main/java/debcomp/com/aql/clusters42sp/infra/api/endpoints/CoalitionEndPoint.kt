package debcomp.com.aql.clusters42sp.infra.api.endpoints

import debcomp.com.aql.clusters42sp.models.Coalition
import retrofit2.Call
import retrofit2.http.GET


/*
 * Davi Áquila
 *
 * 15/02/2020
 *
 */

interface CoalitionEndPoint {

    @GET("/v2/coalitions")
    fun getCoalition(): Call<MutableList<Coalition>>
}