package com.example.annaswool;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    //vars
    EditText eMail, password;
    Button login;
    Toolbar toolbar;
    TextView register, forgotPassword;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eMail = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.txtRegister);
        forgotPassword = findViewById(R.id.txtForgotPassword);
        forgotPassword = findViewById(R.id.txtForgotPassword);
        firebaseAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    progressBar.setVisibility(View.VISIBLE);
                    firebaseAuth.signInWithEmailAndPassword(eMail.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    } else {
                                        Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eMail.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Enter your eMail, inorder to set your new password", Toast.LENGTH_LONG).show();
                }
                else {
                    firebaseAuth.sendPasswordResetEmail(eMail.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "Password was send to your eMail", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });
    }

    private boolean isValid(){
        boolean result = false;
        String userEmail = eMail.getText().toString();
        String userPassword = password.getText().toString();

        if(userEmail.isEmpty() && userPassword.isEmpty()){
            Toast.makeText(LoginActivity.this, "Please enter all ditails", Toast.LENGTH_SHORT).show();
        }
        else if(userEmail.isEmpty()){
            Toast.makeText(LoginActivity.this, "Please enter an e-mail", Toast.LENGTH_SHORT).show();
        }
        else if(!userEmail.contains("@")){
            Toast.makeText(LoginActivity.this, "Wrong e-mail addres", Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }
        return result;
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
