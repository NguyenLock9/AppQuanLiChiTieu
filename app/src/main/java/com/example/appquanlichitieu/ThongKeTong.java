package com.example.appquanlichitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class ThongKeTong extends AppCompatActivity {

    AnyChartView anyChartViewTong;

    String[] thuChi;
    int soTienThu = 0;
    int soTienChi = 0;
    int[] tiLe;


    //Add Database vao Thong Ke
    MyDatabase database;
    List<GiaoDich> giaoDichList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_tong);
        database = new MyDatabase(this);
        giaoDichList = database.getAllDanhMucGiaoDich(this);

        anyChartViewTong = findViewById(R.id.anyChartViewTong);
        setUpChartViewTong();
    }

    private void setUpChartViewTong() {
        //Lấy dữ liệu thu chi ở SQLite thay vào thuChi hai số 4500, 3000 bên dưới là được
        thuChi = new String[]{"Số tiền thu", "Số tiền chi"};

        //Tinh Tong so tien thu, va Tong so tien Chi
        for(int i = 0; i < giaoDichList.size(); ++i){
            if(giaoDichList.get(i).getIsKhoanThu() == 1){
                soTienThu += giaoDichList.get(i).getAmount();
            }
            else{
                soTienChi += giaoDichList.get(i).getAmount();
            }
        }
        tiLe = new int[]{soTienThu, soTienChi};

        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for(int i = 0; i < thuChi.length; ++i){
            dataEntries.add(new ValueDataEntry(thuChi[i], tiLe[i]));
        }
        pie.data(dataEntries);
        pie.title("Thống Kê Tổng");
        anyChartViewTong.setChart(pie);
    }

    public int getSoTienThu() {
        return soTienThu;
    }


}