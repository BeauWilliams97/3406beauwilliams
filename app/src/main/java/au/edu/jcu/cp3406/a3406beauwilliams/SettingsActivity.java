package au.edu.jcu.cp3406.a3406beauwilliams;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private RadioButton inches;
    private RadioButton centimeters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpViews();

        inches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inches.setChecked(true);
                saveSelectedMetric();
            }
        });
        centimeters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                centimeters.setChecked(true);
                saveSelectedMetric();
            }
        });
        loadSelectedMetric();
    }

    //initial set up of views
    public void setUpViews(){
        inches = findViewById(R.id.inches);
        centimeters = findViewById(R.id.cm);
    }
    //this method makes it so the back button on the toolbar redirects the user back to main
        public boolean onOptionsItemSelected(MenuItem item){

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //method to save radio button state using shared preferences
    public void saveSelectedMetric(){
        sharedPreferences = getApplicationContext().getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("inchesState", inches.isChecked());
        editor.putBoolean("cmState", centimeters.isChecked());
        editor.apply();
    }
    //method to load saved shared preferences
    public void loadSelectedMetric(){
        sharedPreferences = getApplicationContext().getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        inches.setChecked(sharedPreferences.getBoolean("inchesState", false));
        centimeters.setChecked(sharedPreferences.getBoolean("cmState", false));
    }
}


