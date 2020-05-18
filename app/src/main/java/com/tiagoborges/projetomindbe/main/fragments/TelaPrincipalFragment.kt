package com.tiagoborges.projetomindbe.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.internal.LinkedTreeMap
import com.tiagoborges.projetomindbe.R
import com.tiagoborges.projetomindbe.main.adapter.TarefaAdapter
import com.tiagoborges.projetomindbe.main.model.DataModel
import com.tiagoborges.projetomindbe.main.model.TarefaModel
import com.tiagoborges.projetomindbe.main.retrofit.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaPrincipalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.tela_principal, container, false)

        var recyclerView : RecyclerView = view.findViewById<RecyclerView>(R.id.rcView)
        recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        var tasks : MutableList<TarefaModel> = mutableListOf()

        val call = RetrofitInitializer().tarefaService().listAllTarefaModelByQueryString()

        call.enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                response.body()?.let {
                    it.data.forEach{
                        it as LinkedTreeMap<String, String>
                        tasks.add(TarefaModel(it.getValue("_id"), it.getValue("when"),it.getValue("title"),
                            it.getValue("email") ,it.getValue("description")))
                    }
                }
                tasks.sortBy { x -> x.nome.toUpperCase() }
                var taskAdapter = TarefaAdapter(tasks)
                recyclerView.setAdapter(taskAdapter)
            }
            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                Log.e(
                    "onFailure error",
                    t?.message
                )
            }
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<FloatingActionButton>(R.id.floatingActionButton4).setOnClickListener() {
            findNavController().navigate(R.id.action_telaPrincipalFragment_to_novaTarefaFragment)
        }
    }
}