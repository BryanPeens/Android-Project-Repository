package c.b.a.fuelies;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class ListDataAdapter extends ArrayAdapter
{
    List list = new ArrayList<>();

    public ListDataAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView NAME, REG, KILOS;
    }


    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View row = convertView;
        LayoutHandler layoutHandler = null;
        // Create the row if none exist
        if (row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_row, parent, false);

            layoutHandler = new LayoutHandler();
            layoutHandler.NAME = (TextView) row.findViewById(R.id.TextViewDriverName);
            layoutHandler.REG = (TextView) row.findViewById(R.id.TextViewRegistrationNumber);
            layoutHandler.KILOS = (TextView) row.findViewById(R.id.TextViewOdoReading);


            row.setTag(layoutHandler);

        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }
        DataProvider provider = (DataProvider) this.getItem(position);
        layoutHandler.NAME.setText(provider.getName());
        layoutHandler.REG.setText(provider.getRegistration());
        layoutHandler.KILOS.setText(provider.getKilos());


        return row;
    }
}
