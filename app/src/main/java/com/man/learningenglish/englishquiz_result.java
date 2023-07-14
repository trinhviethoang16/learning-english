package com.man.learningenglish;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FileUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class englishquiz_result extends Activity {
    Button PlayAgain, TroVe;
    TextView Result;
    ArrayList<nguoichoi> list = new ArrayList<nguoichoi>();
    int sodiem, socau;
    private PieChart PieChart;
    String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.englishquiz_result);
        Result = (TextView)findViewById(R.id.KetQua);
        PlayAgain = (Button)findViewById(R.id.PlayAgain);
        TroVe = (Button)findViewById(R.id.Back);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.buttonclick);
        final MediaPlayer music = MediaPlayer.create(this,R.raw.winning);
        music.start();
        Intent callerIntent=getIntent();
        Bundle packageFromCaller= callerIntent.getBundleExtra("package");
        name = packageFromCaller.getString("name");
        sodiem = packageFromCaller.getInt("kq");
        socau = packageFromCaller.getInt("num");
        readFromFile();

        Result.setText("Số câu trả lời: " + sodiem + "/" + socau);
        PieChart = findViewById(R.id.PieChart);
        setupPieChart();
        loadPieChartData();
        kiemtra();

        TroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent = new Intent(englishquiz_result.this, englishquiz.class);
                startActivity(intent);
                finish();
            }
        });

        PlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Intent intent1 = new Intent(englishquiz_result.this, playername.class);
                startActivity(intent1);
                finish();
            }
        });
    }

    public void saveToFile(ArrayList<nguoichoi> list)
    {
        try
        {
            FileOutputStream outputStream = this.openFileOutput("nguoichoi.csv", Context.MODE_PRIVATE);
            PrintWriter pw = new PrintWriter(outputStream);
            for (nguoichoi in:list)
                pw.println(in);
            pw.close();
            outputStream.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void readFromFile() {
        try{
            String splitBy = ",";
            FileInputStream in = this.openFileInput("nguoichoi.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while (br != null) {
                String line = br.readLine();
                String[] value = line.split(splitBy);
                list.add(new nguoichoi(value[0], Integer.parseInt(value[1])));
            }
            br.close();
        }
        catch (Exception e){
            System.out.println(""+e.getMessage());
        }
    }

    private void kiemtra() {
        nguoichoi temp = searchnguoichoi(name);
        if(temp == null) {
            nguoichoi a=new nguoichoi(name,sodiem);
            list.add(a);
            saveToFile(list);
        }
        else{
            if(temp.getDiem()<sodiem){
                temp.setdiem(sodiem);
                saveToFile(list);
            }
        }
    }

    protected nguoichoi searchnguoichoi(String code)
    {
        for (nguoichoi in:list)
        {
            if (in.getName().equalsIgnoreCase(code))
            {
                return in;
            }
        }
        return null;
    }

    private void setupPieChart() {
        PieChart.setDrawHoleEnabled(true);
        PieChart.setUsePercentValues(true);
        PieChart.setEntryLabelTextSize(12);
        PieChart.setEntryLabelColor(Color.BLACK);
        PieChart.setCenterText("Tổng số câu");
        PieChart.setCenterTextSize(24);
        PieChart.getDescription().setEnabled(false);

        Legend l = PieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }

    private void loadPieChartData() {
        ArrayList<PieEntry> entries = new ArrayList<>();

        float temp = (float) sodiem/socau;
        entries.add(new PieEntry(temp,"Số câu đúng"));
        entries.add(new PieEntry(1.0f-temp,"Số câu sai"));

        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }

        for (int color: ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color);
        }

        PieDataSet dataSet = new PieDataSet(entries, "Chú thích");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(PieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        PieChart.setData(data);
        PieChart.invalidate();

        PieChart.animateY(1400, Easing.EaseInOutQuad);
    }
}

