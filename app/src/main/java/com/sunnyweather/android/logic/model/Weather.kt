package com.sunnyweather.android.logic.model

//用于封装实时天气信息和未来几天天气信息
data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily)