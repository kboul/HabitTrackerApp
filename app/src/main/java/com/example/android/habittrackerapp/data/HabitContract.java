package com.example.android.habittrackerapp.data;

import android.provider.BaseColumns;

/**
 * Created by KostasBoul on 09.07.17.
 */

public class HabitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract() {}

    /**
     * Inner class that defines constant values for the habits database table.
     * Each entry in the table represents a single habit.
     */
    public static final class PetEntry implements BaseColumns {

        /** Name of database table for habits */
        public final static String TABLE_NAME = "habits";

        /**
         * Unique ID number for the pet (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the habit.
         *
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_NAME ="habit";

        /**
         * Date I will do the habit.
         *
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_FREQUENCY = "date";


        /**
         * Possible values for the name of the habit.
         */
        public static final int HABIT_GYM = 0;
        public static final int HABIT_GUITAR = 1;
        public static final int HABIT_BASKETBALL = 2;
    }
}
