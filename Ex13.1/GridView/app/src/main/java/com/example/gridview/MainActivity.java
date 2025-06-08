package com.example.gridview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.BreakIterator;

public class MainActivity extends Activity {
    String arr[]={"Ipad","Iphone","New Ipad", "SamSung","Nokia","Sony Ericson",
    "LG","Q-Mobile","HTC","Blackberry", "G Phone","FPT - Phone","HK Phone"
    };
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.selection);
        final GridView gv = (GridView) findViewById(R.id.gridView1);

        ArrayAdapter<String> da = new ArrayAdapter<String>
                (
                        this, android.R.layout.simple_list_item_1, arr
                );

        gv.setAdapter(da);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                BreakIterator selection = null;
                selection.setText(arr[arg2]);
            }
        });
    }}