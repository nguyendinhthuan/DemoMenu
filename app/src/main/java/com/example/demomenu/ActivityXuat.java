package com.example.demomenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ActivityXuat extends AppCompatActivity {
    private Button button_Xuat;
    private ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuat);

        AnhXa();
        try {
            XuatDuLieu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AnhXa() {
        button_Xuat = (Button) findViewById(R.id.button_Xuat);
        listView = (ListView) findViewById(R.id.listView);
    }

    public void XuatDuLieu() throws IOException {
        button_Xuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = "menunhapthongtin.txt";
                String data = "";
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = openFileInput(filename);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                arrayList = new ArrayList<>();
                while (true) {
                    try {
                        if (!((data = bufferedReader.readLine()) != null)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    arrayList.add(data);
                }
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                adapter = new ArrayAdapter<String>(ActivityXuat.this, android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(adapter);
            }
        });
    }
}
