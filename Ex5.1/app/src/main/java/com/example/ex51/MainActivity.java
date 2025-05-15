package com.example.ex51;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText editNamDuong, editAmLich;
    Button btnDoi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNamDuong = findViewById(R.id.editNamDuong);
        editAmLich = findViewById(R.id.editAmLich);
        btnDoi = findViewById(R.id.button1);

        btnDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Bước 1: Lấy giá trị nhập từ EditText
                String namDuongStr = editNamDuong.getText().toString();
                if (namDuongStr.isEmpty()) {
                    editAmLich.setText("Vui lòng nhập năm");
                    return;
                }

                // Bước 2: Ép giá trị nhập vào về số nguyên
                int namDuong = Integer.parseInt(namDuongStr);

                // Bước 3: Tính năm âm lịch (Can Chi)
                String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
                String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

                String namAmLich = can[namDuong % 10] + " " + chi[namDuong % 12];

                // Hiển thị kết quả
                editAmLich.setText("Năm âm lịch: " + namAmLich);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate menu if cần
        return true;
    }
}
