package com.lacviet.vebrary5.News;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lacviet.vebrary5.Model.NewsModel;
import com.lacviet.vebrary5.R;

import java.util.ArrayList;
import java.util.List;

public class EducationNewsActivity extends AppCompatActivity{
    private Toolbar toolbar;
    private TextView tvTitleToolbar;
    RecyclerView recyclerView;
    ProgressBar pbNews;
    NewsRCVAdapter mAdapter;
    List<NewsModel> listNews;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_news);
        addControl();
        actionBar();
        showDataToRecyclerView();
        tempData();
    }

    private void tempData() {
        listNews = new ArrayList<>();
        listNews.add(new NewsModel("1","Giáo dục nhi đồng là một khoa học","",
                "Là một nhà giáo dục vĩ đại, Chủ tịch Hồ Chí Minh luôn coi trọng việc giáo dục thế hệ trẻ. Với những người trực tiếp tham gia công tác thiếu nhi, Người hướng dẫn không chỉ nội dung mà cả phương pháp giáo dục.",
                "27/08/2014",
                "http://demo.vebrary.vn/News/DisplayImage/?customerId=DEFAULT&itemID=1563&17:13:09,%2017/9/2018"));
        listNews.add(new NewsModel("1","Khai giảng niên học THPT trực tuyến đầu tiên","",
                "Sáng 27/8, Công ty cổ phần Trường học Trực tuyến Sài Gòn đã chính thức khai giảng niên học đầu tiên 2014 -2015 của Trường học trực tuyến Sài Gòn (ISS – Internet School of Saigon) dành cho chương trình Trung học Phổ thông (THPT) trên website www.thpt.iss.edu.vn. Đây là mô hình dạy học mới, vừa bám sát mục tiêu, cập nhật những đổi mới của chương trình giáo dục quốc gia, vừa năng động, hiện đại nhằm phát huy tính tích cực, chủ động của học sinh.",
                "27/08/2014",
                "http://demo.vebrary.vn/News/DisplayImage/?customerId=DEFAULT&itemID=1579&17:13:09,%2017/9/2018"));
        listNews.add(new NewsModel("1","Ra mắt trường học trực tuyến dành cho học sinh THPT","",
                "Là một nhà giáo dục vĩ đại, Chủ tịch Hồ Chí Minh luôn coi trọng việc giáo dục thế hệ trẻ. Với những người trực tiếp tham gia công tác thiếu nhi, Người hướng dẫn không chỉ nội dung mà cả phương pháp giáo dục.",
                "27/08/2014",
                "http://demo.vebrary.vn/News/DisplayImage/?customerId=DEFAULT&itemID=1603&17:13:09,%2017/9/2018"));
        listNews.add(new NewsModel("1","Hội thảo quốc tế về “Tâm lý học đường” lần thứ IV","",
                "Là một nhà giáo dục vĩ đại, Chủ tịch Hồ Chí Minh luôn coi trọng việc giáo dục thế hệ trẻ. Với những người trực tiếp tham gia công tác thiếu nhi, Người hướng dẫn không chỉ nội dung mà cả phương pháp giáo dục.",
                "27/08/2014",
                "http://demo.vebrary.vn/News/DisplayImage/?customerId=DEFAULT&itemID=1574&17:13:09,%2017/9/2018"));
        listNews.add(new NewsModel("1","Giáo dục nhi đồng là một khoa học","",
                "Là một nhà giáo dục vĩ đại, Chủ tịch Hồ Chí Minh luôn coi trọng việc giáo dục thế hệ trẻ. Với những người trực tiếp tham gia công tác thiếu nhi, Người hướng dẫn không chỉ nội dung mà cả phương pháp giáo dục.",
                "27/08/2014",
                "http://demo.vebrary.vn/News/DisplayImage/?customerId=DEFAULT&itemID=1563&17:13:09,%2017/9/2018"));
        mAdapter.updateAnswers(listNews);
        pbNews.setVisibility(View.GONE);

    }

    private void showDataToRecyclerView() {
        mAdapter = new NewsRCVAdapter(EducationNewsActivity.this, new ArrayList<NewsModel>(0), new NewsRCVAdapter.PostItemListener() {


            @Override
            public void onPostClick(String id, String title, String time, String subTitle) {
                startDetailActivity(id);
            }

        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    private void startDetailActivity(String id) {
        Intent intent = new Intent(EducationNewsActivity.this,DetailEducationNewsActivity.class);
        startActivity(intent);
    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        recyclerView = findViewById(R.id.rcvNews);
        pbNews = findViewById(R.id.pbNews);

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
