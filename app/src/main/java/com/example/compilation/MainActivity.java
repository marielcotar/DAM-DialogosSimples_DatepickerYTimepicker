package com.example.compilation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_ad, btn_dp, btn_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_ad = findViewById(R.id.btn_v1);
        btn_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Botron de alert dialog");
                //mostrarToast();
                Intent i = new Intent(MainActivity.this, AlertDialogTest.class);
                startActivity(i);
            }
        });
        btn_dp = findViewById(R.id.btn_datepicker);
        btn_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Boton de datepicker");
                Intent i = new Intent(MainActivity.this, DatePickerTest.class);
                startActivity(i);
            }
        });
        btn_list = findViewById(R.id.btn_dialog);
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DialogoListas.class);
                startActivity(i);
            }
        });
    }
    public void mostrarToast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}