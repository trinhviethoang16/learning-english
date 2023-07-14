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
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    Button Login, Register;
    EditText Email, Password;
    private FirebaseAuth Authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Register = (Button) findViewById(R.id.DangKy);
        Login = (Button) findViewById(R.id.DangNhap);
        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
        Authentication = (FirebaseAuth)FirebaseAuth.getInstance();
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.buttonclick);
//        final MediaPlayer soundtrack = MediaPlayer.create(this,R.raw.soundtrack);
//        soundtrack.start();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                login();
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                register();
            }
        });

    }

    private void register() {
        Intent intent = new Intent(MainActivity.this, register.class);
        startActivity(intent);
    }

    private void login() {
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

        Authentication.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công !", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(MainActivity.this, homepage.class);
                    startActivity(intent1);
                } else {
                    Toast.makeText(getApplicationContext(), "Đăng nhập không thành công !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}