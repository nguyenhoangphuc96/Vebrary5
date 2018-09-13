package com.lacviet.vebrary5.DigitalDocument;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lacviet.vebrary5.R;
import com.squareup.picasso.Picasso;

import static com.lacviet.vebrary5.MainActivityNew.toolbar;

public class TabDescriptionDigitalDocFragment extends Fragment {
    TextView tvName,tvType, tvAuthor, tvTopic,tvPublicationDate,tvFormat, tvResource,tvLanguage,tvSeeCount,tvDownloadCount;
    ImageView imvDetail;
    ProgressBar pbImv;
    //
    LinearLayout loSame;
    ScrollView scrollView;
    //

    public TabDescriptionDigitalDocFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_description_digitaldoc,container,false);
        addControl(view);
        setMarginRCV(view);
        tempData();
        return view;
    }


    private void setMarginRCV(View view) {
        loSame = view.findViewById(R.id.loSame);
        scrollView = view.findViewById(R.id.scrollView);
        ViewTreeObserver vto = toolbar.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightLoWrite = loSame.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams =
                        (ViewGroup.MarginLayoutParams) scrollView.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, heightLoWrite);
                scrollView.setLayoutParams(marginLayoutParams);
            }
        });
    }
    private void tempData() {
        pbImv.setVisibility(View.GONE);
        tvName.setText("NHƯ LAI THẦN CHƯỞNG");
        tvType.setText("Books - Sách");
        tvAuthor.setText("Liễu Tàn Dương");
        tvTopic.setText("Kiếm hiệp");
        tvPublicationDate.setText("27 tháng 12 năm 2003");
        tvFormat.setText(".pdf");
        tvResource.setText("Chinese");
        tvLanguage.setText("chi/zho,");
        tvSeeCount.setText("60");
        tvDownloadCount.setText("10");
        Picasso.with(getContext()).load("http://demo.vebrary.vn/DigitalDocument/ViewImage/?docFileId=8359").into(imvDetail);
    }

    private void addControl(View view) {
        tvName = view.findViewById(R.id.tvName);
        tvType = view.findViewById(R.id.tvType);
        tvAuthor = view.findViewById(R.id.tvAuthor);
        tvTopic = view.findViewById(R.id.tvTopic);
        tvPublicationDate = view.findViewById(R.id.tvPublicationDate);
        tvFormat = view.findViewById(R.id.tvFormat);
        tvResource = view.findViewById(R.id.tvResource);
        tvLanguage = view.findViewById(R.id.tvLanguage);
        tvSeeCount = view.findViewById(R.id.tvSeeCount);
        tvDownloadCount = view.findViewById(R.id.tvDownloadCount);
        imvDetail = view.findViewById(R.id.imvDetail);
        pbImv = view.findViewById(R.id.pbImageDetail);
    }
}