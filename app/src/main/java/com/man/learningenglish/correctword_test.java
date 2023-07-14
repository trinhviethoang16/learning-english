package com.man.learningenglish;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

class QuestionNareC1 {
    public String ID;
    public String Q;
    public String Answer;

}

class QuestionNareC2 {
    public String ID;
    public String Q;
    public String Answer;
}

class QuestionNareC3 {
    public String ID;
    public String Q;
    public String Answer;

}

class QuestionNareC4 {
    public String ID;
    public String Q;

}

class QuestionNareC5 {
    public String ID;
    public String Q;

}

class QuestionNareC6 {
    public String ID;
    public String Q;
}

class QuestionNareC7 {
    public String ID;
    public String Q;

}

class QuestionNareC8 {
    public String ID;
    public String Q;

}

class QuestionNareC9 {
    public String ID;
    public String Q;

}

class QuestionNareC10 {
    public String ID;
    public String Q;

}

class QuestionNareC11 {
    public String ID;
    public String Q;

}

class QuestionNareC12 {
    public String ID;
    public String Q;

}

class QuestionNareC13 {
    public String ID;
    public String Q;

}

class QuestionNareC14 {
    public String ID;
    public String Q;

}

class QuestionNareC15 {
    public String ID;
    public String Q;

}

class QuestionNareC16 {
    public String ID;
    public String Q;

}

class QuestionNareC17 {
    public String ID;
    public String Q;

}

class QuestionNareC18 {
    public String ID;
    public String Q;

}

class QuestionNareC19 {
    public String ID;
    public String Q;

}

class QuestionNareC20 {
    public String ID;
    public String Q;

}

public class correctword_test extends Activity {
    TextView CauHoi, Diem, ThoiGian, Star, Tilte;
    Button TroVe, KiemTra;
    EditText TraLoi;
    int star = 0;
    int count = 0;
    int pos = 0;
    int kq = 0;
    int scd = 10;
    int qc = 0, qc1 = 0, qc2 = 0, qc3 = 0, qc4 = 0, qc5 = 0, qc6 = 0, qc7 = 0, qc8 = 0, qc9 = 0, qc10 = 0, qc11 = 0, qc12 = 0, qc13 = 0, qc14 = 0, qc15 = 0, qc16 = 0, qc17 = 0, qc18 = 0, qc19 = 0, qc20 = 0;
    int gh = 3;
    int[] integers = new int[21];
    int[] integers1 = new int[20];
    CountDownTimer ThoiGianC;
    ArrayList<QuestionNareC1> L1 = new ArrayList();
    ArrayList<QuestionNareC2> L2 = new ArrayList();
    ArrayList<QuestionNareC3> L3 = new ArrayList();
    ArrayList<QuestionNareC4> L4 = new ArrayList();
    ArrayList<QuestionNareC5> L5 = new ArrayList();
    ArrayList<QuestionNareC6> L6 = new ArrayList();
    ArrayList<QuestionNareC7> L7 = new ArrayList();
    ArrayList<QuestionNareC8> L8 = new ArrayList();
    ArrayList<QuestionNareC9> L9 = new ArrayList();
    ArrayList<QuestionNareC10> L10 = new ArrayList();
    ArrayList<QuestionNareC11> L11 = new ArrayList();
    ArrayList<QuestionNareC12> L12 = new ArrayList();
    ArrayList<QuestionNareC13> L13 = new ArrayList();
    ArrayList<QuestionNareC14> L14 = new ArrayList();
    ArrayList<QuestionNareC15> L15 = new ArrayList();
    ArrayList<QuestionNareC16> L16 = new ArrayList();
    ArrayList<QuestionNareC17> L17 = new ArrayList();
    ArrayList<QuestionNareC18> L18 = new ArrayList();
    ArrayList<QuestionNareC19> L19 = new ArrayList();
    ArrayList<QuestionNareC20> L20 = new ArrayList();

    public void countdown() {
        ThoiGianC = new CountDownTimer(31000, 1000) {

            public void onTick(long millisUntilFinished) {
                ThoiGian.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                scd--;
                gh--;
                if (scd < 1) {
                    scd = 1;
                }
                if (gh == 0 && star > 0) {
                    star--;
                    gh = 3;
                } else if (gh == 0 && star == 0) {
                    Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                    startActivity(intent);
                    finish();
                }
                if (qc >= 10) {
                    Intent callerIntent = getIntent();
                    Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                    String name = packageFromCaller.getString("name");
                    Intent intent = new Intent(correctword_test.this, correctword_result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("KQ", kq);
                    bundle.putInt("num", qc);
                    bundle.putInt("star", star);
                    bundle.putString("name", name);
                    intent.putExtra("package", bundle);
                    startActivity(intent);
                    finish();
                } else if (scd <= 1) {
                    DisplayQ1(pos);
                } else if (scd == 2) {
                    DisplayQ2(pos);
                } else if (scd == 3) {
                    DisplayQ3(pos);
                } else if (scd == 4) {
                    DisplayQ4(pos);
                } else if (scd == 5) {
                    DisplayQ5(pos);
                } else if (scd == 6) {
                    DisplayQ6(pos);
                } else if (scd == 7) {
                    DisplayQ7(pos);
                } else if (scd == 8) {
                    DisplayQ8(pos);
                } else if (scd == 9) {
                    DisplayQ9(pos);
                } else if (scd == 10) {
                    DisplayQ10(pos);
                } else if (scd == 11) {
                    DisplayQ11(pos);
                } else if (scd == 12) {
                    DisplayQ12(pos);
                } else if (scd == 13) {
                    DisplayQ13(pos);
                } else if (scd == 14) {
                    DisplayQ14(pos);
                } else if (scd == 15) {
                    DisplayQ15(pos);
                } else if (scd == 16) {
                    DisplayQ16(pos);
                } else if (scd == 17) {
                    DisplayQ17(pos);
                } else if (scd == 18) {
                    DisplayQ18(pos);
                } else if (scd == 19) {
                    DisplayQ19(pos);
                } else if (scd >= 20) {
                    DisplayQ20(pos);
                }
            }
        }.start();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correctword_test);

        CauHoi = (TextView) findViewById(R.id.Question);
        Diem = (TextView) findViewById(R.id.CorrectAnswer);
        ThoiGian = (TextView) findViewById(R.id.Time);
        Tilte = (TextView) findViewById(R.id.Title);
        TroVe = (Button) findViewById(R.id.Back);
        KiemTra = (Button) findViewById(R.id.Answer);
        TraLoi = (EditText) findViewById(R.id.YourAnswer);
        Star = (TextView) findViewById(R.id.Star);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.buttonclick);
        countdown();
        random();
        ReadDatac1();
        ReadDatac2();
        ReadDatac3();
        ReadDatac4();
        ReadDatac5();
        ReadDatac6();
        ReadDatac7();
        ReadDatac8();
        ReadDatac9();
        ReadDatac10();
        ReadDatac11();
        ReadDatac12();
        ReadDatac13();
        ReadDatac14();
        ReadDatac15();
        ReadDatac16();
        ReadDatac17();
        ReadDatac18();
        ReadDatac19();
        ReadDatac20();
        DisplayQ10(pos);

        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent = new Intent(correctword_test.this, correctword.class);
                startActivity(intent);
                finish();
            }
        });

        KiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThoiGianC.cancel();
                if (scd <= 1) {
                    pos = integers[qc1];
                    if (L1.get(pos).Answer.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        scd--;
                        if (scd < 1) {
                            scd = 1;
                        }
                        count = 0;
                        gh--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc1++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd <= 1) {
                        DisplayQ1(pos);
                    } else if (scd == 2) {
                        DisplayQ2(pos);
                    }
                } else if (scd == 2) {
                    pos = integers[qc2];
                    if (L2.get(pos).Answer.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc2++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 1) {
                        DisplayQ1(pos);
                    } else if (scd == 2) {
                        DisplayQ2(pos);
                    } else if (scd == 3) {
                        DisplayQ3(pos);
                    }
                } else if (scd == 3) {
                    pos = integers[qc3];
                    if (L3.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc3++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 2) {
                        DisplayQ2(pos);
                    } else if (scd == 3) {
                        DisplayQ3(pos);
                    } else if (scd == 4) {
                        DisplayQ4(pos);
                    }
                } else if (scd == 4) {
                    pos = integers[qc4];
                    if (L4.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc4++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 3) {
                        DisplayQ3(pos);
                    } else if (scd == 4) {
                        DisplayQ4(pos);
                    } else if (scd == 5) {
                        DisplayQ5(pos);
                    }
                } else if (scd == 5) {
                    pos = integers[qc5];
                    if (L5.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc5++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 4) {
                        DisplayQ4(pos);
                    } else if (scd == 5) {
                        DisplayQ5(pos);
                    } else if (scd == 6) {
                        DisplayQ6(pos);
                    }
                } else if (scd == 6) {
                    pos = integers[qc6];
                    if (L6.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc6++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 5) {
                        DisplayQ5(pos);
                    } else if (scd == 6) {
                        DisplayQ6(pos);
                    } else if (scd == 7) {
                        DisplayQ7(pos);
                    }
                } else if (scd == 7) {
                    pos = integers[qc7];
                    if (L7.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc7++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 6) {
                        DisplayQ6(pos);
                    } else if (scd == 7) {
                        DisplayQ7(pos);
                    } else if (scd == 8) {
                        DisplayQ8(pos);
                    }
                } else if (scd == 8) {
                    pos = integers[qc8];
                    if (L8.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc8++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 7) {
                        DisplayQ7(pos);
                    } else if (scd == 8) {
                        DisplayQ8(pos);
                    } else if (scd == 9) {
                        DisplayQ9(pos);
                    }
                } else if (scd == 9) {
                    pos = integers[qc9];
                    if (L9.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc9++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 8) {
                        DisplayQ8(pos);
                    } else if (scd == 9) {
                        DisplayQ9(pos);
                    } else if (scd == 10) {
                        DisplayQ10(pos);
                    }
                } else if (scd == 10) {
                    pos = integers[qc10];
                    if (L10.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc10++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 9) {
                        DisplayQ9(pos);
                    } else if (scd == 10) {
                        DisplayQ10(pos);
                    } else if (scd == 11) {
                        DisplayQ11(pos);
                    }
                } else if (scd == 11) {
                    pos = integers[qc11];
                    if (L11.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc11++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 10) {
                        DisplayQ10(pos);
                    } else if (scd == 11) {
                        DisplayQ11(pos);
                    } else if (scd == 12) {
                        DisplayQ12(pos);
                    }
                } else if (scd == 12) {
                    pos = integers[qc12];
                    if (L12.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc12++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 11) {
                        DisplayQ11(pos);
                    } else if (scd == 12) {
                        DisplayQ12(pos);
                    } else if (scd == 13) {
                        DisplayQ13(pos);
                    }
                } else if (scd == 13) {
                    pos = integers[qc13];
                    if (L13.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc13++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 12) {
                        DisplayQ12(pos);
                    } else if (scd == 13) {
                        DisplayQ13(pos);
                    } else if (scd == 14) {
                        DisplayQ14(pos);
                    }
                } else if (scd == 14) {
                    pos = integers[qc14];
                    if (L14.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc14++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 13) {
                        DisplayQ13(pos);
                    } else if (scd == 14) {
                        DisplayQ14(pos);
                    } else if (scd == 15) {
                        DisplayQ15(pos);
                    }
                } else if (scd == 15) {
                    pos = integers[qc15];
                    if (L15.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc15++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 14) {
                        DisplayQ14(pos);
                    } else if (scd == 15) {
                        DisplayQ15(pos);
                    } else if (scd == 16) {
                        DisplayQ16(pos);
                    }
                } else if (scd == 16) {
                    pos = integers[qc16];
                    if (L16.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc16++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 15) {
                        DisplayQ15(pos);
                    } else if (scd == 16) {
                        DisplayQ16(pos);
                    } else if (scd == 17) {
                        DisplayQ17(pos);
                    }
                } else if (scd == 17) {
                    pos = integers[qc17];
                    if (L17.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc17++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 16) {
                        DisplayQ16(pos);
                    } else if (scd == 17) {
                        DisplayQ17(pos);
                    } else if (scd == 18) {
                        DisplayQ18(pos);
                    }
                } else if (scd == 18) {
                    pos = integers[qc18];
                    if (L18.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc18++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 17) {
                        DisplayQ17(pos);
                    } else if (scd == 18) {
                        DisplayQ18(pos);
                    } else if (scd == 19) {
                        DisplayQ19(pos);
                    }
                } else if (scd == 19) {
                    pos = integers[qc19];
                    if (L19.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc19++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 18) {
                        DisplayQ18(pos);
                    } else if (scd == 19) {
                        DisplayQ19(pos);
                    } else if (scd == 20) {
                        DisplayQ20(pos);
                    }
                } else if (scd == 20) {
                    pos = integers[qc20];
                    if (L20.get(pos).Q.compareTo(TraLoi.getText().toString().trim()) == 0) {
                        kq = kq + 1;
                        count++;
                        gh = 3;
                        scd++;
                        if (count == 3) {
                            star++;
                            Star.setText("" + star);
                            count = 0;
                        }
                    } else {
                        count = 0;
                        gh--;
                        scd--;
                    }
                    if (gh < 1 && star > 0) {
                        star--;
                        gh = 3;
                    } else if (gh < 1 && star == 0) {
                        Intent intent = new Intent(correctword_test.this, correctword_thongbao.class);
                        startActivity(intent);
                        finish();
                    }
                    qc++;
                    qc20++;
                    if (qc >= 10) {
                        Intent callerIntent = getIntent();
                        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
                        String name = packageFromCaller.getString("name");
                        Intent intent = new Intent(correctword_test.this, correctword_result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KQ", kq);
                        bundle.putInt("num", qc);
                        bundle.putInt("star", star);
                        bundle.putString("name", name);
                        intent.putExtra("package", bundle);
                        startActivity(intent);
                        finish();
                    } else if (scd == 19) {
                        DisplayQ19(pos);
                    } else if (scd == 20) {
                        DisplayQ20(pos);
                    }
                }
            }
        });
    }

    void DisplayQ1(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc1];
        countdown();
        CauHoi.setText(L1.get(pos).Q);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();
        Star.setText("" + star);
    }

    void DisplayQ2(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc2];
        countdown();
        CauHoi.setText(L2.get(pos).Q);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();
        Star.setText("" + star);
    }

    void DisplayQ3(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc3];
        countdown();
        String chuoitam = "";
        chuoitam = L3.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();
    }

    void DisplayQ4(int pos) {

        ThoiGianC.cancel();
        pos = integers[qc4];
        countdown();
        String chuoitam = "";
        chuoitam = L4.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ5(int pos) {

        ThoiGianC.cancel();
        pos = integers[qc5];
        countdown();
        String chuoitam = "";
        chuoitam = L5.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ6(int pos) {

        ThoiGianC.cancel();
        pos = integers[qc6];
        countdown();
        String chuoitam = "";
        chuoitam = L6.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ7(int pos) {

        ThoiGianC.cancel();
        pos = integers[qc7];
        countdown();
        String chuoitam = "";
        chuoitam = L7.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ8(int pos) {

        ThoiGianC.cancel();
        pos = integers[qc8];
        countdown();
        String chuoitam = "";
        chuoitam = L8.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ9(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc9];
        countdown();
        String chuoitam = "";
        chuoitam = L9.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();
    }

    void DisplayQ10(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc10];
        countdown();
        String chuoitam = "";
        chuoitam = L10.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ11(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc11];
        countdown();
        String chuoitam = "";
        chuoitam = L11.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ12(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc12];
        countdown();
        String chuoitam = "";
        chuoitam = L12.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ13(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc13];
        countdown();
        String chuoitam = "";
        chuoitam = L13.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ14(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc14];
        countdown();
        String chuoitam = "";
        chuoitam = L14.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ15(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc15];
        countdown();
        String chuoitam = "";
        chuoitam = L15.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ16(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc16];
        countdown();
        String chuoitam = "";
        chuoitam = L16.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ17(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc17];
        countdown();
        String chuoitam = "";
        chuoitam = L17.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ18(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc18];
        countdown();
        String chuoitam = "";
        chuoitam = L18.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ19(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc19];
        countdown();
        String chuoitam = "";
        chuoitam = L19.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }

    void DisplayQ20(int pos) {
        ThoiGianC.cancel();
        pos = integers[qc20];
        countdown();
        String chuoitam = "";
        chuoitam = L20.get(pos).Q;
        String chuoi = "";
        char[] chuoich = chuoitam.toCharArray();
        random1(chuoich.length);
        for (int i = 0; i <= chuoich.length - 1; i++) {
            chuoi += chuoich[integers1[i]] + "/";
        }
        Star.setText("" + star);
        CauHoi.setText(chuoi);
        Diem.setText("Câu đúng: " + kq);
        TraLoi.getText().clear();

    }


    public void random() {
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            integers[i] = r.nextInt(5);
            for (int j = 0; j < i; j++) {
                if (integers[i] == integers[j]) {
                    i--;
                }
            }
        }
    }

    public void random1(int N) {
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            integers1[i] = r.nextInt(N);
            for (int j = 0; j < i; j++) {
                if (integers1[i] == integers1[j]) {
                    i--;
                }
            }
        }
    }

    void ReadDatac1() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac1.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Answer");
                    String Answer = listChild.item(0).getTextContent();
                    QuestionNareC1 Q1 = new QuestionNareC1();
                    Q1.ID = ID;
                    Q1.Q = Question;
                    Q1.Answer = Answer;
                    L1.add(Q1);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac2() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac2.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Answer");
                    String Answer = listChild.item(0).getTextContent();
                    QuestionNareC2 Q2 = new QuestionNareC2();
                    Q2.ID = ID;
                    Q2.Q = Question;
                    Q2.Answer = Answer;
                    L2.add(Q2);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac3() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac3.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Answer");
                    String Answer = listChild.item(0).getTextContent();
                    QuestionNareC3 Q3 = new QuestionNareC3();
                    Q3.ID = ID;
                    Q3.Q = Question;
                    Q3.Answer = Answer;
                    L3.add(Q3);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac4() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac4.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC4 Q4 = new QuestionNareC4();
                    Q4.ID = ID;
                    Q4.Q = Question;
                    L4.add(Q4);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac5() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac5.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC5 Q5 = new QuestionNareC5();
                    Q5.ID = ID;
                    Q5.Q = Question;
                    L5.add(Q5);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac6() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac6.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC6 Q6 = new QuestionNareC6();
                    Q6.ID = ID;
                    Q6.Q = Question;
                    L6.add(Q6);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac7() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac7.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC7 Q7 = new QuestionNareC7();
                    Q7.ID = ID;
                    Q7.Q = Question;
                    L7.add(Q7);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac8() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac8.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC8 Q8 = new QuestionNareC8();
                    Q8.ID = ID;
                    Q8.Q = Question;
                    L8.add(Q8);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac9() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac9.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC9 Q9 = new QuestionNareC9();
                    Q9.ID = ID;
                    Q9.Q = Question;
                    L9.add(Q9);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac10() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac10.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC10 Q10 = new QuestionNareC10();
                    Q10.ID = ID;
                    Q10.Q = Question;
                    L10.add(Q10);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac11() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac11.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC11 Q11 = new QuestionNareC11();
                    Q11.ID = ID;
                    Q11.Q = Question;
                    L11.add(Q11);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac12() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac12.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC12 Q12 = new QuestionNareC12();
                    Q12.ID = ID;
                    Q12.Q = Question;
                    L12.add(Q12);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac13() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac13.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC13 Q13 = new QuestionNareC13();
                    Q13.ID = ID;
                    Q13.Q = Question;
                    L13.add(Q13);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac14() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac14.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC14 Q14 = new QuestionNareC14();
                    Q14.ID = ID;
                    Q14.Q = Question;
                    L14.add(Q14);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac15() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac15.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC15 Q15 = new QuestionNareC15();
                    Q15.ID = ID;
                    Q15.Q = Question;
                    L15.add(Q15);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac16() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac16.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC16 Q16 = new QuestionNareC16();
                    Q16.ID = ID;
                    Q16.Q = Question;
                    L16.add(Q16);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac17() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac17.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC17 Q17 = new QuestionNareC17();
                    Q17.ID = ID;
                    Q17.Q = Question;
                    L17.add(Q17);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac18() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac18.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC18 Q18 = new QuestionNareC18();
                    Q18.ID = ID;
                    Q18.Q = Question;
                    L18.add(Q18);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac19() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac19.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC19 Q19 = new QuestionNareC19();
                    Q19.ID = ID;
                    Q19.Q = Question;
                    L19.add(Q19);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ReadDatac20() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
            InputStream in = getAssets().open("datac20.xml");
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element Item = (Element) node;
                    NodeList listChild = Item.getElementsByTagName("ID");
                    String ID = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Question");
                    String Question = listChild.item(0).getTextContent();
                    QuestionNareC20 Q20 = new QuestionNareC20();
                    Q20.ID = ID;
                    Q20.Q = Question;
                    L20.add(Q20);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


