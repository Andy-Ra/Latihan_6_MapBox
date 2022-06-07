package com.andyra.latihan6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

public class MainActivity extends AppCompatActivity {
    private MapView petaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_main);
        petaa = (MapView) findViewById(R.id.peta);
        //     mapView.onCreate(savedInstanceState);
        petaa.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override

                    public void onStyleLoaded(@NonNull Style style) {
                    }
                });
                MarkerOptions mmarkerOptions = new MarkerOptions();
                mmarkerOptions.title("Lokasi yang dipilih");
                mmarkerOptions.position(new LatLng(-7.6078738,110.2037513));
                mapboxMap.addMarker(mmarkerOptions);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        petaa.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
        petaa.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        petaa.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        petaa.onStop();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        petaa.onSaveInstanceState(outState);
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        petaa.onLowMemory();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        petaa.onDestroy();
    }
}