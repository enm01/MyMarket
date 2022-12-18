package com.example.mymarket;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.mymarket.productDBcontract.productDB;


public class productDBHelper extends SQLiteOpenHelper{


        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "market.db";
        public productDBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_product_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersio, int newVersion) {

            db.execSQL(DELETE_USER_TABLE);
            onCreate(db);

        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }


    private static final String CREATE_product_TABLE = "CREATE TABLE " +productDB.TABLE_NAME +
                "( " + productDB._ID + " INTEGER PRIMARY KEY," +
                productDB.COLUMN_NAME_COL1 + " text," +
                productDB.COLUMN_NAME_COL2 + " text," +
                productDB.COLUMN_NAME_COL3 + " text," +
                productDB.COLUMN_NAME_COL4 + " text)";
        private static final String DELETE_USER_TABLE = "DROP TABLE IF EXISTS " + productDB.TABLE_NAME;




}
