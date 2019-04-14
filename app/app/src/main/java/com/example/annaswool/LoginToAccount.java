package com.example.annaswool;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginToAccount extends AppCompatActivity {

    private static final String TAG = "LoginToAccount";

    //vars
    private EditText name, password;
    private Button login;
    private TextView signUser;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountlogin);
        Log.d(TAG, "onCreate: started.");
        setUpViews();
        setSupportActionBar(toolbar);

        //onCkickListeners
        signUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isNotRegisterd();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isValid(name.getText().toString(), password.getText().toString());
            }
        });
    }

    /**
     * Sets all the views
     */
    private void setUpViews() {
        toolbar = findViewById(R.id.toolbar);
        name = findViewById(R.id.nametext);
        password = findViewById(R.id.passwordtext);
        login = findViewById(R.id.loginbutton);
        signUser = findViewById(R.id.signusertextView);
    }

    /**
     * If the user is not registered, transfer to the RegistrationActivity.class in order to register
     */
    private void isNotRegisterd() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    /**
     * If the values of name and password are valid
     * @param userName
     * @param userPassword
     */
    private void isValid(String userName, String userPassword) {
        Intent intent = new Intent(this, MainActivity.class);
        Toast.makeText(this, "Welcome " + userName.toString(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
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
        switch (item.getItemId()) {
            case R.id.subitem1:
                Toast.makeText(this, "Main Menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                return true;
            case R.id.subitem2:
                Toast.makeText(this, "Customer Service", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem3:
                Toast.makeText(this, "Store Location", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_account:
                Toast.makeText(this, "account", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, LoginToAccount.class);
                this.startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
