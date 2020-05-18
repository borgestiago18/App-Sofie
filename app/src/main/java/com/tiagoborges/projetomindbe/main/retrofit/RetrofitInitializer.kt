package com.tiagoborges.projetomindbe.main.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer{

    private val okHttp : OkHttpClient.Builder = OkHttpClient.Builder()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://9g1borgfz0.execute-api.sa-east-1.amazonaws.com/beta/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
        .build()

    fun tarefaService() = retrofit.create(TarefaService::class.java)
}