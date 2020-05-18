package com.tiagoborges.projetomindbe.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tiagoborges.projetomindbe.R
import com.tiagoborges.projetomindbe.main.model.TarefaModel
import com.tiagoborges.projetomindbe.main.retrofit.RetrofitInitializer
import com.tiagoborges.projetomindbe.main.validacao.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NovaTarefaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nova_tarefa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageButton>(R.id.btnVoltar).setOnClickListener() {
            findNavController().navigate(R.id.action_novaTarefaFragment_to_telaPrincipalFragment)
        }
        view.findViewById<ImageButton>(R.id.btnAdicionar).setOnClickListener() {
            var desc : String
            if (Utils.validaCampo(view.findViewById(R.id.txtEmailTarefa), view.context)
                && Utils.validaCampo(view.findViewById(R.id.txtNomeDaTarefa), view.context)
            ) {
                var titulo : String
                var email : String

                titulo = view.findViewById<EditText>(R.id.txtNomeDaTarefa).text.toString()
                email = view.findViewById<EditText>(R.id.txtEmailTarefa).text.toString()
                desc = view.findViewById<EditText>(R.id.txtDescricaoTarefa).text.toString()
                    if(view.findViewById<EditText>(R.id.txtDescricaoTarefa).text.isBlank()){
                        desc = "lorem impsu..."
                    }
                val call = RetrofitInitializer().tarefaService().post(TarefaModel(null,null,titulo, email, desc))
                call.enqueue(object : Callback<Object> {
                    override fun onFailure(call: Call<Object>, t: Throwable) {
                        Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                        Log.e(
                            "onFailure error",
                            t?.message
                        )
                    }
                    override fun onResponse(call: Call<Object>, response: Response<Object>) {
                        Toast.makeText(context, "Adicionado com sucesso!", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}