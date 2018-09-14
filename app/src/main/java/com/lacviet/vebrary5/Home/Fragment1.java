package com.lacviet.vebrary5.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.lacviet.vebrary5.Adapter.MainscreenRecyclerViewAdapter;
import com.lacviet.vebrary5.Adapter.NewBookRCVAdapter;
import com.lacviet.vebrary5.Adapter.ResultRCVAdapter;
import com.lacviet.vebrary5.Detail.DetailActivity;
import com.lacviet.vebrary5.MainActivity;
import com.lacviet.vebrary5.Model.MainScreenWithImageModel;
import com.lacviet.vebrary5.Model.ResultItemModel;
import com.lacviet.vebrary5.R;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    //RecyclerView fragment2
    RecyclerView recyclerView;
    NewBookRCVAdapter mAdapter;
    ArrayList<MainScreenWithImageModel> listBook;
    ProgressBar pbFragment1;


    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_main, container, false);
        addControls(view);
        showDataToRecyclerView();
        initlistBook();
        addEvents();
        return view;
    }
    private void initlistBook() {
        pbFragment1.setVisibility(View.GONE);
        listBook = new ArrayList<>();
        listBook.add(new MainScreenWithImageModel(1,"Bóng ma kí ức","Gilian Glyn",
        "https://www.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/i/m/image_119757.jpg"));
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

    }
    private void showDataToRecyclerView() {
        mAdapter = new NewBookRCVAdapter(getContext(), new ArrayList<MainScreenWithImageModel>(0), new NewBookRCVAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
            startDetailActivity(id);
            }
        });
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
    }
    private void startDetailActivity(long id) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);

        startActivity(intent);
    }
    private void addEvents() {

    }


    private void addControls(View view) {
        recyclerView = view.findViewById(R.id.rcvFragment1);
        pbFragment1 = view.findViewById(R.id.pbFragment1);
    }

}