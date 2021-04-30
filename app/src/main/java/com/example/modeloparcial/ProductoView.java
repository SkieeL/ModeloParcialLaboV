package com.example.modeloparcial;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProductoView {
    private Activity activity;
    private ProductoModel productoModel;
    private EditText inputNombre;
    private EditText inputCantidad;
    private EditText inputPrecio;

    public ProductoView(Activity activity, ProductoModel productoModel, ProductoController productoController) {
        this.activity = activity;
        this.productoModel = productoModel;

        this.inputNombre = activity.findViewById(R.id.inputNombre);
        this.inputCantidad = activity.findViewById(R.id.inputCantidad);
        this.inputPrecio = activity.findViewById(R.id.inputPrecio);

        Button btnGuardar = activity.findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(productoController);
    }

    public void guardarDatosEnModelo() {
        // FIXME Es correcto usar este try/catch en la View?
        try {
            this.productoModel.setCantidad(Integer.parseInt(this.inputCantidad.getText().toString()));
            this.productoModel.setPrecio(Double.parseDouble(this.inputPrecio.getText().toString()));
        }
        // Evita que pinche al submitear los campos vacíos
        catch (NumberFormatException ignore) { }
        finally {
            this.productoModel.setNombre(this.inputNombre.getText().toString());
        }
    }

    public void cargarDatosEnPantalla() {
        // FIXME Es correcto usar este try/catch en la View?
        try {
            this.inputCantidad.setText(this.productoModel.getCantidad().toString());
            this.inputPrecio.setText(this.productoModel.getPrecio().toString());
        }
        // Evita que pinche al llegar un null
        catch (NullPointerException ignore) { }
        finally {
            this.inputNombre.setText(this.productoModel.getNombre());
        }
    }

    public void mostrarMensaje(String texto) {
        Toast.makeText(this.activity, texto, Toast.LENGTH_LONG).show();
    }
}
