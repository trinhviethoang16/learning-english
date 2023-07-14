package com.man.learningenglish;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    private EditText Email, Password;
    private Button Register, Back;
    private FirebaseAuth Authentication;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Authentication = (FirebaseAuth)FirebaseAuth.getInstance();
        Email = (EditText)findViewById(R.id.Email);
        Password = (EditText)findViewById(R.id.Password);
        Register = (Button)findViewById(R.id.ButtonRegister);
        Back = (Button)findViewById(R.id.ButtonBack);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.buttonclick);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                register();
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent = new Intent(register.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void register() {
        String email, pass;
        email = Email.getText().toString();
        pass = Password.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this,"Vui lòng nhập Email !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this,"Vui lòng nhập Password !", Toast.LENGTH_SHORT).show();
            return;
        }
        Authentication.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Tạo tài khoản thành công !", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent (register.this, MainActivity.class);
                    startActivity(intent1);
                } else {
                    Toast.makeText(getApplicationContext(), "Tạo tài khoản không thành công !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}