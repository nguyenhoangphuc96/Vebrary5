package com.lacviet.vebrary5.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lacviet.vebrary5.Adapter.ResultRCVAdapter;
import com.lacviet.vebrary5.Detail.DetailActivity;
import com.lacviet.vebrary5.Model.ResultItemModel;
import com.lacviet.vebrary5.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    //RecyclerView fragment2
    RecyclerView recyclerView;
    private ResultRCVAdapter mAdapter;
    ArrayList<ResultItemModel> listBook;
    ProgressBar pbFragment2;


    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_main, container, false);
        addControls(view);
        showDataToRecyclerView();
        initlistBook();
        addEvents();
        return view;
    }

    private void initlistBook() {
        pbFragment2.setVisibility(View.GONE);
        listBook = new ArrayList<>();
        listBook.add(new ResultItemModel("1", "Khoa học và công nghệ NANO", "Trương Văn Tân",
                "http://xspace.talaweb.com/nxbtrithuc/home/Khoa%20hoc%20va%20cong%20nghe%20nano.jpg",
                12, 257, 3));
        listBook.add(new ResultItemModel("1", "Tuổi trẻ không trì hoãn", "Nguyễn Thị Chân Huỳnh",
                "http://static.nhasachphuongnam.com/images/thumbnails/201710_thumb/tuoi-tre-khong-tri-hoan.450x652.w.b.jpg",
                20, 134, 0));
        listBook.add(new ResultItemModel("1", "Để ăn không phải băng khoăn", "Trương Văn Tân",
                "http://static.nhanam.com.vn/thumb/0x320/crop/Books/Images/2018/1/17/865QUH2I.jpg",
                34, 34, 0));
        listBook.add(new ResultItemModel("1", "Tìm lại chính mình", "Trương Văn Tân",
                "https://bizweb.dktcdn.net/100/051/882/products/tim-lai-chinh-minh.jpg?v=1461660972650",
                10, 13, 3));
        listBook.add(new ResultItemModel("1", "Lạc trôi", "Sơn Tùng MTP",
                "https://file.tinnhac.com/resize/600x-/music/2017/01/13/roiteasingartworknganglogo1481512811-bd2c.jpg",
                12, 54, 3));
        mAdapter.updateAnswers(listBook);

    }

    private void showDataToRecyclerView() {
        mAdapter = new ResultRCVAdapter(getContext(), new ArrayList<ResultItemModel>(0), new ResultRCVAdapter.PostItemListener() {

            @Override
            public void onPostClick(String id) {
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
        recyclerView.setNestedScrollingEnabled(false);

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

    private void startDetailActivity(String id) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);

        startActivity(intent);
    }

    private void addEvents() {

    }


    private void addControls(View view) {
        recyclerView = view.findViewById(R.id.rcvFragment2);
        pbFragment2 = view.findViewById(R.id.pbFragment2);
    }

}