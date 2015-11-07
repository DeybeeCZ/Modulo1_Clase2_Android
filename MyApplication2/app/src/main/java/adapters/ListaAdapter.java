package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import mod1_class6.myapplication.R;
import models.Imagenes;

/**
 * Created by alumno on 10/5/15.
 */
public class ListaAdapter extends BaseAdapter {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private Context context;
    private ArrayList<Imagenes> lista;

    public ListaAdapter(Context context, ArrayList<Imagenes> lista) {

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
        TextView lblTitulo, lblContenido, lblFecha;
        ImageView ivImagen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.lblTitulo = (TextView) convertView.findViewById(R.id.lblTitulo);
            viewHolder.lblContenido = (TextView) convertView.findViewById(R.id.lblContenido);
            viewHolder.lblFecha = (TextView) convertView.findViewById(R.id.lblFecha);
            viewHolder.ivImagen = (ImageView) convertView.findViewById(R.id.ivImagen);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        Imagenes item = (Imagenes) getItem(position);
        viewHolder.lblContenido.setText(item.getContenido());
        viewHolder.lblFecha.setText(item.getFecha());
        viewHolder.lblTitulo.setText(item.getTitulo());

        if (item.getUrlImagen().length()>0){
            imageLoader.displayImage(item.getUrlImagen(), viewHolder.ivImagen);
            viewHolder.ivImagen.setVisibility(View.VISIBLE);
        }
        else
         viewHolder.ivImagen.setVisibility(View.GONE);

        return convertView;
    }
}
