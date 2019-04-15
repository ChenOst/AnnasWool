package com.example.annaswool;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LocationActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    TextView location;
    Toolbar toolbar;
    FirebaseAuth mAuth;
    FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        toolbar = findViewById(R.id.toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        location = findViewById(R.id.tvLocation);
        location.setText("Through the carob 52, Shilat");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng businessLocation = new LatLng(31.919164, 35.023572);
        map.addMarker(new MarkerOptions().position(businessLocation).title("Annas Wool"));
        map.moveCamera(CameraUpdateFactory.newLatLng(businessLocation));

    }
    //ToolBar Functions
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.subitem1:
                Toast.makeText(this, "Main Menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                return true;
            case R.id.subitem2:
                Toast.makeText(this, "Customer Service", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, ContactUsActivity.class);
                this.startActivity(intent);
                return true;
            case R.id.subitem3:
                Toast.makeText(this, "Store Location", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, LocationActivity.class);
                startActivity(intent);
                return true;
            case R.id.subitem4:
                Toast.makeText(this, "About us", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, AboutUsActivity.class);
                this.startActivity(intent);
                return true;
            case R.id.item_account:
                Toast.makeText(this, "account", Toast.LENGTH_SHORT).show();
                if (firebaseUser==null) {
                    Intent intent1 = new Intent(this, LoginActivity.class);
                    startActivity(intent1);
                }
                else{
                    Intent intent1 = new Intent(this, ProfileActivity.class);
                    startActivity(intent1);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
