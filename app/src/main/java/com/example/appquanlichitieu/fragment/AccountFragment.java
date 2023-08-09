package com.example.appquanlichitieu.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appquanlichitieu.HoidapActivity;
import com.example.appquanlichitieu.PhienbanActivity;
import com.example.appquanlichitieu.R;
import com.example.appquanlichitieu.ThongtintaikhoanActivity;

public class AccountFragment extends Fragment {

    TextView txtVHoidap, txtVPhienban;
    LinearLayout layoutLogin;
//    Button btnLogoutAcc;


    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        txtVHoidap = view.findViewById(R.id.txtVHoidap);
        txtVPhienban = view.findViewById(R.id.txtVPhienban);
        layoutLogin = view.findViewById(R.id.layoutLogin);

        txtVHoidap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HoidapActivity.class);
                startActivity(intent);
            }
        });
        layoutLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThongtintaikhoanActivity.class);
                startActivity(intent);
            }
        });
        txtVPhienban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PhienbanActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}