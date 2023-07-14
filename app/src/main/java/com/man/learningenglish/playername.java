package com.man.learningenglish;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.Nullable;


public class playername extends Activity {
    EditText NhapTen;
    Button BatDau, TroVe;
    Spinner Spin;
    String Arr[] = {"5", "6", "7", "8", "9", "10"};
    int ViTri;
    int number=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playername);

        NhapTen = (EditText)findViewById(R.id.UserName);
        BatDau= (Button)findViewById(R.id.Start);
        Spin = (Spinner)findViewById(R.id.Spinner);
        TroVe = (Button)findViewById(R.id.Back);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.buttonclick);

        CreateSpin();
        BatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                choosenumber();
                String name;
                name = NhapTen.getText().toString().trim();
                Intent intent = new Intent(playername.this, englishquiz_test.class);
                Bundle bundle = new Bundle();
                bundle.putInt("number", number);
                bundle.putString("name", name);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });

        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent1 = new Intent(playername.this, englishquiz.class);
                startActivity(intent1);
                finish();
            }
        });
    }
    void CreateSpin()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item,Arr);

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        Spin.setAdapter(adapter);

        Spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ViTri = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ViTri=-1;
            }
        });
    }

    protected void choosenumber()
    {
        switch (ViTri)
        {
            case 0: number=5; break;
            case 1: number=6; break;
            case 2: number=7; break;
            case 3: number=8; break;
            case 4: number=9; break;
            case 5: number=10;break;
        }
    }
}
