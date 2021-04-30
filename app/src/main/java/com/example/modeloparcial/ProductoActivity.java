package com.example.modeloparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class ProductoActivity extends AppCompatActivity {

    public static ProductoModel producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        Bundle extras = super.getIntent().getExtras();
        ProductoModel productoModel = (ProductoModel) extras.getSerializable("producto");
        ProductoController productoController = new ProductoController(this, productoModel);
        ProductoView tareaView = new ProductoView(this, productoModel, productoController);
        productoController.setView(tareaView);

        // FIXME dónde iría el ActionBar? Controller?
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle(R.string.titulo_editar);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            ProductoActivity.producto = null;
            super.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}