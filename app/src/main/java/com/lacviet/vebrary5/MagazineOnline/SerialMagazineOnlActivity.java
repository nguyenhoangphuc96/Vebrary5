package com.lacviet.vebrary5.MagazineOnline;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.lacviet.vebrary5.DigitalDocument.DetailDigitalDocActivity;
import com.lacviet.vebrary5.Model.SerialMagazineModel;
import com.lacviet.vebrary5.R;
import com.lacviet.vebrary5.Search.SearchOpacAdvanceActivity;

import java.util.ArrayList;

public class SerialMagazineOnlActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TextView tvTitleToolbar, tvSearch, tvNoResult, tvAdvanceSearch;
    RecyclerView recyclerView;
    ProgressBar pbSearch;
    EditText edtSearch;
    Spinner spinnerSearch;
    Boolean isSearched = false;
    String category = "any";
    //RecyclerView api
    private SerialMagazineOnlineRCVAdapter mAdapter;
    ArrayList<SerialMagazineModel> listMagazine;
    //
    LinearLayout loAdvanceSearch;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_magazine_online);
        addControl();
        actionBar();
        dropDownSpinner();
        setMarginRCV();
        showDataToRecyclerView();
        checkToShowProgressBar();
        addEvent();
        initlistMagazine();


    }
    private void setMarginRCV() {
        loAdvanceSearch = findViewById(R.id.loAdvanceSearch);
        ViewTreeObserver vto = toolbar.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightLoWrite = loAdvanceSearch.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams =
                        (ViewGroup.MarginLayoutParams) recyclerView.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, heightLoWrite);
                recyclerView.setLayoutParams(marginLayoutParams);
            }
        });
    }
    private void initlistMagazine() {
        listMagazine = new ArrayList<>();
        listMagazine.add(new SerialMagazineModel("1","Triệt tin nhắn rác: Cần sự kết hợp từ cả hai phía",
                "số 168 - 2017","http://demo.vebrary.vn/SerialOnline/ViewImage?SERIALID=584"));
        listMagazine.add(new SerialMagazineModel("1","Công nghệ thực tế ảo: có cơ hội phát triển tại Việt Nam?",
                "số 169 - 2017","http://demo.vebrary.vn/SerialOnline/ViewImage?SERIALID=586"));
        listMagazine.add(new SerialMagazineModel("1","Giá thành thực sự của một chiếc smartphone là bao nhiêu?",
                "số 170 - 2017","http://demo.vebrary.vn/SerialOnline/ViewImage?SERIALID=587"));
        listMagazine.add(new SerialMagazineModel("1","Việt Nam phải sớm có chiến lược chuyển đổi số quốc gia",
                "số 171 - 2017","http://demo.vebrary.vn/SerialOnline/ViewImage?SERIALID=588"));
        listMagazine.add(new SerialMagazineModel("1","MyTV có gì mới sau 8 năm ra mắt người dùng?",
                "số 172 - 2017","http://demo.vebrary.vn/SerialOnline/ViewImage?SERIALID=589"));
        listMagazine.add(new SerialMagazineModel("1","Nhà mạng tiếp tục tăng trưởng “nóng” Internet cáp quang",
                "số 173 - 2017","http://demo.vebrary.vn/SerialOnline/ViewImage?SERIALID=590"));
        listMagazine.add(new SerialMagazineModel("1","Bộ TT&TT sẽ xử lý nghiêm vấn đề ”nóng” Viễn thông",
                "số 163 - 2016","http://demo.vebrary.vn/SerialOnline/ViewImage?SERIALID=591"));
        mAdapter.updateAnswers(listMagazine);
        pbSearch.setVisibility(View.GONE);
    }
    private void showDataToRecyclerView() {
        mAdapter = new SerialMagazineOnlineRCVAdapter(this, new ArrayList<SerialMagazineModel>(0), new SerialMagazineOnlineRCVAdapter.PostItemListener() {

            @Override
            public void onPostClick(String id) {

            }

        });
        /*RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);*/
        //GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        //recyclerView.setLayoutManager(layoutManager);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void startDetailActivity(int id) {
        Intent intent = new Intent(SerialMagazineOnlActivity.this, DetailDigitalDocActivity.class);

        startActivity(intent);
    }

    private void checkToShowProgressBar() {
        if (!isSearched) {
            pbSearch.setVisibility(View.GONE);

        } else {
        }
    }

    private void addEvent() {
        tvAdvanceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAdvanceOpac();
            }
        });
    }

    private void startAdvanceOpac() {
        Intent intent = new Intent(SerialMagazineOnlActivity.this,SearchOpacAdvanceActivity.class);
        startActivity(intent);
    }


    private void dropDownSpinner() {
        spinnerSearch = findViewById(R.id.spinnerSearch);

        String[] items = new String[]{ "Tiêu đề", "Số báo",
                "Chủ đề", "Nhan đề bài viết", "Tác giả bài viết", "Bất kỳ"};
        /*final String[] arrCategory = new String[]{"ANY", "EXHIBITNAME", "OTHERNAME",
                "CODEID", "NUMBER", "ELEMENT", "AGES"};*/

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
                //category = arrCategory[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        tvSearch = findViewById(R.id.tvSearch);
        recyclerView = findViewById(R.id.rcvMagazineOnline);
        pbSearch = findViewById(R.id.pbMagazineOnline);
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