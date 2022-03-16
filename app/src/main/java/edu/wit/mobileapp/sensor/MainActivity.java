package edu.wit.mobileapp.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text);
        //Get the SensorManager
        SensorManager mgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        //Get List of sensors in device
        List<Sensor> sensors = mgr.getSensorList(Sensor.TYPE_ALL);

        //Message that will hold all information about sensors
        StringBuilder message = new StringBuilder(2048);
        message.append("The sensors on this device are:\n");
        message.append("===================================\n\n");

        //For loop to append information
        for(Sensor s : sensors){
            message.append(s.getName()+"\n");
            message.append("    Type: "+sensorTypes.get(s.getType())+"\n");
            message.append("    Vendor: "+s.getVendor()+"\n");
            message.append("    Version: "+s.getVersion()+"\n");
            message.append("    Resolutions: "+s.getResolution()+"\n");
            message.append("    Max Range: "+s.getMaximumRange()+"\n");
            message.append("    Power: "+s.getPower()+"mA\n\n");
        }

        //Set the message in the TextView
        text.setText(message);
    }
}