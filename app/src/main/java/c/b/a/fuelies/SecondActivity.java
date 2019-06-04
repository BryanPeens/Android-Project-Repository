package c.b.a.fuelies;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static c.b.a.fuelies.R.id.TextViewDriverName;

public class SecondActivity extends AppCompatActivity {

    public static UserDbHelperClass userDbHelper;
    EditText ContactName, ContactReg, ContactOdoRead, ContactModelName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ContactName = (EditText) findViewById(R.id.EditTextDriverName);
        ContactReg = (EditText) findViewById(R.id.EditTextRegNumber);
        ContactOdoRead = (EditText) findViewById(R.id.EditTextOdoReading);
        ContactModelName = (EditText) findViewById(R.id.EditTextModel);
    }

    public  void addDriver(View view)
    {
        String name = ContactName.getText().toString();
        String reg = ContactReg.getText().toString();
        String odo = ContactOdoRead.getText().toString();
        String model = ContactModelName.getText().toString();

        userDbHelper = new UserDbHelperClass(getApplicationContext());
        userDbHelper.insertDriver(name, reg, odo, model);

        Toast.makeText(getBaseContext(), "Successfully inserted", Toast.LENGTH_LONG).show();
    }

}
