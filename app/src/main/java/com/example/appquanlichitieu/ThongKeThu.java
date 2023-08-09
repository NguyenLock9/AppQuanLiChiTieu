package com.example.appquanlichitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class ThongKeThu extends AppCompatActivity {
    AnyChartView anyChartViewThu;


    ArrayList<String> Thu;
    ArrayList<Integer> soTien;

    //Add Database vao Thong Ke
    MyDatabase database;
    List<GiaoDich> giaoDichList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_thu);
        database = new MyDatabase(this);
        giaoDichList = database.getAllDanhMucGiaoDich(this);
        anyChartViewThu = findViewById(R.id.anyChartViewThu);
        setUpChartViewThu();
    }

    private void setUpChartViewThu() {
        //Lấy dữ liệu thu chi ở SQLite thay vào thuChi, soTien
        Thu = new ArrayList<>();
        soTien = new ArrayList<>();

        for (int i = 0; i < giaoDichList.size(); ++i) {
            if (giaoDichList.get(i).getIsKhoanThu() == 1) {
                Thu.add(giaoDichList.get(i).getCategory());
                soTien.add(giaoDichList.get(i).getAmount());
            }
            Toast.makeText(this, "giaoDichThu: " + giaoDichList.get(i).getIsKhoanThu(), Toast.LENGTH_SHORT).show();
        }
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0; i < Thu.size(); ++i) {
            String x = Thu.get(i);
            int y = soTien.get(i);
            dataEntries.add(new ValueDataEntry(x, y));
        }
        pie.data(dataEntries);
        pie.title("Thống Kê Thu");
        anyChartViewThu.setChart(pie);

    }
}