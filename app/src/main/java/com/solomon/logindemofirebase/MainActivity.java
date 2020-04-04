package com.solomon.logindemofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.solomon.logindemofirebase.auth.FireBaseManager;

public class MainActivity extends AppCompatActivity {
    private EditText emailText;
    private EditText passwordText;
    private FireBaseManager fireBaseManager = new FireBaseManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passWordText);

    }

    public void signIn(View view){
        //System.out.println("sign in"); to test if the button is working
        // call firebase manager signIn method
//        if(emailText.getText().toString().length() > 0 &&
//                passwordText.getText().toString().length() > 0 ) {
//            fireBaseManager.signIn();
//        }
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if(email.length() > 0 && password  .length() > 0 ) {
          fireBaseManager.signIn(email, password, this);
        }

    }

    public void signUp(View view){
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if(email.length() > 0 && password  .length() > 0 ) {
            fireBaseManager.signUp(email, password);
        }
    }

    public void signOut(View view){
        fireBaseManager.signOut();
    }
}
