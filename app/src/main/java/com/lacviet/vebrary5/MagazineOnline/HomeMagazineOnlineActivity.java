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
import com.lacviet.vebrary5.Model.MagazineOnlineModel;
import com.lacviet.vebrary5.R;
import com.lacviet.vebrary5.Search.SearchOpacAdvanceActivity;

import java.util.ArrayList;

public class HomeMagazineOnlineActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TextView tvTitleToolbar, tvSearch, tvNoResult, tvAdvanceSearch;
    RecyclerView recyclerView;
    ProgressBar pbSearch;
    EditText edtSearch;
    Spinner spinnerSearch;
    Boolean isSearched = false;
    String category = "any";
    //RecyclerView api
    private MagazineOnlineRCVAdapter mAdapter;
    ArrayList<MagazineOnlineModel> listMagazine;
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
        listMagazine.add(new MagazineOnlineModel("1","Tạp chí Thế Giới Vi Tính - PC World VN / Sở Khoa học và Công nghệ TP.HCM",
                1,"http://demo.vebrary.vn/SerialOnline/ViewImageBib?BIBID=68521"));
        listMagazine.add(new MagazineOnlineModel("1","Tạp chí Xưa & Nay",
                2,"http://demo.vebrary.vn/SerialOnline/ViewImageBib?BIBID=68454"));
        listMagazine.add(new MagazineOnlineModel("1","Tạp chí thông tin và truyền thông / Bộ Thông tin và truyền thông",
                3,"http://demo.vebrary.vn/SerialOnline/ViewImageBib?BIBID=68456"));
        listMagazine.add(new MagazineOnlineModel("1","Xã hội thông tin / Tập đoàn VNPT",
                9,"http://demo.vebrary.vn/SerialOnline/ViewImageBib?BIBID=68455"));
        listMagazine.add(new MagazineOnlineModel("1","Tạp chí Văn hoá - Du lịch Đà Nẵng : Sở Văn hoá, Thể thao và Du lịch Đà Nẵng",
                14,"http://demo.vebrary.vn/SerialOnline/ViewImageBib?BIBID=64793"));
        listMagazine.add(new MagazineOnlineModel("1","EChip Mobile",
                2,"http://demo.vebrary.vn/SerialOnline/ViewImageBib?BIBID=60421"));
        listMagazine.add(new MagazineOnlineModel("1","Làm bạn với máy tính",
                1,"http://demo.vebrary.vn/SerialOnline/ViewImageBib?BIBID=60433"));
        mAdapter.updateAnswers(listMagazine);
        pbSearch.setVisibility(View.GONE);
    }
    private void showDataToRecyclerView() {
        mAdapter = new MagazineOnlineRCVAdapter(this, new ArrayList<MagazineOnlineModel>(0), new MagazineOnlineRCVAdapter.PostItemListener() {

            @Override
            public void onPostClick(String id) {

            }

        });
        /*RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);*/
        //GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        //recyclerView.setLayoutManager(layoutManager);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        /*EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (isFilter) {
                    showMoreResultByStuffId(page, size, stuffId);
                } else {
                    loadMoreAnswers(page, size);

                }
            }
        };
        recyclerView.addOnScrollListener(scrollListener);*/
    }

    private void startDetailActivity(int id) {
        Intent intent = new Intent(HomeMagazineOnlineActivity.this, DetailDigitalDocActivity.class);

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
        Intent intent = new Intent(HomeMagazineOnlineActivity.this,SearchOpacAdvanceActivity.class);
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