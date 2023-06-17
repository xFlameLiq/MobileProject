package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtEmailRegister, txtPassRegister;
    private SesionUser sesionUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sesionUser = (SesionUser) getIntent().getSerializableExtra("User");
        txtEmailRegister = (EditText) findViewById(R.id.txtEmailRegister);
        txtPassRegister = (EditText) findViewById(R.id.txtPassRegister);
    }

    public void register(View view) {
        String email = txtEmailRegister.getText().toString();
        String pass = txtPassRegister.getText().toString();
        User user = new User(email, pass, 0);
        int successful = sesionUser.users.addUser(user);
        if (successful > 0) {
            Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "LIMITE ALCANZADO", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToLogin (View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("User", sesionUser);
        startActivity(intent);
        finish();
    }
}