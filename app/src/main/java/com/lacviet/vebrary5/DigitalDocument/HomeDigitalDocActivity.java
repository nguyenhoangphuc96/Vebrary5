package com.lacviet.vebrary5.DigitalDocument;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
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

import com.lacviet.vebrary5.Adapter.MainscreenRecyclerViewAdapter;
import com.lacviet.vebrary5.Adapter.ResultRCVAdapter;
import com.lacviet.vebrary5.Detail.DetailActivity;
import com.lacviet.vebrary5.MainActivity;
import com.lacviet.vebrary5.Model.MainScreenWithImageModel;
import com.lacviet.vebrary5.Model.ResultItemModel;
import com.lacviet.vebrary5.R;
import com.lacviet.vebrary5.Search.SearchOpacActivity;
import com.lacviet.vebrary5.Search.SearchOpacAdvanceActivity;

import java.util.ArrayList;

public class HomeDigitalDocActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TextView tvTitleToolbar, tvSearch, tvNoResult, tvAdvanceSearch;
    RecyclerView recyclerView;
    ProgressBar pbSearch;
    EditText edtSearch;
    Spinner spinnerSearch;
    Boolean isSearched = false;
    String category = "any";
    //RecyclerView api
    private MainscreenRecyclerViewAdapter mAdapter;
    ArrayList<MainScreenWithImageModel> listBook;
    //
    LinearLayout loAdvanceSearch;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_digital_document);
        addControl();
        actionBar();
        dropDownSpinner();
        setMarginRCV();
        showDataToRecyclerView();
        checkToShowProgressBar();
        addEvent();
        initlistBook();


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
    private void initlistBook() {
        listBook = new ArrayList<>();
        listBook.add(new MainScreenWithImageModel(1,"Bóng ma kí ức","Gilian Glyn",
                "https://gacsach.com/diendan/attachments/bongmakyuc-jpg.15483/"));
        listBook.add(new MainScreenWithImageModel(2,"Đời ngắn đừng ngủ","Robin Sharima",
                "https://www.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/d/o/doi-ngan-dung-ngu-dai-bia.jpg"));
        listBook.add(new MainScreenWithImageModel(3,"Hạnh phúc tùy cách","Viên Ngộ",
                "http://phatgiao.org.vn/Images/Contents/anhminh/20140220/Bia_Hanh-phuc-tuy-cach-nhin_FuLL-01.jpg"));
        listBook.add(new MainScreenWithImageModel(4,"Thời gian trôi mãi","Lạc Thác",
                "http://webtruyen.com/public/images/thoigiantroimaifNVdyigqpS.jpg"));
        listBook.add(new MainScreenWithImageModel(5,"Lạc trôi","Sơn Tùng MTP",
                "http://media.tinmoi.vn/2016/12/12/LAC%20TROI%20-%20TEASING%20ARTWORK%20doc%20-%20logo.jpg"));
        listBook.add(new MainScreenWithImageModel(8,"Nơi ánh đèn rực rỡ","Thanh Sam",
                "http://cdnvn.truyenfull.vn/cover/o/eJzLyTDW1w02KbYoNKxwqnAJ1Q_LN45MSs12Sgr21HeEAvd4T33dwoCU0HQf41xvC_1iA13PZBMjAC4oEdg=/noi-anh-den-ruc-ro.jpg"));
        listBook.add(new MainScreenWithImageModel(6,"Đi để trở về","Soobin Hoàng Sơn",
                "https://avatar-nct.nixcdn.com/song/2017/11/01/8/9/5/4/1509521523781_640.jpg"));
        listBook.add(new MainScreenWithImageModel(7,"Dùng Thiền Tâm","Thích Thanh Nghiêm",
                "https://d24jkk6qpv9gim.cloudfront.net/6133/Images/cover_l.jpg"));
        mAdapter.updateAnswers(listBook);
        pbSearch.setVisibility(View.GONE);
    }
    private void showDataToRecyclerView() {
        mAdapter = new MainscreenRecyclerViewAdapter(this, new ArrayList<MainScreenWithImageModel>(0), new MainscreenRecyclerViewAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                startDetailActivity((int) id);

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
        Intent intent = new Intent(HomeDigitalDocActivity.this, DetailDigitalDocActivity.class);

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
        Intent intent = new Intent(HomeDigitalDocActivity.this,SearchOpacAdvanceActivity.class);
        startActivity(intent);
    }


    private void dropDownSpinner() {
        spinnerSearch = findViewById(R.id.spinnerSearch);

        String[] items = new String[]{ "Tiêu đề", "Tác giả",
                "Chủ đề", "Mô tả", "Nhà xuất bản", "Tác giả phụ","Ngày xuất bản", "Định dạng","Bất kỳ"};
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
        recyclerView = findViewById(R.id.rcvDigitalDoc);
        pbSearch = findViewById(R.id.pbDigitalDoc);
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