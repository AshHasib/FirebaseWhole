package com.example.ashha.firebasewhole;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void signUp(View v){
        Intent intent=new Intent(this,SignUp.class);
        startActivity(intent);
        finish();
    }

    public void signIn(View v){
        Intent intent=new Intent(this,SignIn.class);
        startActivity(intent);
        finish();
    }
}
