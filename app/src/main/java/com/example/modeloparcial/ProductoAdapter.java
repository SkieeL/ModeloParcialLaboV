package com.example.modeloparcial;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> {
    List<ProductoModel> productos;
    Activity activity;
    RecyclerView recyclerView;

    public ProductoAdapter(List<ProductoModel> productos, Activity activity, RecyclerView recyclerView) {
        this.productos = productos;
        this.activity = activity;
        this.recyclerView = recyclerView;
    }

    public List<ProductoModel> getProductos() {
        return this.productos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        view.setOnClickListener(new ListenerRecycler(this.recyclerView, productos, this.activity));
        ProductoViewHolder personaViewHolder = new ProductoViewHolder(view);

        return personaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        ProductoModel producto = this.productos.get(position);
        holder.textNombre.setText(producto.getNombre());
        holder.textCantidad.setText(this.activity.getString(R.string.texto_cantidad) + producto.getCantidad());
        holder.textPrecio.setText(this.activity.getString(R.string.texto_precio) + producto.getPrecio());
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
