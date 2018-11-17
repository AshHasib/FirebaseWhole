package com.example.ashha.firebasewhole;

import android.content.Intent;
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

public class SignIn extends AppCompatActivity {
    FirebaseAuth auth;
    EditText txtUser,txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        init();

        Button btnLogin=(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=txtUser.getText().toString();
                String pass=txtPass.getText().toString();
                if(email.equals("") && pass.equals("")){
                    Toast.makeText(getApplicationContext(),"Please fillup with valid info",Toast.LENGTH_LONG).show();
                }
                else {
                    auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignIn.this,"Login Successful",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(getApplicationContext(),Profile.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(SignIn.this, "There was some problem",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }

    public void init()
    {
        txtUser=(EditText)findViewById(R.id.txtEmail);
        txtPass=(EditText)findViewById(R.id.txtPass);
        auth=FirebaseAuth.getInstance();
    }

}
