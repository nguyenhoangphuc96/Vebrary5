package com.lacviet.vebrary5.News;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.lacviet.vebrary5.Model.ContentModel;
import com.lacviet.vebrary5.R;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailEducationNewsActivity extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar pbDetail;
    LinearLayout loBody;
    TextView tvTitle, tvTime, tvSubTitle, textView;

    //
    String id;
    String title = "";
    String time = "";
    String subtitle = "";
    String image = "";
    String text = "";
    List<ContentModel> listContent;
    //
    View layoutImage, layoutText, layoutAuthor;
    //change size
    float sizeTitleDefault, sizeContentDefault, sizeTimeDefault, sizeTitle, sizeContent, sizeTime, sizecaptionImage;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        addControl();
        actionBar();
        textSize();
        tempData();
    }

    private void loadContent(List<ContentModel> list) {
        //body
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType() == 2) {
                layoutImage = LayoutInflater.from(DetailEducationNewsActivity.this).inflate(R.layout.item_image, loBody, false);

                textView = layoutImage.findViewById(R.id.tvImageText);
                ImageView imgView = layoutImage.findViewById(R.id.imvImage);
                image = list.get(i).getValue();


                if(i<list.size()-1) {
                    text = list.get(i + 1).getValue();
                    textView.setText(text);
                }
                else {
                    textView.setText("");
                }

                //

                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizecaptionImage);
                Picasso.with(DetailEducationNewsActivity.this).load(image).into(imgView);

                loBody.addView(layoutImage);
                i++;

            } else {
                layoutText = LayoutInflater.from(DetailEducationNewsActivity.this).inflate(R.layout.item_text, loBody, false);

                textView = (TextView) layoutText.findViewById(R.id.tvText);

                textView.setText(list.get(i).getValue());
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeContent);

                loBody.addView(layoutText);
            }
        }


    }
    private void tempData() {
        pbDetail.setVisibility(View.GONE);
        //
        tvTitle.setText("Giáo dục nhi đồng là một khoa học");
        tvTime.setText("27/08/2014");
        tvSubTitle.setText("Là một nhà giáo dục vĩ đại, Chủ tịch Hồ Chí Minh luôn coi trọng việc giáo dục thế hệ trẻ. Với những người trực tiếp tham gia công tác thiếu nhi, Người hướng dẫn không chỉ nội dung mà cả phương pháp giáo dục.");
        //
        listContent = new ArrayList<>();
        listContent.add(new ContentModel(2,"http://demo.vebrary.vn/News/DisplayImage/?itemID=1563",1));
        listContent.add(new ContentModel(1,"Là một nhà giáo dục vĩ đại, Chủ tịch Hồ Chí Minh luôn coi trọng việc giáo dục thế hệ trẻ. Với những người trực tiếp tham gia công tác thiếu nhi, Người hướng dẫn không chỉ nội dung mà cả phương pháp giáo dục.",2));
        loadContent(listContent);
    }

    private void textSize() {
        TypedValue varSizeTitle = new TypedValue();
        getResources().getValue(R.dimen.textsize_title_default, varSizeTitle, true);
        sizeTitleDefault = varSizeTitle.getFloat();
        sizeTitle = varSizeTitle.getFloat();
        //
        TypedValue varSizeContent = new TypedValue();
        getResources().getValue(R.dimen.textsize_content_default, varSizeContent, true);
        sizeContentDefault = varSizeContent.getFloat();
        sizeContent = varSizeContent.getFloat();
        //
        TypedValue varSizeTime = new TypedValue();
        getResources().getValue(R.dimen.textsize_time_default, varSizeTime, true);
        sizeTimeDefault = varSizeTime.getFloat();
        sizeTime = varSizeTime.getFloat();
        //
        sizecaptionImage = 15;
    }
    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        pbDetail = findViewById(R.id.pbDetail);
        loBody = findViewById(R.id.loBody);
        tvTitle = findViewById(R.id.tvTitle);
        tvTime = findViewById(R.id.tvTime);
        tvSubTitle = findViewById(R.id.tvSubTitle);
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
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
