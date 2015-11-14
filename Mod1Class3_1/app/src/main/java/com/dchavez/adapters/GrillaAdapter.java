package com.dchavez.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dchavez.mod1class3_1.R;
import com.dchavez.models.Cupon;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 11/14/15.
 */
public class GrillaAdapter extends ArrayAdapter<Cupon> {

    private Context context;
    private ArrayList<Cupon> lista;

    public GrillaAdapter(Context context,ArrayList<Cupon> objects) {
        super(context,0, objects);
        this.context = context;
        this.lista = objects;
    }

    static class ViewHolder{
        SimpleDraweeView ivImagen;
        TextView lblTitulo,lblSubtitulo,lblTextoUno,lblTextoDos,lblPrecioUno,lblPrecioDos;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.lblTitulo = (TextView)convertView.findViewById(R.id.item_tv_titulo);
            viewHolder.lblSubtitulo = (TextView)convertView.findViewById(R.id.item_tv_subtitulo);
            viewHolder.lblTextoUno = (TextView)convertView.findViewById(R.id.item_tv_texto_uno);
            viewHolder.lblTextoDos = (TextView)convertView.findViewById(R.id.item_tv_texto_dos);
            viewHolder.lblPrecioUno = (TextView)convertView.findViewById(R.id.item_tv_precio_uno);
            viewHolder.lblPrecioDos = (TextView)convertView.findViewById(R.id.item_tv_precio_dos);
            viewHolder.ivImagen = (SimpleDraweeView)convertView.findViewById(R.id.item_iv_imagen);

            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder)convertView.getTag();

        Cupon item = lista.get(position);
        viewHolder.lblTitulo.setText(item.getTitulo());
        viewHolder.lblSubtitulo.setText(item.getSubtitulo());
        viewHolder.lblTextoUno.setText(item.getTextoUno());
        viewHolder.lblTextoDos.setText(item.getTextoDos());
        viewHolder.lblPrecioUno.setText(item.getPrecioUno());
        viewHolder.lblPrecioDos.setText(item.getPrecioDos());
        viewHolder.ivImagen.setImageURI(Uri.parse(item.getRutaimagen()));

        return convertView;

    }
}
