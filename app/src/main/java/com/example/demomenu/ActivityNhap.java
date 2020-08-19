package com.example.demomenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ActivityNhap extends AppCompatActivity {
    private EditText editText_HoTen, editText_SDT, editText_DiaChi;
    private Button button_Luu;

    ArrayAdapter<String> adapter;
    ArrayList<ThongTinDanhBa> arrayList = new ArrayList<>();
    private ThongTinDanhBa thongTinDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap);

        AnhXa();
    }

    public void AnhXa() {
        editText_DiaChi = (EditText) findViewById(R.id.editText_DiaChi);
        editText_HoTen = (EditText) findViewById(R.id.editText_HoTen);
        editText_SDT = (EditText) findViewById(R.id.editText_SDT);
        button_Luu = (Button) findViewById(R.id.button_Luu);
        button_Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    LuuDuLieu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void LuuDuLieu() throws IOException {
        if (editText_SDT.getText().toString().equals("")) {
            Toast.makeText(this, "Vui long nhap du lieu", Toast.LENGTH_SHORT).show();
        } else if (editText_DiaChi.getText().toString().equals("")) {
            Toast.makeText(this, "Vui long nhap du lieu", Toast.LENGTH_SHORT).show();
        } else if (editText_HoTen.getText().toString().equals("")) {
            Toast.makeText(this, "Vui long nhap du lieu", Toast.LENGTH_SHORT).show();
        } else {
            String hoten = editText_HoTen.getText().toString();
            String diachi = editText_DiaChi.getText().toString();
            String sdt = editText_SDT.getText().toString();
            thongTinDanhBa = new ThongTinDanhBa(hoten, diachi, sdt);
            arrayList.add(thongTinDanhBa);

            String filename = "menunhapthongtin.txt";
            String data = "";
            data += thongTinDanhBa;

            FileOutputStream fileOutputStream = openFileOutput(filename, Context.MODE_APPEND);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();

            Toast.makeText(ActivityNhap.this, "Luu thanh cong", Toast.LENGTH_SHORT).show();
            editText_DiaChi.setText("");
            editText_HoTen.setText("");
            editText_SDT.setText("");
        }
    }
}
