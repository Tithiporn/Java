package com.example.restaurant;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUp extends AppCompatActivity {

    private EditText Username, Email, Password;
    private Button buttonSignUp;
    private TextView SignUpInform;
    private FirebaseAuth firebaseAuth;
    String  name, password, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();


        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())


                //Upload database
                {
                    String User_email = Email.getText().toString().trim();
                    String User_Password = Password.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(User_email, User_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                sendEmailVerification();
                           /*sentUserdata();
                           Toast.makeText(SignUp.this, "Register Completed!, Upload Completed!", Toast.LENGTH_SHORT).show();
                           firebaseAuth.signOut();
                           finish();
                           startActivity(new Intent(SignUp.this, SignIn.class));*/

                            } else {
                                Toast.makeText(SignUp.this, "Register Failed!", Toast.LENGTH_SHORT).show();
                                //show set password again
                            }

                        }
                    });
                }
            }


        });



        SignUpInform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
            }
        });


    }





    private void setupUIViews() {
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        Email = (EditText) findViewById(R.id.Email);
        buttonSignUp = (Button) findViewById(R.id.SignUp);
        SignUpInform = (TextView) findViewById(R.id.SignUpInform);

    }

    private boolean validate(){
        boolean result = false;
        name = Username.getText().toString();
        password = Password.getText().toString();
        email = Email.getText().toString();

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please fill information", Toast.LENGTH_SHORT).show();
        }
        else {
            result = true;
        }
        return result;
    }

    private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser != null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        sentUserdata();
                        Toast.makeText(SignUp.this, "Register Completed!, Verification mail sent!", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(SignUp.this, SignIn.class));
                    }else{
                        Toast.makeText(SignUp.this, "Register Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void sentUserdata(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(Objects.requireNonNull(firebaseAuth.getUid()));
        Userprofile userprofile = new Userprofile(name, email);
        myRef.setValue(userprofile);

    }

}

