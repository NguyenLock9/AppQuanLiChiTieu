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

public class ThongKeChi extends AppCompatActivity {
    AnyChartView anyChartViewChi;

    ArrayList<String> Chi;
    ArrayList<Integer> soTien;

    //Add Database vao Thong Ke
    MyDatabase database;
    List<GiaoDich> giaoDichList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_chi);
        database = new MyDatabase(this);
        giaoDichList = database.getAllDanhMucGiaoDich(this);
        anyChartViewChi = findViewById(R.id.anyChartViewChi);
        setUpChartViewChi();
    }

    private void setUpChartViewChi() {
        //Lấy dữ liệu thu chi ở SQLite thay vào thuChi, va So tien
        Chi = new ArrayList<>();
        soTien = new ArrayList<>();

        for (int i = 0; i < giaoDichList.size(); ++i) {
            if (giaoDichList.get(i).getIsKhoanThu() != 1) {
                Chi.add(giaoDichList.get(i).getCategory());
                soTien.add(giaoDichList.get(i).getAmount());
            }
        }

        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0; i < Chi.size(); ++i) {
            String x = Chi.get(i);
            int y = soTien.get(i);
            dataEntries.add(new ValueDataEntry(x, y));
        }
        pie.data(dataEntries);
        pie.title("Thống Kê Chi");
        anyChartViewChi.setChart(pie);
    }
}