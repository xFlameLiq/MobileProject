package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText txtEmailLogin, txtPassLogin;
    private SesionUser sesionUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sesionUser = (SesionUser) getIntent().getSerializableExtra("User");
        txtEmailLogin = (EditText) findViewById(R.id.txtEmailLogin);
        txtPassLogin = (EditText) findViewById(R.id.txtPassLogin);
    }

    public void validateLogin(View view) {
        String email = txtEmailLogin.getText().toString();
        String pass = txtPassLogin.getText().toString();
        int found = this.sesionUser.users.validateUser(email,pass);
        if(found > 0) {
            Toast.makeText(this, "Usuario encontrado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.putExtra("User", sesionUser);
        startActivity(intent);
        finish();
    }
}