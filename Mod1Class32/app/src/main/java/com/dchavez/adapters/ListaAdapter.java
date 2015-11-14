package com.dchavez.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dchavez.mod1class3.R;
import com.dchavez.models.Direcciones;

import java.util.ArrayList;

/**
 * Created by alumno on 11/14/15.
 */
public class ListaAdapter extends BaseAdapter {
    //Para obtener la pantalla donde se va amostrar el listado
    Context context;
    //Coleccion de datos
    ArrayList<Direcciones> lista;

    public ListaAdapter(Context context, ArrayList<Direcciones> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    static class ViewHolder{
        TextView lblDistrito,lblDireccion,lblNombre;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.lblDistrito=(TextView)convertView.findViewById(R.id.item_txt_distrito);
            viewHolder.lblDireccion=(TextView)convertView.findViewById(R.id.item_txt_direccion);
            viewHolder.lblNombre=(TextView)convertView.findViewById(R.id.item_txt_nombre);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        Direcciones item = (Direcciones) getItem(position);
        String txtDistrito = item.getDistrito().toString().trim();
        String txtDireccion = item.getDireccion().toString().trim();
        String txtNombre = item.getNombre().toString().trim();

        viewHolder.lblNombre.setTextSize(18);
        viewHolder.lblDireccion.setTextSize(17);
        viewHolder.lblDistrito.setTextSize(20);

        if(txtDistrito.length()>0){
            viewHolder.lblDistrito.setText(txtDistrito);
            viewHolder.lblDistrito.setVisibility(View.VISIBLE);
        }else{
            viewHolder.lblDistrito.setVisibility(View.GONE);
        }

        if(txtDireccion.length()>0){
            viewHolder.lblDireccion.setText(txtDireccion);
            viewHolder.lblDireccion.setVisibility(View.VISIBLE);
        }else{
            viewHolder.lblDireccion.setVisibility(View.GONE);
        }

        if(txtNombre.length()>0){
            viewHolder.lblNombre.setText(txtNombre);
            viewHolder.lblNombre.setVisibility(View.VISIBLE);
        }else{
            viewHolder.lblNombre.setVisibility(View.GONE);
        }

        return convertView;
    }
}
