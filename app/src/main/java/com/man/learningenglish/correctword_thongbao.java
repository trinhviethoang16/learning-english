package com.man.learningenglish;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class correctword_thongbao extends Activity {
    Button ChoiLai, TroVe;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.correctword_thongbao);
        ChoiLai = (Button) findViewById(R.id.PlayAgain);
        TroVe = (Button) findViewById(R.id.Back);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.buttonclick);

        ChoiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent = new Intent(correctword_thongbao.this, entername.class);
                startActivity(intent);
                finish();
            }
        });

        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent1 = new Intent(correctword_thongbao.this, correctword.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}
