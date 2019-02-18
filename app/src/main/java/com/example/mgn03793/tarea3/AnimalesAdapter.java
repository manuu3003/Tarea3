package com.example.mgn03793.tarea3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AnimalesAdapter extends ArrayAdapter<Animal> {
    private List<Animal> lista;
    private Context context;
    private int layout;
    private SimpleDateFormat df;

    public AnimalesAdapter(@NonNull Context context, @NonNull List<Animal> objects) {
        super(context, R.layout.item_list_animales, objects);
        this.lista = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item_list_animales, null);
        }
        if (lista.get(position) != null) {
            ImageView imagen;
            TextView nombre, fecha;
            nombre = v.findViewById(R.id.tx_nombre);
            fecha = v.findViewById(R.id.tx_edad);
            imagen = v.findViewById(R.id.img_tipo);
            nombre.setText(lista.get(position).getNombre());
            fecha.setText(lista.get(position).getFecha());
            if (lista.get(position).getTipo()== 1) {
                imagen.setImageResource(R.drawable.perro);
            } else if (lista.get(position).getTipo()== 2) {
                imagen.setImageResource(R.drawable.gato);
            } else {
                imagen.setImageResource(R.drawable.ave);
            }

            String value= fecha.getText().toString();
            String cadena = value.substring(0,4);

            int fechaInicial = Integer.parseInt(cadena);
            int anno= 2019;
            int fechaFinal = anno - fechaInicial;

            String fechaFString = Integer.toString(fechaFinal);


            fecha.setText(fechaFString);
        }
        return v;
    }
}
