package com.example.restaurant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.text.IDNA;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignIn extends AppCompatActivity {

    EditText Username,Password;
    Button buttonSignIn;
    private TextView Inform;
    private int counter = 3; //3 attempt
    private FirebaseAuth firebaseAuth;
    private TextView forgotpassword;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Username = (EditText)findViewById(R.id.Username);
        Password = (EditText)findViewById(R.id.Password);
        buttonSignIn = (Button)findViewById(R.id.buttonSignIn);
        Inform = (TextView)findViewById(R.id.LoginInform);
        Inform.setText("Total attempts: 3");
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        forgotpassword = (TextView)findViewById(R.id.ForgotPassText);

        FirebaseUser user = firebaseAuth.getCurrentUser();






        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, Password.class));
            }
        });

        }

        //Check the username+password
        private void validate(String Username, String Password){

            firebaseAuth.signInWithEmailAndPassword(Username,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        //Toast.makeText(SignIn.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        checkEmailVerification();
                    }
                    else{
                        progressDialog.setMessage("You should register first!");
                        progressDialog.show();
                        Toast.makeText(SignIn.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                        counter--;
                        Inform.setText("Attempt remaining: "+ String.valueOf(counter));
                        progressDialog.dismiss();
                        if(counter == 0) {
                            buttonSignIn.setEnabled(false);
                            Inform.setText("Login deny");

                        }
                    }
                }
            });
        }
        public void checkEmailVerification(){
            FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
            Boolean emailflag = firebaseUser.isEmailVerified();

            if(emailflag){
                finish();
                startActivity(new Intent(SignIn.this, Category.class));
            }else{
                Toast.makeText(SignIn.this, "Verify your Email", Toast.LENGTH_SHORT).show();
                firebaseAuth.signOut();
            }
        }
}
