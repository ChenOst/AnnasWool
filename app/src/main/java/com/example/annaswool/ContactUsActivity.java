package com.example.annaswool;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ContactUsActivity extends AppCompatActivity {

    private EditText etSubject, etMessage;
    Button btnSendMessage;
    Toolbar toolbar;
    FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();

        etSubject = findViewById(R.id.etSubject);
        etMessage = findViewById(R.id.etMessage);
        btnSendMessage = findViewById(R.id.btnSendMessage);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail(){
        String[] sendToAnna = {"chenostrovski@gmail.com"};
        String subject = etSubject.getText().toString();
        String message = etMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, sendToAnna);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
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
