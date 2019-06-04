package c.b.a.fuelies;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class RowActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelperClass userDbHelper;
    Cursor cursor;
    ListDataAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_row);
        listView = (ListView) findViewById(R.id.list_view);
        listAdapter = new ListDataAdapter(getApplicationContext(), R.layout.activity_row);
        listView.setAdapter(listAdapter);

//        userDbHelper = new UserDbHelperClass(getApplicationContext());
//        sqLiteDatabase = userDbHelper.getReadableDatabase();
//        cursor = userDbHelper.getInformation(sqLiteDatabase);

        if (cursor.moveToFirst())
            {
                do
                {
                    String name, registration;
                    String kilos;

                    name = cursor.getString(0);
                    registration = cursor.getString(1);
                    kilos = cursor.getString(2);

                    DataProvider provider = new DataProvider(name, registration, kilos);

                    listAdapter.add(provider);

                }
                while (cursor.moveToNext());
            }


    }


}
