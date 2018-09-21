package com.lacviet.vebrary5.Search;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
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
import android.widget.Toast;

import com.lacviet.vebrary5.Adapter.MainscreenRecyclerViewAdapter;
import com.lacviet.vebrary5.Adapter.ResultRCVAdapter;
import com.lacviet.vebrary5.Model.MainScreenWithImageModel;
import com.lacviet.vebrary5.Model.ResultItemModel;
import com.lacviet.vebrary5.R;

import java.util.ArrayList;

public class SearchOpacActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TextView tvTitleToolbar, tvSearch, tvNoResult, tvAdvanceSearch;
    RecyclerView recyclerView;
    ProgressBar pbSearch;
    EditText edtSearch;
    Spinner spinnerSearch;
    Boolean isSearched = false;
    String category = "any";
    //RecyclerView api
    private ResultRCVAdapter mAdapter;
    ArrayList<ResultItemModel> listBook;
    //
    LinearLayout loAdvanceSearch;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opac_search);
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
        listBook.add(new ResultItemModel("1","Khoa học và công nghệ NANO","Trương Văn Tân",
                "http://xspace.talaweb.com/nxbtrithuc/home/Khoa%20hoc%20va%20cong%20nghe%20nano.jpg",
                12,257,3));
        listBook.add(new ResultItemModel("1","Tuổi trẻ không trì hoãn","Nguyễn Thị Chân Huỳnh",
                "http://static.nhasachphuongnam.com/images/thumbnails/201710_thumb/tuoi-tre-khong-tri-hoan.450x652.w.b.jpg",
                20,134,0));
        listBook.add(new ResultItemModel("1","Để ăn không phải băng khoăn","Trương Văn Tân",
                "http://static.nhanam.com.vn/thumb/0x320/crop/Books/Images/2018/1/17/865QUH2I.jpg",
                34,34,0));
        listBook.add(new ResultItemModel("1","Tìm lại chính mình","Trương Văn Tân",
                "https://bizweb.dktcdn.net/100/051/882/products/tim-lai-chinh-minh.jpg?v=1461660972650",
                10,13,3));
        listBook.add(new ResultItemModel("1","Lạc trôi","Sơn Tùng MTP",
                "https://file.tinnhac.com/resize/600x-/music/2017/01/13/roiteasingartworknganglogo1481512811-bd2c.jpg",
                12,54,3));
        mAdapter.updateAnswers(listBook);

    }
    private void showDataToRecyclerView() {
        mAdapter = new ResultRCVAdapter(this, new ArrayList<ResultItemModel>(0), new ResultRCVAdapter.PostItemListener() {

            @Override
            public void onPostClick(String id) {

            }
        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

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
        edtSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (edtSearch.getRight() - edtSearch.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        startQRBarcodeScanner();

                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void startQRBarcodeScanner() {
        Intent intent = new Intent(SearchOpacActivity.this,QRBarCodeScannerActivity.class);
        startActivity(intent);
    }

    private void startAdvanceOpac() {
        Intent intent = new Intent(SearchOpacActivity.this,SearchOpacAdvanceActivity.class);
        startActivity(intent);
    }


    private void dropDownSpinner() {
        spinnerSearch = findViewById(R.id.spinnerSearch);

        String[] items = new String[]{"Bất kỳ", "Tên hiện vật", "Tên khác",
                "Số kiểm kê", "Số lượng", "Thành phần", "Niên đại"};
        final String[] arrCategory = new String[]{"ANY", "EXHIBITNAME", "OTHERNAME",
                "CODEID", "NUMBER", "ELEMENT", "AGES"};

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