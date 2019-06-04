package c.b.a.fuelies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

public class UserDbHelperClass extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "userInfo.db";

    public static final String COLUMN_ID = " _id";
    public static final String TABLE_USER_INFO = "user_info";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_REG_NUMBER = "registration_number";
    public static final String COLUMN_ODO_READING = "odometer_reading";
    public static final String COLUMN_MODEL_NAME = "model_name";

    public static final String TABLE_FILL_INFO = "fill_info";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_ODOMETER = "odometer";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_LITERS = "liters";
    public static final String COLUMN_LOCATION = "location";

    public UserDbHelperClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
          String CREATE_TABLE_USER_INFO = "CREATE TABLE  " + TABLE_USER_INFO +
                  "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
                   COLUMN_USER_NAME +" TEXT," +
                     COLUMN_REG_NUMBER + " TEXT," +
                           COLUMN_ODO_READING +" TEXT,"+
                            COLUMN_MODEL_NAME +" TEXT);";
            db.execSQL(CREATE_TABLE_USER_INFO);

        String CREATE_TABLE_FILL_INFO = "CREATE TABLE  " + TABLE_FILL_INFO +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_DATE +" TEXT," +
                COLUMN_ODOMETER + " REAL," +
                COLUMN_PRICE +" REAL," +
                COLUMN_LITERS + " REAL," +
                COLUMN_LOCATION +" TEXT);";
        db.execSQL(CREATE_TABLE_FILL_INFO);

        Log.d("DATABASE OPERATIONS","Tables created...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old_version, int new_version)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_INFO);
        onCreate(db);
    }

    // Method that inserts into the DB
    public void insertDriver(String name, String regNum, String odReading, String modelName)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_NAME, name);
        contentValues.put(COLUMN_REG_NUMBER, regNum);
        contentValues.put(COLUMN_ODO_READING, odReading);
        contentValues.put(COLUMN_MODEL_NAME, modelName);

        db.insert(TABLE_USER_INFO, null, contentValues);
        Log.d("DATABASE OPERATIONS","Values have been inserted...");

        close();
    }

    public void insertFill(Date date, double odo, double price, double liters, String location)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DATE, String.valueOf(date));
        contentValues.put(COLUMN_ODOMETER, odo);
        contentValues.put(COLUMN_PRICE, price);
        contentValues.put(COLUMN_LITERS, liters);
        contentValues.put(COLUMN_LOCATION, location);

        db.insert(TABLE_FILL_INFO, null, contentValues);
        Log.d("DATABASE OPERATIONS","Values have been inserted...");

        close();
    }


    // Method that Reads information from the DB
    public ArrayList<Driver> readDrivers()
    {
        ArrayList<Driver> array_list = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        String SELECT_DRIVERS = "SELECT * FROM " + TABLE_USER_INFO;

        Cursor cursor = db.rawQuery(SELECT_DRIVERS, null);
        cursor.moveToFirst();

        Driver driver = new Driver(0, "Driver", "Reg No", "Model");
        array_list.add(driver);

        while(cursor.isAfterLast() == false){
            driver = new Driver(Integer.parseInt( cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(4));
            array_list.add(driver);
            cursor.moveToNext();
        }

        close();
        return array_list;
    }


}
