package com.lacviet.vebrary5.Search;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.lacviet.vebrary5.Adapter.ResultRCVAdapter;
import com.lacviet.vebrary5.Model.ResultItemModel;
import com.lacviet.vebrary5.R;

import java.util.ArrayList;

public class SearchOpacAdvanceActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TextView tvTitleToolbar, tvSearch;
    //
    Spinner spinnerCategory;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opac_advance_search);
        addControl();
        actionBar();
        dropDownSpinnerCategory();

    }
    private void dropDownSpinnerCategory() {
        spinnerCategory = findViewById(R.id.spinnerCategory);

        String[] items = new String[]{"Bất kỳ", "Tên hiện vật", "Tên khác",
                "Số kiểm kê", "Số lượng", "Thành phần", "Niên đại"};
        final String[] arrCategory = new String[]{"ANY", "EXHIBITNAME", "OTHERNAME",
                "CODEID", "NUMBER", "ELEMENT", "AGES"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (parent.getChildAt(0) != null) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                    ((TextView) parent.getChildAt(0)).setTextSize(13);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
    private void actionBar() {
        setSupportActionBar(toolbar);
        tvTitleToolbar.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        tvSearch = findViewById(R.id.tvSearch);
    }
}