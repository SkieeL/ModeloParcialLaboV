package com.example.modeloparcial;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder {
    TextView textNombre;
    TextView textCantidad;
    TextView textPrecio;

    public ProductoViewHolder(View view) {
        super(view);
        this.textNombre = view.findViewById(R.id.textNombre);
        this.textCantidad = view.findViewById(R.id.textCantidad);
        this.textPrecio = view.findViewById(R.id.textPrecio);
    }
}
