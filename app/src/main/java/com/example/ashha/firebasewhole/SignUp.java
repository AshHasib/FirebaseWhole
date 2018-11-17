package com.example.ashha.firebasewhole;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    FirebaseAuth auth;
    EditText txtUser,txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();


    }

    public void init()
    {
        txtUser=(EditText)findViewById(R.id.txtEmail);
        txtPass=(EditText)findViewById(R.id.txtPass);
        auth=FirebaseAuth.getInstance();
    }

    public void createUser(View v){
        String email=txtUser.getText().toString();
        String pass=txtPass.getText().toString();

        if(!email.equals("") && !pass.equals("")){
            auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(SignUp.this,"User Created",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(SignUp.this, "There was some problem",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        else {
            Toast.makeText(SignUp.this,"Please fill up valid information",Toast.LENGTH_LONG).show();
        }
    }
}
