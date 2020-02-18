package debcomp.com.aql.clusters42sp.models


/*
 * Davi Áquila
 *
 * 15/02/2020
 *
 */

import com.ridi.oauth2.TokenResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

internal interface ApiServices {
    companion object {
        const val PASSWORD_GRANT_TYPE = "password"
        const val REFRESH_TOKEN_GRANT_TYPE = "refresh_token"
    }

    @POST("oauth2/token")
    @FormUrlEncoded
    fun requestToken(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("grant_type") grantType: String,
        @Field("username") username: String?,
        @Field("password") password: String?,
        @Field("refresh_token") refreshToken: String?
    ): Call<TokenResponse>
}