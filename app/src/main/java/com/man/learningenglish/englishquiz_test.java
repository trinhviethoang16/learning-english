package com.man.learningenglish;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

class QuestionNare {
    public String ID;
    public String AnswerA, AnswerB, AnswerC, AnswerD, Answer;
}

public class englishquiz_test extends AppCompatActivity {
    TextView KetQua, CauHoi, ThoiGian;
    ImageView HinhAnh;
    RadioGroup RG;
    Button TraLoi, TroGiup, BoQua, KetThuc;
    RadioButton A, B, C, D;
    int pos = 0;
    int kq = 0;
    CountDownTimer Time;
    public ArrayList<QuestionNare> list = new ArrayList();
    public ArrayList<Question> PList = new ArrayList();

    public void countdown() {
        Time = new CountDownTimer(21000, 1000) {

            public void onTick(long millisUntilFinished) {
                ThoiGian.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                pos++;
                if (pos >= list.size()) {
                    Intent callerIntent = getIntent();
                    Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                    String name = packageFromCaller.getString("name");
                    Intent intent = new Intent(englishquiz_test.this, englishquiz_result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("kq", kq);
                    bundle.putInt("num", pos);
                    bundle.putString("name", name);
                    intent.putExtra("package", bundle);
                    startActivity(intent);
                    finish();
                } else Display(pos);
            }
        }.start();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.englishquiz_test);

        CauHoi = (TextView) findViewById(R.id.Question);
        KetQua = (TextView) findViewById(R.id.Result);
        RG = (RadioGroup) findViewById(R.id.RadioGroup);
        A = (RadioButton) findViewById(R.id.RdbA);
        B = (RadioButton) findViewById(R.id.RdbB);
        C = (RadioButton) findViewById(R.id.RdbC);
        D = (RadioButton) findViewById(R.id.RdbD);
        TraLoi = (Button) findViewById(R.id.Answer);
        HinhAnh = (ImageView) findViewById(R.id.QuestionPicture);
        TroGiup = (Button) findViewById(R.id.Help);
        BoQua = (Button) findViewById(R.id.Skip);
        ThoiGian = (TextView) findViewById(R.id.Time);
        KetThuc = (Button) findViewById(R.id.End);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.buttonclick);

        AddQuestionFromFileTXT();
        CreateQuestion();
        Display(pos);

        KetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(englishquiz_test.this, englishquiz.class);
                startActivity(intent);
                finish();
            }
        });

        TroGiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                String temp = list.get(pos).Answer;
                switch (temp) {
                    case "A":
                        B.setVisibility(View.INVISIBLE);
                        D.setVisibility(View.INVISIBLE);
                        break;
                    case "B":
                        A.setVisibility(View.INVISIBLE);
                        C.setVisibility(View.INVISIBLE);
                        break;
                    case "C":
                        B.setVisibility(View.INVISIBLE);
                        D.setVisibility(View.INVISIBLE);
                        break;
                    case "D":
                        A.setVisibility(View.INVISIBLE);
                        C.setVisibility(View.INVISIBLE);
                        break;
                }
                TroGiup.setVisibility(View.INVISIBLE);
            }
        });

        BoQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Time.cancel();
                mediaPlayer.start();
                kq = kq + 1;
                pos++;
                Display(pos);
                BoQua.setVisibility(View.INVISIBLE);
            }
        });

        TraLoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Time.cancel();
                mediaPlayer.start();
                int idCheck = RG.getCheckedRadioButtonId();
                switch (idCheck) {
                    case R.id.RdbA:
                        if (list.get(pos).Answer.compareTo("A") == 0) kq = kq + 1;
                        break;
                    case R.id.RdbB:
                        if (list.get(pos).Answer.compareTo("B") == 0) kq = kq + 1;
                        break;
                    case R.id.RdbC:
                        if (list.get(pos).Answer.compareTo("C") == 0) kq = kq + 1;
                        break;
                    case R.id.RdbD:
                        if (list.get(pos).Answer.compareTo("D") == 0) kq = kq + 1;
                        break;
                }
                pos++;
                if (pos >= list.size()) {
                    Intent callerIntent = getIntent();
                    Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                    String name = packageFromCaller.getString("name");
                    Intent intent1 = new Intent(englishquiz_test.this, englishquiz_result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("kq", kq);
                    bundle.putInt("num", pos);
                    bundle.putString("name", name);
                    intent1.putExtra("package", bundle);
                    startActivity(intent1);
                    pos = 0;
                    kq = 0;
                    Display(pos);
                    finish();
                } else Display(pos);
            }
        });
    }

    void Display(int i) {
        countdown();
        int resID = getResources().getIdentifier(list.get(i).ID, "drawable", getPackageName());
        HinhAnh.setImageResource(resID);
        A.setText(list.get(i).AnswerA);
        B.setText(list.get(i).AnswerB);
        C.setText(list.get(i).AnswerC);
        D.setText(list.get(i).AnswerD);
        KetQua.setText("Câu đúng: " + kq);
        RG.clearCheck();
        A.setVisibility(View.VISIBLE);
        B.setVisibility(View.VISIBLE);
        C.setVisibility(View.VISIBLE);
        D.setVisibility(View.VISIBLE);
    }

    public void AddQuestionFromFileTXT() {
        try {
            String splitBy = ",";
            FileInputStream in = this.openFileInput("Question.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while (br != null) {
                String line = br.readLine();
                String[] value = line.split(splitBy);
                PList.add(new Question(value[1], Integer.parseInt(value[0])));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void CreateQuestion() {
        Intent callerIntent = getIntent();
        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
        int number = packageFromCaller.getInt("number");

        for (int i = 0; i <= number - 1; i++) {
            QuestionNare Q = new QuestionNare();
            Random generator = new Random();
            Q.AnswerA = PList.get(generator.nextInt(50)).getName();
            do {
                Q.AnswerB = PList.get(generator.nextInt(50)).getName();
            } while (Q.AnswerA == Q.AnswerB);

            do {
                Q.AnswerC = PList.get(generator.nextInt(50)).getName();
            } while (Q.AnswerC == Q.AnswerB || Q.AnswerC == Q.AnswerA);

            do {
                Q.AnswerD = PList.get(generator.nextInt(50)).getName();
            } while (Q.AnswerD == Q.AnswerC || Q.AnswerD == Q.AnswerB || Q.AnswerD == Q.AnswerA);

            int value = generator.nextInt(4);
            int find = 0;

            switch (value) {
                case 0:
                    find = PList.indexOf(searchQuestion(Q.AnswerA));
                    Q.Answer = "A";
                    break;
                case 1:
                    find = PList.indexOf(searchQuestion(Q.AnswerB));
                    Q.Answer = "B";
                    break;
                case 2:
                    find = PList.indexOf(searchQuestion(Q.AnswerC));
                    Q.Answer = "C";
                    break;
                case 3:
                    find = PList.indexOf(searchQuestion(Q.AnswerD));
                    Q.Answer = "D";
                    break;
            }
            Q.ID = "a" + PList.get(find).getId();
            list.add(Q);
        }
    }

    public Question searchQuestion(String code) {
        for (Question in : PList) {
            if (in.getName().equalsIgnoreCase(code)) {
                return in;
            }
        }
        return null;
    }
}