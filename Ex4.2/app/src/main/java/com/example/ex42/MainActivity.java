package com.example.ex42;

import java.text.DecimalFormat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    Button btnChandoan;
    EditText editTen, editChieucao, editCannang, editBMI, editChandoan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChandoan = findViewById(R.id.btnBMI);
        editTen = findViewById(R.id.editten);
        editChieucao = findViewById(R.id.editchieucao);
        editCannang = findViewById(R.id.editcannang);
        editBMI = findViewById(R.id.editBMI);
        editChandoan = findViewById(R.id.editChuanDoan);

        btnChandoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double H = Double.parseDouble(editChieucao.getText().toString());
                    double W = Double.parseDouble(editCannang.getText().toString());

                    // Nếu chiều cao nhập theo cm thì chuyển sang mét
                    if (H > 3) {
                        H = H / 100;
                    }

                    double BMI = W / Math.pow(H, 2);
                    String chandoan = "";

                    if (BMI < 18) {
                        chandoan = "Bạn gầy";
                    } else if (BMI <= 24.9) {
                        chandoan = "Bạn bình thường";
                    } else if (BMI <= 29.9) {
                        chandoan = "Bạn béo phì độ 1";
                    } else if (BMI <= 34.9) {
                        chandoan = "Bạn béo phì độ 2";
                    } else {
                        chandoan = "Bạn béo phì độ 3";
                    }

                    DecimalFormat dcf = new DecimalFormat("#.0");
                    editBMI.setText(dcf.format(BMI));
                    editChandoan.setText(chandoan);
                } catch (NumberFormatException e) {
                    editBMI.setText("Lỗi");
                    editChandoan.setText("Vui lòng nhập đầy đủ thông tin");
                }
            }
        });
    }
}
