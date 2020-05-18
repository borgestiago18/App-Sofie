package com.tiagoborges.projetomindbe.main.retrofit

import com.tiagoborges.projetomindbe.main.model.DataModel
import com.tiagoborges.projetomindbe.main.model.TarefaModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TarefaService
{

    @GET("task?email=sofie@sofie.com")
    fun listAllTarefaModelByQueryString(): Call<DataModel>

    @POST("task")
    fun post(@Body tarefaModel: TarefaModel): Call<Object>
}