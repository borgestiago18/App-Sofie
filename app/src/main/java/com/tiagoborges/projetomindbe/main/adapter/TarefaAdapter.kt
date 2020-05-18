package com.tiagoborges.projetomindbe.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tiagoborges.projetomindbe.R
import com.tiagoborges.projetomindbe.main.model.TarefaModel

class TarefaAdapter(val tarefaList:List<TarefaModel>) : RecyclerView.Adapter<TarefaAdapter.ViewHolder>(){
 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    var view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
     return ViewHolder(view)
 }

 override fun getItemCount(): Int {
    return tarefaList.size
 }

 override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     var tarefa : TarefaModel = tarefaList[position]
     holder.nome.text = tarefa.nome
     holder.email.text = tarefa.email
     holder.descricao.text = tarefa.descricao
 }

 class ViewHolder(item: View) : RecyclerView.ViewHolder(item){
     var nome : TextView = item.findViewById(R.id.txtNomeTarefa)
     var email: TextView = item.findViewById(R.id.txtEmailTarefa)
     var descricao: TextView = item.findViewById(R.id.txtDescricao)
  }
}


