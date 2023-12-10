package com.example.komponentyzaawansowane;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimePicker timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        Button buttonTime = findViewById(R.id.buttonTime);
        buttonTime.setOnClickListener((view) ->{
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();
            TextView textView = findViewById(R.id.textTime);
            textView.setText(String.format("Wybrano czas %s:%s", hour, minute));
        });

        DatePicker datePicker = findViewById(R.id.calendar);
        Button buttonDate = findViewById(R.id.buttonDate);
        buttonDate.setOnClickListener((view) ->{
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth();
            int year = datePicker.getYear();

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            String[] nameOfdays = {"niedziela", "poniedziałek", "wtorek", "środa", "czwartek",
                                    "piątek", "sobota"} ;

            TextView textView = findViewById(R.id.textDate);
            textView.setText(String.format("Wybrano datę %s %s-%s-%s", nameOfdays[dayOfWeek-1], year, month+1, day));
        });

        Button buttonTime2 = findViewById(R.id.buttonTime2);
        buttonTime2.setOnClickListener((view) -> {
            DialogFragment dialogFragment = new TimePickerFragment();
            dialogFragment.show(getSupportFragmentManager(), "timePicker");
        });
    }
}