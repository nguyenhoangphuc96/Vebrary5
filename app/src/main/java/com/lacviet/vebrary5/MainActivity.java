package com.lacviet.vebrary5;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lacviet.vebrary5.Adapter.MainscreenRecyclerViewAdapter;
import com.lacviet.vebrary5.Model.MainScreenWithImageModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    RecyclerView recyclerView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    TextView tvTitleToolbar, txtTitleCategory, tvAllCategory;
    ProgressBar pbMainScreen;
    //Dialog
    AlertDialog alertDialog;
    RecyclerView rcvCategogyName;
    RelativeLayout loToolBar, rlTitleCategory;
    //RecyclerView api
    private MainscreenRecyclerViewAdapter mAdapter;
    ArrayList<MainScreenWithImageModel> listBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        actionBar();
        setPositionTextViewTittleCategogy();
        showDataToRecyclerView();
        initlistBook();

        addEvent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                //startNormalSearchActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void addEvent() {
        txtTitleCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbMainScreen.setVisibility(View.VISIBLE);
                //showViewDialog();
            }
        });
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                showView(txtTitleCategory);

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        /*//All filter
        tvAllCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTitleCategory.setText("Tất cả");
                loadAnswers(indexPage,size);
            }
        });*/

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
        pbMainScreen.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

    }
    private void showDataToRecyclerView() {
        mAdapter = new MainscreenRecyclerViewAdapter(this, new ArrayList<MainScreenWithImageModel>(0), new MainscreenRecyclerViewAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                //startDetailActivity((int) id);

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
    private void addControl() {
        toolbar = findViewById(R.id.toolbarMainscreen);
        recyclerView = findViewById(R.id.rcvMainScreen);
        navigationView = findViewById(R.id.ngvMainscreen);
        drawerLayout = findViewById(R.id.drawerLayout);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        txtTitleCategory = findViewById(R.id.txtTitleCategory);
        pbMainScreen = findViewById(R.id.pbMainScreen);


    }
    private void setPositionTextViewTittleCategogy() {
        loToolBar = findViewById(R.id.loToolBar);
        rlTitleCategory = findViewById(R.id.rlTitleCategory);
        ViewTreeObserver vto = toolbar.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int width = loToolBar.getMeasuredWidth();
                int height = loToolBar.getMeasuredHeight();
                int tvWidth = txtTitleCategory.getMeasuredWidth();
                int tvHeight = txtTitleCategory.getMeasuredHeight();
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins((width / 2) - (tvWidth / 2), height - (tvHeight / 2) + 4, 0, 0);
                rlTitleCategory.setLayoutParams(lp);
            }
        });
    }
    private void actionBar() {
        setSupportActionBar(toolbar);
        tvTitleToolbar.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
                //hide text view categogy
                hideView(txtTitleCategory);
            }
        });
    }
    public void hideView(View view) {
        view.setVisibility(View.INVISIBLE);
    }
    public void showView(View view) {
        view.setVisibility(View.VISIBLE);
    }
}
