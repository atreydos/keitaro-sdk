package io.atreydos.keitarosdk

import retrofit2.http.GET

interface KeitaroApiService {

    //***************************************************************************
    // Affiliate networks
    //***************************************************************************

    @GET("/admin_api/v1/affiliate_networks")
    suspend fun affiliateNetworks()
}