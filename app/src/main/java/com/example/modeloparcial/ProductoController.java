package com.example.modeloparcial;

import android.app.Activity;
import android.view.View;

public class ProductoController implements View.OnClickListener {
    private Activity activity;
    private ProductoView productoView;
    private ProductoModel productoModel;

    public ProductoController(Activity activity, ProductoModel productoModel) {
        this.activity = activity;
        this.productoModel = productoModel;
    }

    public void setView(ProductoView productoView) {
        this.productoView = productoView;
        this.productoView.cargarDatosEnPantalla();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnGuardar) {
            this.productoView.guardarDatosEnModelo();

            if (this.validarDatosCargados()) {
                this.productoView.mostrarMensaje(this.activity.getString(R.string.datos_guardados));
                ProductoActivity.producto = this.productoModel;
                this.activity.finish();
            }
            else {
                this.productoView.mostrarMensaje(this.activity.getString(R.string.error_al_guardar_datos));
                ProductoActivity.producto = null;
            }
        }
    }

    private boolean validarDatosCargados() {
        if (this.productoModel.getNombre() == null || this.productoModel.getPrecio() == null || this.productoModel.getCantidad() == null || this.productoModel.getNombre().isEmpty()) {
            return false;
        }

        return true;
    }
}
