package com.tiagoborges.projetomindbe.main.model

import com.google.gson.annotations.SerializedName

data class TarefaModel(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("when")
    val data:String?,
    @SerializedName("title")
    val nome: String,
    @SerializedName("email")
    val email:String,
    @SerializedName("description")
    val descricao: String) {
}

