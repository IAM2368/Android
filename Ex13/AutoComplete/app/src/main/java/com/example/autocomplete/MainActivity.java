package com.example.autocomplete;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView selection;
    // Khai báo 2 CompleteTextView
    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComplete;

    // Khai tạo mảng tạm để Test
    String arr[] = {"hà nội", "Huế", "Sài gòn",
            "hà giang", "Bến an", "Kiên giang",
            "Lâm đồng", "Long khánh"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selection = (TextView) findViewById(R.id.selection);

        // lấy đối tượng AutoCompleteTextView ra
        singleComplete = (AutoCompleteTextView) findViewById(R.id.editauto);
        ArrayAdapter myadapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );

        // Thiết lập ArrayAdapter
        singleComplete.setAdapter(myadapter);

        // lấy đối tượng MultiAutoCompleteTextView ra
        multiComplete = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        // thiết lập Adapter
        multiComplete.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        ));

        // nói với MultiAutoCompleteTextView biết bắt buộc phải gọi dòng lệnh này
        multiComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        singleComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                selection.setText(singleComplete.getText());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}
