package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtNameRegister, txtLastRegister, txtEmailRegister, txtPassRegister, txtStudentIDRegister;
    private Spinner spGrade;
    private SesionUser sesionUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sesionUser = (SesionUser) getIntent().getSerializableExtra("User");

        txtNameRegister = (EditText) findViewById(R.id.txtNameRegister);
        txtLastRegister = (EditText) findViewById(R.id.txtLastNameRegister);
        txtEmailRegister = (EditText) findViewById(R.id.txtEmailRegister);
        txtPassRegister = (EditText) findViewById(R.id.txtPassRegister);
        txtStudentIDRegister = (EditText) findViewById(R.id.txtStudentID);

        spGrade = (Spinner) findViewById(R.id.spGrade);
        String[] arrayGrade = {"1", "2", "3", "4", "5", "6", "7", "8"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrayGrade);
        spGrade.setAdapter(adapter);
    }

    public void register(View view) {
        String nombre = txtNameRegister.getText().toString();
        String apellido = txtLastRegister.getText().toString();
        String email = txtEmailRegister.getText().toString();
        String pass = txtPassRegister.getText().toString();
        String registro = txtStudentIDRegister.getText().toString();

        int grado = Integer.parseInt(spGrade.getSelectedItem().toString());

        User user = new User(0, nombre, apellido, email, pass, registro, grado);
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