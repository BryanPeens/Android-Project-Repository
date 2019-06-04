package c.b.a.fuelies;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void onButtonClick(View v)
    {
        String addButton_text;
        addButton_text = ((Button) v).getText().toString();

        if (addButton_text.equals("Add Driver"))
        {
            // Open second activity
            Intent i = new Intent(this, SecondActivity.class);
            startActivity(i);
        }
        else if (addButton_text.equals("Drivers"))
        {
                // Open third activity
                Intent i = new Intent(this, ThirdActivity.class);
                startActivity(i);
        }
        else if (addButton_text.equals("Exit"))
        {
            finish();
        }
    }
}
