package com.example.appquanlichitieu.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.anychart.AnyChartView;
import com.example.appquanlichitieu.R;
import com.example.appquanlichitieu.ThongKeChi;
import com.example.appquanlichitieu.ThongKeThu;
import com.example.appquanlichitieu.ThongKeTong;

public class ChartFragment extends Fragment {
    AnyChartView anyChartView, anyChartViewThu, anyChartViewChi;
    Button btnTong,btnThu,btnChi;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        btnTong = view.findViewById(R.id.btnTong);
        btnChi = view.findViewById(R.id.btnChi);
        btnThu = view.findViewById(R.id.btnThu);

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ThongKeTong.class);
                startActivity(intent);
            }
        });
        btnChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ThongKeChi.class);
                startActivity(intent);
            }
        });
        btnThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ThongKeThu.class);
                startActivity(intent);
            }
        });


        return view;
    }
}