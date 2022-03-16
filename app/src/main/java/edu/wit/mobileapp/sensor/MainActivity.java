package edu.wit.mobileapp.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
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
        sensors.forEach(s -> {
            message.append(s.getName() + "\n");
            message.append("    Type: " + sensorTypes.get(s.getType()) + "\n");
            message.append("    Vendor: " + s.getVendor() + "\n");
            message.append("    Version: " + s.getVersion() + "\n");
            message.append("    Resolutions: " + s.getResolution() + "\n");
            message.append("    Max Range: " + s.getMaximumRange() + "\n");
            message.append("    Power: " + s.getPower() + "mA\n\n");
        });

        //Set the message in the TextView
        text.setText(message);
    }

    private HashMap<Integer, String> sensorTypes = new HashMap<>();

    {
        sensorTypes.put(Sensor.TYPE_ACCELEROMETER, "TYPE_ACCELEROMETER");
        sensorTypes.put(Sensor.TYPE_GRAVITY, "TYPE_GRAVITY");
        sensorTypes.put(Sensor.TYPE_GYROSCOPE, "TYPE_GYROSCOPE");
        sensorTypes.put(Sensor.TYPE_LIGHT, "TYPE_LIGHT");
        sensorTypes.put(Sensor.TYPE_LINEAR_ACCELERATION, "TYPE_LINEAR_ACCELERATION");
        sensorTypes.put(Sensor.TYPE_MAGNETIC_FIELD, "TYPE_MAGNETIC_FIELD");
        sensorTypes.put(Sensor.TYPE_ORIENTATION, "TYPE_ORIENTATION (deprecated)");
        sensorTypes.put(Sensor.TYPE_PRESSURE, "TYPE_PRESSURE");
        sensorTypes.put(Sensor.TYPE_PROXIMITY, "TYPE_PROXIMITY");
        sensorTypes.put(Sensor.TYPE_RELATIVE_HUMIDITY, "TYPE_RELATIVE_HUMIDITY");
        sensorTypes.put(Sensor.TYPE_GAME_ROTATION_VECTOR, "TYPE_GAME_ROTATION_VECTOR");
        sensorTypes.put(Sensor.TYPE_ROTATION_VECTOR, "TYPE_ROTATION_VECTOR");
        sensorTypes.put(Sensor.TYPE_TEMPERATURE, "TYPE_TEMPERATURE (deprecated)");
    }
}