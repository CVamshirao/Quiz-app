package com.example.signuplogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText login_email,login_password;
    private Button login_btn;
    private TextView login_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth=FirebaseAuth.getInstance();
        login_email=findViewById(R.id.login_email);
        login_password=findViewById(R.id.login_password);
        login_btn=findViewById(R.id.login_btn);
        login_text=findViewById(R.id.login_text);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String email=login_email.getText().toString();
            String pass=login_password.getText().toString();

            if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                if (!pass.isEmpty()){
                    auth.signInWithEmailAndPassword(email,pass)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(LoginActivity.this,"login Successful",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                    startActivity(intent);
                                    login_email.setText("");
                                    login_password.setText("");
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(LoginActivity.this,"login Failure",Toast.LENGTH_SHORT).show();
                                    login_email.setText("");
                                    login_password.setText("");
                                }
                            });
                }else {
                    login_password.setError("password cannot be empty");
                    //Toast.makeText(LoginActivity.this,"login Successful",Toast.LENGTH_SHORT).show();
                }

            }else if(email.isEmpty()){
                login_email.setError("Email cannot be empty");
            }else {
                login_email.setError("please enter valid email");
                }
            }
        });
            login_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                    startActivity(intent);
                }
            });
    }
}