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
        for(Sensor sensor : sensors){
            message.append(sensor.getName()+"\n");
            message.append("    Type: "+sensorTypes.get(sensor.getType())+"\n");
            message.append("    Vendor: "+sensor.getVendor()+"\n");
            message.append("    Version: "+sensor.getVersion()+"\n");
            message.append("    Resolutions: "+sensor.getResolution()+"\n");
            message.append("    Max Range: "+sensor.getMaximumRange()+"\n");
            message.append("    Power: "+sensor.getPower()+"mA\n\n");
        }

        text.setText(message);
    }
}