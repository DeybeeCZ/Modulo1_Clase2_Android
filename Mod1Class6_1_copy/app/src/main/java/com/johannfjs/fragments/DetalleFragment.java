package com.johannfjs.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.johannfjs.mod1class6_1.R;
import com.johannfjs.models.Cupon;
import com.johannfjs.utils.Constantes;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by alumno on 10/12/15.
 */
public class DetalleFragment extends Fragment {
    private ImageView ivImagen;
    private TextView lblTitulo, lblSubtitulo, lblPrecio;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);
        ivImagen = (ImageView) view.findViewById(R.id.ivImagen);
        lblTitulo = (TextView) view.findViewById(R.id.lblTitulo);
        lblSubtitulo = (TextView) view.findViewById(R.id.lblSubtitulo);
        lblPrecio = (TextView) view.findViewById(R.id.lblPrecio);
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();

        Bundle bundle = getArguments();
        if (bundle.containsKey("posicion")){
            int posicion = bundle.getInt("posicion");
            Cupon item = Constantes.lista.get(posicion);
            lblTitulo.setText(item.getTitulo());
            lblSubtitulo.setText(item.getSubtitulo());
            lblPrecio.setText(item.getPrecio1());

            imageLoader.displayImage(item.getRutaImagen(), ivImagen);
        }
    }
}
