package com.example.signuplogin;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    EditText signup_email,signup_password;
    Button signup_btn;
    TextView signup_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth=FirebaseAuth.getInstance();
        signup_email=findViewById(R.id.signup_email);
        signup_password=findViewById(R.id.signup_password);
        signup_text=findViewById(R.id.signup_text);
        signup_btn=findViewById(R.id.signup_btn);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=signup_email.getText().toString();
                String pass=signup_password.getText().toString();
                if(user.isEmpty()){
                    signup_email.setError("Email cannot be empty");

                }if (pass.isEmpty()){
                    signup_text.setError("Password cannot be empty");
                }else{
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignupActivity.this,"Signup Successful",Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(SignupActivity.this,MainActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(SignupActivity.this,"Signup Failed:"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });
        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}