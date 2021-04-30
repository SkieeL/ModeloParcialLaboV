package com.example.modeloparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static int itemSeleccionado;
    private ProductoAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ProductoModel> productos = new ArrayList<>();

        productos.add(new ProductoModel("Producto 1", 1, 2.05));
        productos.add(new ProductoModel("Producto 2", 2, 2.06));
        productos.add(new ProductoModel("Producto 3", 3, 2.07));
        productos.add(new ProductoModel("Producto 4", 4, 2.08));
        productos.add(new ProductoModel("Producto 5", 5, 2.09));
        productos.add(new ProductoModel("Producto 6", 6, 2.10));
        productos.add(new ProductoModel("Producto 7", 7, 2.11));
        productos.add(new ProductoModel("Producto 8", 8, 2.12));
        productos.add(new ProductoModel("Producto 9", 9, 2.13));
        productos.add(new ProductoModel("Producto 10", 10, 2.14));
        productos.add(new ProductoModel("Producto 11", 11, 2.15));
        productos.add(new ProductoModel("Producto 12", 12, 2.16));
        productos.add(new ProductoModel("Producto 13", 13, 2.17));
        productos.add(new ProductoModel("Producto 14", 14, 2.18));
        productos.add(new ProductoModel("Producto 15", 15, 2.19));

        RecyclerView rv = super.findViewById(R.id.rvProductos);
        this.productoAdapter = new ProductoAdapter(productos, this, rv);

        rv.setAdapter(this.productoAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onRestart() {
        if (ProductoActivity.producto != null) {
            List<ProductoModel> productos = this.productoAdapter.getProductos();
            productos.set(MainActivity.itemSeleccionado, ProductoActivity.producto);
            this.productoAdapter.notifyItemChanged(MainActivity.itemSeleccionado);
        }

        super.onRestart();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}