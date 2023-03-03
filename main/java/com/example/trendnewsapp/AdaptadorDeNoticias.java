package com.example.trendnewsapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AdaptadorDeNoticias extends RecyclerView.Adapter<AdaptadorDeNoticias.ViewHolder> {
    Noticia[] noticias;
    Context contexto;

    public AdaptadorDeNoticias(Noticia[] noticias, Context contexto) {
        this.noticias = noticias;
        this.contexto = contexto;
    }

    public AdaptadorDeNoticias(Noticia[] noticias) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vista = layoutInflater.inflate(R.layout.items_noticias_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(vista);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Noticia noticia = noticias[position];
        holder.imagenDeNoticia.setImageResource(Integer.parseInt(String.valueOf(noticia.getImagen())));
        holder.tituloDeNoticia.setText(noticia.getTitulo());
        holder.autorDeNoticia.setText(noticia.getAutor());
        holder.fechaDeNoticia.setText(noticia.getFecha().toString());
        holder.descripcionDeNoticia.setText(noticia.getDescripcion()); // Aquí se establece el texto de la descripción usando el TextView correspondiente.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, PantallaDeNoticia.class);
                intent.putExtra("titulo", noticia.getTitulo());
                intent.putExtra("autor", noticia.getAutor());
                intent.putExtra("fecha", noticia.getFecha().toString());
                intent.putExtra("descripcion", noticia.getDescripcion());
                intent.putExtra("imagen", noticia.getImagen());
                contexto.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noticias.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView descripcionDeNoticia;
        ImageView imagenDeNoticia;
        TextView tituloDeNoticia;
        TextView autorDeNoticia;
        TextView fechaDeNoticia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenDeNoticia = itemView.findViewById(R.id.imgDeNoticia);
            tituloDeNoticia = itemView.findViewById(R.id.tnTitulo);
            autorDeNoticia = itemView.findViewById(R.id.tnAutor);
            fechaDeNoticia= itemView.findViewById(R.id.etqFecha);
            descripcionDeNoticia = itemView.findViewById(R.id.tnDescripcion); // Inicializado como un TextView
        }
    }
}
