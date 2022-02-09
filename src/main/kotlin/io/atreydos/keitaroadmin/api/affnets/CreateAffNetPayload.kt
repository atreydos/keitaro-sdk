package io.atreydos.keitaroadmin.model
import com.google.gson.annotations.SerializedName


data class CreateAffNetPayload(
    @SerializedName("name") val name: String,
    @SerializedName("notes") val notes: String,
    @SerializedName("offer_param") val offerParam: String,
    @SerializedName("postback_url") val postbackUrl: String
)