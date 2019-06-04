package c.b.a.fuelies;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity
{
    public static UserDbHelperClass userDbHelper;
    GoogleMap googlemap;
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ArrayList<Driver> array_list = new ArrayList<Driver>();
        userDbHelper = new UserDbHelperClass(getApplicationContext());
        array_list = userDbHelper.readDrivers();


        ListView driverList = (ListView) findViewById(R.id.DriversList);
        mAdapter = new CustomAdapter(this, R.layout.activity_list_item, array_list);

        driverList.setAdapter(mAdapter);
    }

    public void process(View v)
    {
        Intent i = null;
        if (v.getId() == R.id.btnLaunchMap)
        {
            i = new Intent(Intent.ACTION_VIEW );
            i.setData(Uri.parse("geo:-25.683880,28.131144"));
            Intent chooser = Intent.createChooser(i, "Launch Maps");
            startActivity(chooser);
        }
    }

    public void viewContact(View v)
    {
        Intent i = new Intent(this, RowActivity.class);
        startActivity(i);
    }



}
