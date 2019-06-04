package c.b.a.fuelies;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afri Upholstery on 21 Mar 2017.
 */

 class Driver {
    private int id;
    private String driverName;
    private String regNum;
    private String model;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Driver(int id, String driverName, String regNum, String model) {
        this.id = id;
        this.driverName = driverName;
        this.regNum = regNum;
        this.model = model;
    }
}

public class CustomAdapter extends ArrayAdapter<Driver> {
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public CustomAdapter(Context context, int resource, List<Driver> drivers) {
        super(context, resource, drivers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        inflater = LayoutInflater.from(getContext());
        view = inflater.inflate(R.layout.activity_list_item, null);

        Driver d = getItem(position);

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView reg = (TextView) view.findViewById(R.id.regnumber);
        TextView model = (TextView) view.findViewById(R.id.model);

        name.setText(d.getDriverName());
        reg.setText(d.getRegNum());
        model.setText(d.getModel());

        return view;
    }

}
