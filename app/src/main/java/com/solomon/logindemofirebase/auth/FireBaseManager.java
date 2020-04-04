package com.solomon.logindemofirebase.auth;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FireBaseManager  {
    FirebaseAuth auth;

    public FireBaseManager() {
        auth = FirebaseAuth.getInstance();
    }

    private void setupAuthStateListener(){
        auth.addIdTokenListener(new FirebaseAuth.IdTokenListener() {
            @Override
            public void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null) {
                    System.out.println("Signed out from the app ");
                } else{
                    System.out.println("Signed in to app ");
                }
            }
        });
    }

    // sign in will require email, password
    public void signIn(String email, String passWord, final Activity activity){
        auth.signInWithEmailAndPassword(email, passWord)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            System.out.println("LOGIN success " + task.getResult().getUser().getEmail());
                        }else {
                            System.out.println("LOGIN failed " + task.getException());
                        }
                    }
                });
    }

    public void signUp(String email, String passWord){
        auth.createUserWithEmailAndPassword(email,passWord)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            System.out.println("Sign Up success " + task.getResult().getUser().getEmail());
                        }else {
                            System.out.println("Sign Up failed " + task.getException());
                        }
                    }
                });
    }

    public void signOut(){
        auth.signOut(); // sign out the current user
    }
}
