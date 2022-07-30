package com.estarta.stationery.data.response


import com.estarta.stationery.data.models.Match
import com.squareup.moshi.Json

/*
 * Created by Rifqi Mulya Fahmi on 01/12/18.
 */

data class MatchesResponse(
    @Json(name = "events")
    val events: List<Match?>?
)