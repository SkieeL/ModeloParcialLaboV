package com.example.modeloparcial;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListenerRecycler implements View.OnClickListener {
    private RecyclerView recyclerView;
    private List<ProductoModel> productos;
    private Activity activity;

    public ListenerRecycler(RecyclerView recyclerView, List<ProductoModel> productos, Activity activity) {
        this.recyclerView = recyclerView;
        this.productos = productos;
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        MainActivity.itemSeleccionado = this.recyclerView.getChildLayoutPosition(view);
        ProductoModel producto = productos.get(MainActivity.itemSeleccionado);

        Intent intent = new Intent(this.activity, ProductoActivity.class);
        intent.putExtra("producto", producto);
        this.activity.startActivity(intent);
    }
}
