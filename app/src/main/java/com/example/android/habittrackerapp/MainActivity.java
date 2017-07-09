package com.example.android.habittrackerapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.android.habittrackerapp.data.HabitContract;
import com.example.android.habittrackerapp.data.HabitDbHelper;

import com.example.android.habittrackerapp.data.HabitContract.HabitEntry;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Temporary display information in the onscreen TextView about the state of the habits database.
         */

        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        HabitDbHelper habitDbHelper = new HabitDbHelper(this);

        habitDbHelper.insertHabit(HabitContract.HabitEntry.HABIT_GYM, "Monday & Friday", 2);
        habitDbHelper.insertHabit(HabitContract.HabitEntry.HABIT_GUITAR, "Every 2nd day", 4);
        habitDbHelper.insertHabit(HabitContract.HabitEntry.HABIT_BASKETBALL, "Tuesday & Sunday", 2);

        Cursor cursor = habitDbHelper.readHabits();

        TextView textView = (TextView) findViewById(R.id.test);
        String dummyText = "";

        try {
            textView.setText("The pets table contains " + cursor.getCount() + " habits.\n\n");
            textView.append(
                            HabitEntry._ID + " - " +
                            HabitEntry.COLUMN_HABIT_NAME + " - " +
                            HabitEntry.COLUMN_HABIT_DAY + " - " +
                            HabitEntry.COLUMN_HABIT_FREQUENCY + "\n"
            );

            while (cursor.moveToNext()) {
                dummyText = "habit: " + cursor.getInt(0) + " " + cursor.getInt(1) +
                        " " + cursor.getString(2) + " " + cursor.getInt(3);
                Log.v(MainActivity.class.getName(), dummyText);

                textView.append(
                                cursor.getInt(0) + " - " +
                                cursor.getInt(1) + " - " +
                                cursor.getString(2) + " - " +
                                cursor.getInt(3) + "\n"
                );
            }
        } finally {
            cursor.close();
        }
    }
}
