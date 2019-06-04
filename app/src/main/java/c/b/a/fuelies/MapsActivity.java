package c.b.a.fuelies;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Date;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private float last_x, last_y, last_z;

    long lastUpdate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // Setup the accelerometer
        sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener((SensorEventListener) this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onSensorChanged(SensorEvent event)
    {
        Sensor mysensor = event.sensor;

        if (mysensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            float x = event.values[0]; //X value
            float y = event.values[1]; //Y value
            float z = event.values[2]; //Z value

            long curTime = System.currentTimeMillis();

            if (Math.abs(curTime - lastUpdate) > 2000)
            {
                SimpleDateFormat date = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    date = new SimpleDateFormat("dd-MM-yyyy");
                }
                String currentDateTime = date.format(new Date());

                lastUpdate = curTime;

                if (Math.abs(last_x - x) > 10)
                {
                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(-25.676791,28.142845))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
                            .title("Hey you moved the x axis" + currentDateTime));

                }
                if (Math.abs(last_y - y) > 10)
                {
                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(-25.686791,28.142846))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
                            .title("Hey you moved the y axis" + currentDateTime));

                }
                if (Math.abs(last_z - z) > 10)
                {
                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(-25.696791,28.142847))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
                            .title("Hey you moved the z axis" + currentDateTime));

                }
                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Pretoria and move the camera
        LatLng pta = new LatLng(-25.683880, 28.131144);
        mMap.addMarker(new MarkerOptions()
                .position(pta).title("Marker in BelgiumCampus"))
                .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pta));

        /*
        // Add marker on sasol
        LatLng sasol = new LatLng(-25.767752, 28.142813);
        mMap.addMarker(new MarkerOptions()
                .position(sasol).title("Marker in BelgiumCampus"))
                .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sasol));
        */



    }
}
