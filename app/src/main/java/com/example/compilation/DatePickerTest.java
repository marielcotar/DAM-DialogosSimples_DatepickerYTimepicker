package com.example.compilation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DatePickerTest extends AppCompatActivity {
    DatePicker datePicker;
    TimePicker timePicker;
    TextView fechaSeleccionada, horaSeleccionada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_test);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        fechaSeleccionada = findViewById(R.id.fechaSeleccionada);
        horaSeleccionada = findViewById(R.id.horaSeleccionada);

        // Obtener la fecha actual
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        final int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        // Configurar el DatePicker
        datePicker.init(year, month, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Actualizar la etiqueta de texto con la fecha seleccionada
                fechaSeleccionada.setText("Fecha seleccionada: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            }
        });

        // Configurar el TimePicker
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(hourOfDay);
        timePicker.setCurrentMinute(minute);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // Actualizar la etiqueta de texto con la hora seleccionada
                horaSeleccionada.setText("Hora seleccionada: " + hourOfDay + ":" + minute);
            }
        });
    }
}
