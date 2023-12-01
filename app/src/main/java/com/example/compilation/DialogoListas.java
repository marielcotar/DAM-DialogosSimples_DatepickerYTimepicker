package com.example.compilation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DialogoListas extends AppCompatActivity {
    Button btnMostrarDialogo;
    TextView tvOpcionesSeleccionadas;
    List<String> opcionesSeleccionadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo_listas);

        btnMostrarDialogo = findViewById(R.id.btnMostrarDialogo);
        tvOpcionesSeleccionadas = findViewById(R.id.tvOpcionesSeleccionadas);

        opcionesSeleccionadas = new ArrayList<>();

        btnMostrarDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();
            }
        });
    }

    private void mostrarDialogo() {
        final String[] opciones = {"Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5"};
        final boolean[] seleccionadas = new boolean[opciones.length];

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una o varias opciones")
                .setMultiChoiceItems(opciones, seleccionadas, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        if (isChecked) {
                            opcionesSeleccionadas.add(opciones[which]);
                        } else {
                            opcionesSeleccionadas.remove(opciones[which]);
                        }
                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarOpcionesSeleccionadas();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Cancelar el diálogo
                    }
                })
                .show();
    }

    private void mostrarOpcionesSeleccionadas() {
        StringBuilder opcionesTexto = new StringBuilder("Opciones seleccionadas: ");
        for (String opcion : opcionesSeleccionadas) {
            opcionesTexto.append(opcion).append(", ");
        }

        // Elimina la coma y el espacio extra al final
        if (opcionesTexto.length() > 0) {
            opcionesTexto.delete(opcionesTexto.length() - 2, opcionesTexto.length());
        }

        tvOpcionesSeleccionadas.setText(opcionesTexto.toString());
    }
}

