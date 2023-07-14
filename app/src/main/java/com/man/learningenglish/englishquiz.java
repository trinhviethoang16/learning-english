package com.man.learningenglish;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class englishquiz extends AppCompatActivity {
    Button Start, HighScore, Back, Tutorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.englishquiz);

        Start = (Button)findViewById(R.id.Start);
        HighScore = (Button)findViewById(R.id.HighScore);
        Back = (Button)findViewById(R.id.Back);
        Tutorial = (Button)findViewById(R.id.Tutorial);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.buttonclick);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent = new Intent(englishquiz.this, playername.class);
                startActivity(intent);
            }
        });

        HighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent1 = new Intent(englishquiz.this, englishquiz_highscore.class);
                startActivity(intent1);
            }
        });

        Tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent2 = new Intent(englishquiz.this, huongdanquiz.class);
                startActivity(intent2);
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent3 = new Intent(englishquiz.this, homepage.class);
                startActivity(intent3);
                finish();
            }
        });
    }
}
