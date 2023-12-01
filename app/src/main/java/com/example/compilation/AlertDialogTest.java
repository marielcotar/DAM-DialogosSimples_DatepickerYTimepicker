package com.example.compilation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.compilation.MainActivity;

public class AlertDialogTest extends AppCompatActivity {
    private EditText tf;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_test);
        tf = findViewById(R.id.tf_calcularRaiz);
        btn = findViewById(R.id.btn_calcularRaiz);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = tf.getText().toString();
                if(!inputValue.isEmpty()){
                    try {
                        float numero = Float.parseFloat(inputValue);
                        if (numero > 0){
                            AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogTest.this);
                            builder.setTitle("Raiz cuadrada de " + inputValue)
                                    .setMessage("Raiz cuadrada: " + Math.sqrt(numero))
                                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(AlertDialogTest.this, "Todo salio bien", Toast.LENGTH_SHORT).show();
                                        }
                                    }).show();// pendejo no olvides el show
                        }else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogTest.this);
                            builder.setTitle("Error")
                                    .setMessage("Ingresa un numero mayor a 0")
                                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            //Toast.makeText(MainActivity.this, "Todo salio bien", Toast.LENGTH_SHORT).show();
                                        }
                                    }).show();// pendejo no olvides el show
                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }
            }
        });
    }
}