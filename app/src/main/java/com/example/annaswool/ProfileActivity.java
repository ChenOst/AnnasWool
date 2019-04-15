package com.example.annaswool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    //vars
    Button signOut, pay;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    Toolbar toolbar;
    private ArrayList<String> imgItem= new ArrayList();
    private ArrayList<String> tvItemDescription= new ArrayList();
    private ArrayList<String> tvItemPrice= new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        signOut = findViewById(R.id.btnSignOut);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

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
