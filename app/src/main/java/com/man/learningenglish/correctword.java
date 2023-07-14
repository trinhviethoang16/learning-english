package com.man.learningenglish;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class correctword extends AppCompatActivity {
    Button BatDau, DiemCao, TroVe, HuongDan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correctword);

        BatDau = (Button)findViewById(R.id.Start);
        DiemCao = (Button)findViewById(R.id.HighScore);
        TroVe = (Button)findViewById(R.id.Back);
        HuongDan = (Button)findViewById(R.id.Tutorial);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.buttonclick);

        BatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent = new Intent(correctword.this, entername.class);
                startActivity(intent);
            }
        });

        DiemCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent1 = new Intent(correctword.this, correctword_highscore.class);
                startActivity(intent1);
            }
        });

        HuongDan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent2 = new Intent(correctword.this, huongdanword.class);
                startActivity(intent2);
            }
        });

        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent3 = new Intent(correctword.this, homepage.class);
                startActivity(intent3);
                finish();
            }
        });
    }
}
