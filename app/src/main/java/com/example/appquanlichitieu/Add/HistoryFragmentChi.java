package com.example.appquanlichitieu.Add;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.appquanlichitieu.GiaoDich;
import com.example.appquanlichitieu.GiaoDichAdapterChi;
import com.example.appquanlichitieu.MyDatabase;
import com.example.appquanlichitieu.R;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragmentChi extends Fragment {
    ListView ListViewGiaoDich;
    MyDatabase database;

    GiaoDichAdapterChi giaoDichAdapter;
    List<GiaoDich> giaoDichList;

    public HistoryFragmentChi() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_history, container, false);
        ListViewGiaoDich = v.findViewById(R.id.ListViewGiaoDich);
        database = new MyDatabase(getActivity());
        giaoDichList = database.getAllDanhMucGiaoDichChi(getContext());
        giaoDichAdapter = new GiaoDichAdapterChi(getContext(), (ArrayList<GiaoDich>) giaoDichList);
        ListViewGiaoDich.setAdapter(giaoDichAdapter);
        ListViewGiaoDich.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy thông tin của item đã chọn
                GiaoDich selectedGiaoDich = giaoDichList.get(position);
                // Hiển thị dialog để cho người dùng sửa thông tin
                showEditDialog(selectedGiaoDich);
            }
        });
        ListViewGiaoDich.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy thông tin của item đã chọn
                GiaoDich selectedGiaoDich = giaoDichList.get(position);
                // Hiển thị dialog xác nhận xóa
                showDeleteConfirmationDialog(selectedGiaoDich);
                return true;
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Cập nhật lại danh sách giao dịch
        giaoDichList.clear();
        giaoDichList.addAll(database.getAllDanhMucGiaoDichChi(getContext()));
        giaoDichAdapter.notifyDataSetChanged();
    }
    private void showEditDialog(GiaoDich giaoDich) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_edit_giaodich, null);
        builder.setView(dialogView);
        // Ánh xạ các view trong dialog
        EditText editLoaiDanhMuc = dialogView.findViewById(R.id.editTenGiaoDich);
        EditText editSoTien = dialogView.findViewById(R.id.editSoTien);
        EditText editghichu= dialogView.findViewById(R.id.editghichu);
        // Thiết lập giá trị mặc định cho các EditText
        editLoaiDanhMuc.setText(giaoDich.getCategory());
        editSoTien.setText(String.valueOf(giaoDich.getAmount()));
        editghichu.setText(giaoDich.getGhiChu());
        // Thiết lập các nút trong dialog
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Lấy giá trị mới từ các EditText
                String tenGiaoDich = editLoaiDanhMuc.getText().toString();
                int soTien = Integer.parseInt(editSoTien.getText().toString());
                String ghichu = editghichu.getText().toString();

                // Cập nhật dữ liệu trong database
                giaoDich.setCategory(tenGiaoDich);
                giaoDich.setAmount(soTien);
                giaoDich.setGhiChu(ghichu);
                database.updateGiaoDich(giaoDich);
            }
        });
        builder.setNegativeButton("Cancel", null);
        // Hiển thị dialog
        builder.create().show();
    }

    private void showDeleteConfirmationDialog(GiaoDich giaoDich) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Xóa");
        builder.setMessage("Bạn có chắc chắn muốn xóa không?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.deleteGiaoDich(giaoDich);
                giaoDichList.remove(giaoDich);
                giaoDichAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", null);
        // Hiển thị dialog xác nhận xóa
        builder.create().show();
    }
}



