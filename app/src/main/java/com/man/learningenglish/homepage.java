package com.man.learningenglish;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity{
    Button EnglishQuiz, CorrectWord, Thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        EnglishQuiz = (Button) findViewById(R.id.EnglishQuiz);
        Thoat = (Button) findViewById(R.id.LogOut);
        CorrectWord = (Button) findViewById(R.id.CorrectWord);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.buttonclick);

        EnglishQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent = new Intent(homepage.this, englishquiz.class);
                startActivity(intent);
            }
        });

        CorrectWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent1 = new Intent(homepage.this, correctword.class);
                startActivity(intent1);
            }
        });

        Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent2 = new Intent(homepage.this, MainActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}
