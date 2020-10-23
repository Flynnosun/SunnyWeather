package com.sunnyweather.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.Place

object PlaceDao {

    private fun sharedPreferens() =
        SunnyWeatherApplication.context.getSharedPreferences(
            "sunny_weather",
            Context.MODE_PRIVATE
        )

    fun savePlace(place: Place) {
        sharedPreferens().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getPlace(): Place {
        val placeJson = sharedPreferens().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferens().contains("place")
}