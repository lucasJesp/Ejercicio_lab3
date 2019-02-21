package com.example.lucas.ejercicio_lab3.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lucas.ejercicio_lab3.R;
import com.example.lucas.ejercicio_lab3.modelo.Frutas;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<Frutas> frutas;
    private int layout;
    private OnItemClickListener itemClickListener;
    private Activity activity;

    private Context context;


    public MyAdapter(List<Frutas> frutas, int layout,/* Activity activity*/ OnItemClickListener listener) {
        this.frutas = frutas;
        this.layout = layout;
        // this.activity = activity;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout y se lo pasamos al constructor del ViewHolder, donde manejaremos
        // toda la lógica como extraer los datos, referencias...
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Llamamos al método Bind del ViewHolder pasándole objeto y listener
        holder.bind(frutas.get(position), itemClickListener);
    }


    @Override
    public int getItemCount() {
        return frutas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Elementos UI a rellenar
        public TextView textViewName;
        public TextView textViewDescription;
        public ImageView imageViewBackground;

        public ViewHolder(View itemView) {
            // Recibe la View completa. La pasa al constructor padre y enlazamos referencias UI
            // con nuestras propiedades ViewHolder declaradas justo arriba.
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
            imageViewBackground = (ImageView) itemView.findViewById(R.id.imageViewBackground);

        }



            public void bind(final Frutas fruta, final OnItemClickListener listener) {
                // Procesamos los datos a renderizar
                textViewName.setText(fruta.getName());
                textViewDescription.setText(fruta.getDescription());
                Picasso.with(context).load(fruta.getImgIcon()).fit().into(imageViewBackground);
                // imageViewPoster.setImageResource(movie.getPoster());
                // Definimos que por cada elemento de nuestro recycler view, tenemos un click listener
                // que se comporta de la siguiente manera...
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onItemClick(fruta, getAdapterPosition());
                    }
                });
            }
        }

        // Declaramos nuestra interfaz con el/los método/s a implementar
        public interface OnItemClickListener {
            void onItemClick(Frutas frutas, int position);
        }

    }

