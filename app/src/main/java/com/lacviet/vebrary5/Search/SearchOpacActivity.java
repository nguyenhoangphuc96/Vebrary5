package com.lacviet.vebrary5.Search;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.lacviet.vebrary5.R;

import java.util.ArrayList;

public class SearchOpacActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TextView tvTitleToolbar, tvSearch,tvNoResult,tvAdvanceSearch;
    RecyclerView recyclerView;
    ProgressBar pbSearch;
    EditText edtSearch;
    Spinner spinnerSearch;
    Boolean isSearched = false;
    String category = "any";
    String query = "";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opac_search);
        addControl();
        actionBar();
        dropDownSpinner();
        //showDataToRecyclerView();
        checkToShowProgressBar();
        addEvent();


    }

    private void checkToShowProgressBar() {
        if(!isSearched)
        {
            pbSearch.setVisibility(View.GONE);

        }
        else
        {
        }
    }

    private void addEvent() {

    }



    private void dropDownSpinner() {
        spinnerSearch = findViewById(R.id.spinnerSearch);

        String[] items = new String[] { "Bất kỳ", "Tên hiện vật", "Tên khác",
                "Số kiểm kê", "Số lượng","Thành phần", "Niên đại" };
        final String[] arrCategory = new String[] {"ANY", "EXHIBITNAME","OTHERNAME",
                "CODEID","NUMBER","ELEMENT","AGES"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSearch.setAdapter(adapter);

        spinnerSearch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (parent.getChildAt(0) != null) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                    ((TextView) parent.getChildAt(0)).setTextSize(13);
                }
                category = arrCategory[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbarSearch);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        tvSearch = findViewById(R.id.tvSearch);
        recyclerView = findViewById(R.id.rcvSearchNormal);
        pbSearch = findViewById(R.id.pbSearchNormal);
        edtSearch = findViewById(R.id.edtSearchNormal);
        tvNoResult = findViewById(R.id.tvNoResult);
        tvAdvanceSearch = findViewById(R.id.tvAdvanceSearch);


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

}