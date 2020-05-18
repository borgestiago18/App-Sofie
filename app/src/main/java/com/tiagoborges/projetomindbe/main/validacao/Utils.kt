package com.tiagoborges.projetomindbe.main.validacao

import android.content.Context
import android.widget.EditText
import android.widget.Toast

class Utils {
    companion object
    {
        fun validaCampo(editText: EditText, context: Context) : Boolean {
            if(editText.text.isBlank())
            {
                Toast.makeText(context, "O campo " + editText.hint + " deve ser preenchido ", Toast.LENGTH_SHORT).show()
                return false
            }
            return true
        }
    }
}