package au.edu.jcu.cp3406.a3406beauwilliams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private Button calculate;
    private Button reset;
    private TextView metric_choice;
    private TextView tv_result;
    private TextView months;
    private double result;
    public double inches = 0.5;
    double growTime;
    public double centimeters = 1.27;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateClicked(v);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetClicked(v);
            }
        });
    }
    @Override
    //method to create options menu where settings is accessed
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    //this method is required to update the metric TextView after returning from settings
    public void onResume()
    {
        super.onResume();
        setUpViews();
        updateViews();
    }

    @Override
    //handles settings option on toolbar and directs user to SettingsActivity on click
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            Toast.makeText(this, "Settings...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
    //method which performs hair growth calculation when the calculate button is clicked
    public void calculateClicked(View view){
        sharedPreferences = getApplicationContext().getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        boolean inchesMetric = sharedPreferences.getBoolean("inchesState", false);
        boolean cmMetric = sharedPreferences.getBoolean("cmState", false);
        if (inchesMetric){
            growTime = Double.parseDouble(months.getText().toString());
            result = growTime * inches;
            tv_result.setText("             " + result);
        }
        else if (cmMetric){
            growTime = Double.parseDouble(months.getText().toString());
            result = growTime * centimeters;
            tv_result.setText("             " + result);
        }

    }
    //resets both the input and result parameter when the reset button is clicked
    public void resetClicked(View view){
        tv_result.setText("");
        months.setText("");
    }
    //initial set up of views
    private void setUpViews(){
        calculate = findViewById(R.id.calculate);
        reset = findViewById(R.id.reset);
        months = findViewById(R.id.months_et);
        tv_result = findViewById(R.id.tv_result);
        metric_choice = findViewById(R.id.metricChoice);
    }
    //after choosing desired metric in settings, this updates the TextView which displays said metric.
    private void updateViews(){
        //get result from selection in settings
        sharedPreferences = getApplicationContext().getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        boolean inchesMetric = sharedPreferences.getBoolean("inchesState", false);
        boolean cmMetric = sharedPreferences.getBoolean("cmState", false);
        if (inchesMetric){
            metric_choice.setText("inches");
        }
        else if (cmMetric)
            metric_choice.setText("cm");
    }
}
