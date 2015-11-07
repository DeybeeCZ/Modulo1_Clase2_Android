package com.dchavez.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dchavez.mod1class2_1.R;
import com.dchavez.models.Objeto;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by alumno on 11/7/15.
 */
public class ListaAdapter extends BaseAdapter {

    ImageLoader imageLoader= ImageLoader.getInstance();

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

    static class ViewHolder{
        TextView lblTextoUno,lblTextoDos,lblTextoTres,lblTextoCuatro;
        ImageView ivImage;
    }

    //Se construye el item con la parte visual
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder=null;

        if (convertView == null){
            //LayoutInflater es como el setContent
            convertView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.lblTextoUno = (TextView)convertView.findViewById(R.id.item_lbl_TextoUno);
            viewHolder.lblTextoDos = (TextView)convertView.findViewById(R.id.item_lbl_TextoDos);
            viewHolder.lblTextoTres = (TextView)convertView.findViewById(R.id.item_lbl_TextoTres);
            viewHolder.lblTextoCuatro = (TextView)convertView.findViewById(R.id.item_lbl_TextoCuatro);
            viewHolder.ivImage = (ImageView)convertView.findViewById(R.id.ivImagen);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder)convertView.getTag();
        Objeto item = (Objeto) getItem(position);
        viewHolder.lblTextoUno.setText(item.getTextoUno());
        viewHolder.lblTextoDos.setText(item.getTextoDos());
        viewHolder.lblTextoTres.setText(item.getTextoTres());
        viewHolder.lblTextoCuatro.setText(item.getTextoCuatro());

        imageLoader.displayImage(item.getRutaImagen(),viewHolder.ivImage);

        return convertView;
    }
}
