package io.atreydos.keitaroadmin

import io.atreydos.keitaroadmin.model.CreateAffNetPayload
import retrofit2.http.*


interface TrafficSourcesApiService {

    //**************************************************************************************************************
    // Traffic sources
    // https://admin-api.docs.keitaro.io/#tag/Traffic-sources
    //**************************************************************************************************************

    /**
     * Returns list of traffic sources
     *
     * @see TrafficSource
     */
    @GET("/traffic_sources")
    suspend fun getAll()

    /**
     * Returns traffic source by ID
     *
     * @param id Traffic Source ID
     * @see TrafficSource
     */
    @GET("/traffic_sources/{id}")
    suspend fun getById(@Path("id") id: Int)

    /**
     * Creates traffic source
     *
     * @see TrafficSource
     */
    @POST("/traffic_sources")
    suspend fun create(@Body payload: CreateTrafficSourcePayload)

    /**
     * Updates traffic source
     *
     * @param id Traffic Source ID
     * @see TrafficSource
     */
    @PUT("/traffic_sources/{id}")
    suspend fun update(@Path("id") id: Int, @Body payload: UpdateTrafficSourcePayload)

    /**
     * Makes a copy of traffic source
     *
     * @param id Traffic Source ID
     * @see TrafficSource
     */
    @POST("/traffic_sources/{id}/clone")
    suspend fun clone(@Path("id") id: Int)

    /**
     * Changes the state to 'deleted'
     *
     * @param id Traffic Source ID
     */
    @DELETE("/traffic_sources/{id}")
    suspend fun delete(@Path("id") id: Int)

}