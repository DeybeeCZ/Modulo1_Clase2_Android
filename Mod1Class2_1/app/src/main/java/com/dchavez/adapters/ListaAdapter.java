package com.dchavez.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dchavez.mod1class2_1.R;
import com.dchavez.models.Objeto;

import java.util.ArrayList;

/**
 * Created by alumno on 11/7/15.
 */
public class ListaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Objeto> lista;

    public ListaAdapter(Context context, ArrayList<Objeto> lista) {
        this.context = context;
        this.lista = lista;
    }

    //Cantidad de elementos que tiene nuestra lista
    @Override
    public int getCount() {
        return lista.size();
    }

    //Obtenemos el id de la lista por la posiciòn
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //Se construye el item con la parte visual
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            //LayoutInflater es como el setContent
            convertView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        }
        TextView lblTextoUno = (TextView)convertView.findViewById(R.id.item_lbl_TextoUno);
        TextView lblTextoDos = (TextView)convertView.findViewById(R.id.item_lbl_TextoDos);
        TextView lblTextoTres = (TextView)convertView.findViewById(R.id.item_lbl_TextoTres);
        TextView lblTextoCuatro = (TextView)convertView.findViewById(R.id.item_lbl_TextoCuatro);

        Objeto item = (Objeto) getItem(position);
        lblTextoUno.setText(item.getTextoUno());
        lblTextoDos.setText(item.getTextoDos());
        lblTextoTres.setText(item.getTextoTres());
        lblTextoCuatro.setText(item.getTextoCuatro());

        return convertView;
    }
}
