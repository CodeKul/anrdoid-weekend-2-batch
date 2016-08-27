package com.codekul.locatoinapi;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Log.i("@codekul","location changed");
            addText("Lat - "+location.getLatitude() +" Lng - "+location.getLongitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    };

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Boolean isEntering =
                    intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);
            if(isEntering){

            }
            else {

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initLocationManager();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.codekul.pune");
        registerReceiver(receiver,filter);
    }

    private void initLocationManager() {

        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        List<String> providers = manager.getAllProviders();
        for (String provider : providers) {
            addText(provider);
        }

        Criteria criteria = new Criteria();
        criteria.setCostAllowed(true);
        criteria.setAltitudeRequired(true);
        criteria.setSpeedRequired(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setAccuracy(Criteria.ACCURACY_FINE);

        registerLocationListener(manager);
    }

    private void registerLocationListener(LocationManager manager){

        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},1234);
        }
        else {
            Intent intent = new Intent();
            intent.setAction("com.codekul.pune");

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)              manager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 500, 0.3f, listener);
            else  manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 0.3f, listener);

            manager.addProximityAlert(17.54, 72.83,10,-1, PendingIntent.getBroadcast(this,1345,intent,PendingIntent.FLAG_UPDATE_CURRENT));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 1234){

            if(grantResults.length > 0){
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                    // granted
                }
                else {
                    // not granted
                }
            }
        }
    }

    private void nameToLocation(String place){
        Geocoder coder = new Geocoder(this);
        try {
            List<Address> addresses = coder.getFromLocationName(place,5);

            for (Address address : addresses) {
                addText("CC - "+address.getCountryCode());
                addText("CN - "+address.getCountryName());
                addText("0 - "+address.getAddressLine(0));
                addText("1 - "+address.getAddressLine(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void coordinatesToLocation(double lat, double lng){
        Geocoder coder = new Geocoder(this);
        try {
            List<Address> addresses = coder.getFromLocation(lat,lng,10);

            for (Address address : addresses) {
                addText("--------------");
                addText("CC - "+address.getCountryCode());
                addText("CN - "+address.getCountryName());
                addText("0 - "+address.getAddressLine(0));
                addText("1 - "+address.getAddressLine(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addText(String text){
        ((TextView)findViewById(R.id.textInfo)).append("\n"+text);
    }
}
